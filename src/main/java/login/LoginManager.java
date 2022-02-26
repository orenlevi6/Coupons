package login;

import facades.AdminFacade;
import facades.ClientFacade;
import facades.CompanyFacade;
import facades.CustomerFacade;

public class LoginManager {
    private ClientFacade adminFacade = new AdminFacade();
    private ClientFacade companyFacade = new CompanyFacade();
    private ClientFacade customerFacade = new CustomerFacade();

    private static LoginManager instance = null;


    private LoginManager() {
        System.out.println("A new login manager instance was created...");
    }

    public static LoginManager getInstance() {
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
        switch (clientType) {
            case ADMINISTRATOR:
                if (adminFacade.login(email, password)){
                    return adminFacade;
                }
                    break;
            case COMPANY:
                if (companyFacade.login(email, password)) {
                    return companyFacade;
                }
            case CUSTOMER:
                if (customerFacade.login(email, password)) {
                    return customerFacade;
                }
            default:
                System.out.println("Invalid values");
                return null;
        }
        return null;
    }

}
