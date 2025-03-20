package algo_trade.authentication;


/**
 * Interface for authenticating users of some sort
 */
public interface Authenticator {

    /**
     * Authenticate the users
     */
    public boolean authenticate(String username, String password);
}