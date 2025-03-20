package algo_trade.db_adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserAdapter {
    private static final String psql_user = "postgres";
    private static final String psql_url = "jdbc://localhost/postgres";
    private static final String psql_pass = "mypass";

    private static Connection get_connection() throws SQLException{
        Connection conn = DriverManager.getConnection(psql_url, psql_user, psql_pass);
        return conn;
    }

    /**
     * Gives you the password of a user
     * @param user The username of the user in question
     * @return The password of said user
     */
    public static String get_password(String user){
        try(Connection conn = get_connection()){
            PreparedStatement get_pass_SQL = conn.prepareStatement("SELECT password FROM Users WHERE name = ?");
            get_pass_SQL.setString(1, user);
            ResultSet res = get_pass_SQL.executeQuery();
            if(res.next())
                return res.getString("password");
        }
        catch(SQLException e){
            System.err.println("RUNTIME ERROR: password for user " + user + " could not be found. Code:\n" + e.getMessage());
            return null;
        }
        return null;
    }
}
