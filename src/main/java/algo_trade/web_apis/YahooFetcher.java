package algo_trade.web_apis;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 */
public class YahooFetcher extends WebActor implements HistoryFetcher {
    WebDriver driver;
    ArrayList<Double> closings;
    ArrayList<Double> openings;
    ArrayList<Double> highs;
    ArrayList<Double> lows;

    /**
     * Accepts the cookies of website finance.yahoo.com, given that it uses cookies and they need to be accepted.
     */
    private void accept_cookies(){
        if(driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/div[2]/button[1]")) != null){
            System.out.println("::====================::     Cookies being accepted     ::====================::");
            driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/div[2]/button[1]")).click();
        }
    }

    private void wait_for_load(int max_time){
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(max_time));
        waiter.until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }


    /**
     * Constructor for company-data with the chrome-dirver which get's yahoo-finances first 150 days most important values (highest, lowest, opening and closing).
     * 
     * @param company_isin
    */
    public YahooFetcher(String company_isin){
        driver = new ChromeDriver();
        driver.get("https://finance.yahoo.com/");
        driver.manage().window().maximize();
        accept_cookies();
        wait_for_load(10);

        insertIntoInputByXpath("/html/body/div[2]/header/div/div/div/div[2]/div/div[1]/div[3]/form/input[1]", company_isin, this.driver);
        click_element_id("ybar-search");

        System.out.println("=====================================       " + driver.getCurrentUrl() + "       =====================================");
        
        click_element_xpath("/html/body/div[2]/main/section/section/aside/section/nav/ul/li[6]/a", this.driver);

        System.out.println("Getting page for historical data...");

        wait_for_load(25);
        WebElement data_table = get_element_xpath("/html/body/div[2]/main/section/section/section/article/div[2]/div[3]/table/tbody", this.driver);
        WebElement row;
        openings = new ArrayList<>();
        highs = new ArrayList<>();
        lows = new ArrayList<>();
        closings = new ArrayList<>();

        for(int i = 0; i < 150; i++){
            row = data_table.findElements(By.tagName("tr")).get(i);
            try {
                openings.add(i, Double.parseDouble(row.findElements(By.tagName("td")).get(1).getText()));
                highs.add(i, Double.parseDouble(row.findElements(By.tagName("td")).get(2).getText()));
                lows.add(i, Double.parseDouble(row.findElements(By.tagName("td")).get(3).getText()));
                closings.add(i, Double.parseDouble(row.findElements(By.tagName("td")).get(4).getText()));
            } catch(Exception e ) { System.out.println("Unable to find for " + row.findElements(By.tagName("td")).get(0).getText()); }
        }       
    }

    @Override
    public ArrayList<Double> get_openings() {
        return this.openings;
    }

    @Override
    public ArrayList<Double> get_closings() {
        return this.closings;
    }

    @Override
    public ArrayList<Double> get_lowest() {
        return this.lows;
    }

    @Override
    public ArrayList<Double> get_highest() {
        return this.highs;
    }
}