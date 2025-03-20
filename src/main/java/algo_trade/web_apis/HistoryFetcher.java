package algo_trade.web_apis;

import java.util.ArrayList;

public interface HistoryFetcher {
    ArrayList<Double> get_openings();
    ArrayList<Double> get_closings();
    ArrayList<Double> get_lowest();
    ArrayList<Double> get_highest();
}
