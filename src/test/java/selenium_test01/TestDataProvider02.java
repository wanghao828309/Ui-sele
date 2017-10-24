package selenium_test01;

import org.testng.annotations.Test;

import login.testCase.loginDataProvider;

public class TestDataProvider02{

    @Test(dataProvider="loginProvider",dataProviderClass=loginDataProvider.class)
    public  void loginRight(String s1){
    	
    	System.out.println(s1+"");
    	

    }

}

