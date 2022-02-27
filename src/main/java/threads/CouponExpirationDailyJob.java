package threads;

import db.db_manager.DBManagerCoupons;
import utils.DBTools;

public class CouponExpirationDailyJob implements Runnable {
    private boolean isRunning;

    public CouponExpirationDailyJob() {
        this.isRunning = true;
    }

    @Override
    public void run() {
        System.out.println("The daily job is running");
        while (isRunning) {
            DBTools.runQuery(DBManagerCoupons.DELETE_EXPIRED_COUPONS);
            System.out.println("The daily job has finished the check");
            try {
                Thread.sleep(1000 * 60 * 2);
            } catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    public void stop() {
        System.out.println("The daily job has stopped running");
        this.isRunning = false;
    }
}
