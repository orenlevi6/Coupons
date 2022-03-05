package test;

import db.ConnectionPool;
import exceptions.TableNotCreatedException;
import threads.CouponExpirationDailyJob;

public class Test {
    public static void testAll() throws TableNotCreatedException {

        SchemaTest.createSchema();
        System.out.println();

//        AdminFacadeTest.testAdminFacade();
//        System.out.println();
//
//        CompanyFacadeTest.testCompanyFacade1();
//        System.out.println();
//
//        CompanyFacadeTest.testCompanyFacade2();
//        System.out.println();
//
//        CustomerFacadeTest.testCustomerFacade();
//        System.out.println();
//
//        CouponExpirationDailyJob dailyJob = new CouponExpirationDailyJob();
//        Thread thread = new Thread(dailyJob);
//        thread.start();
//
//        dailyJob.stop();
//
//        try {
//            ConnectionPool.getInstance().closeAllConnections();
//        } catch (InterruptedException err) {
//            System.out.println(err.getMessage());
//        }
    }

}
