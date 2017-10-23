package Assert;



import utils.StartEngine_Excel;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


/**
 * Created by LITP on 2016/9/21.
 */

public class Assertion {


    public static boolean flag = true;                     

    public static List<Error> errors = new ArrayList<Error>();    


    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
//            StartEngine_Excel.setbResult(false);
            StartEngine_Excel.setbResult(false);
        }
    }



    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            StartEngine_Excel.setbResult(false);
        }
    }
}