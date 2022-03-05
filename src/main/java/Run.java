import exceptions.TableNotCreatedException;
import test.Test;

public class Run {

    //Single line comment

    /*
    Multi line comment
     */

    //   Javadoc Example -

    /**
     * Run Class -
     * The run Class is used in order to instantiate
     * the Program of coupons
     */

    public static void main(String[] args) {
        try {
            Test.testAll();
        } catch (TableNotCreatedException err) {
            System.out.println(err.getMessage());
        }
    }

}
