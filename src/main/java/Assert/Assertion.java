package Assert;


import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

import utils.TakeScreenShot;



/**
 * Created by LITP on 2016/9/21.
 */

public class Assertion {


    public static boolean flag = true;  
    public static boolean results = true; 


	public static List<Error> errors = new ArrayList<Error>();    


    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
            setResults(false);
            TakeScreenShot.takeScreenShot();
//            StartEngine_Excel.setbResult(false);
//            StartEngine_loginModule.setbResult(false);
        }
    }



    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
//            StartEngine_loginModule.setbResult(false);
        }
    }
    
    public static boolean isResults() {
		return results;
	}



	public static void setResults(boolean results) {
		Assertion.results = results;
	}



}