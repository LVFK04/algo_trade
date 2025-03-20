package algo_trade.authentication;

import algo_trade.db_adapter.UserAdapter;

public abstract class UserAuthenticator implements Authenticator{

    /**
     * Public method to authenticate a user, checking the credentials against the user-table in the database
     * @author Viktor F. Kristiansson
     * @since 16-03-2025
     */
    @Override
    public boolean authenticate(String user, String password) {
        return UserAdapter.get_password(user).equals(password);
    }
    
}