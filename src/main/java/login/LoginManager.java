package login;

import db.ConnectionPool;
import facades.ClientFacade;

import java.sql.SQLException;

public class LoginManager {
    private LoginManager instance = null;

    private LoginManager() {
        System.out.println("A new login manager instance was created...");
    }

    public LoginManager getInstance() {
        //First, check that instance is null
        if (instance == null) {
            //Synchronized-critical code , makes sure that another thread will not pass here
            synchronized (LoginManager.class) {
                //Double-check, that no other thread has already created an instance
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public ClientFacade login(String email, String password, ClientType clientType) {
        return null;
    }

}
