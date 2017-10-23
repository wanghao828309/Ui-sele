package login.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import register.testCase.StartEngine_RegCase;
import seleniumHelper.LoginKeywords;
import utils.Contants;
import utils.StartEngine_Excel;

/**
 * Hello world!
 *
 */
public class LoginTest 
{
	LoginKeywords lk=null;
	
    @BeforeClass
    public void testBefore() {
    	lk=new LoginKeywords();

	} 
	
    @Test(enabled=false)
    public void testLogin() {
    	StartEngine_Excel.StartEngine(lk,Contants.caseLoginSheet);

	}
    
    @Test(enabled=false)
    public void testRegister() {
    	StartEngine_Excel.StartEngine(lk,Contants.caseRegisterSheet);

	}
    
	@Test(dataProvider="excelProvider",dataProviderClass=loginDataProvider.class)
	public void test(String sRowNum,String s1,String s2,String s3,String s4){
//		System.out.println(s1);
		StartEngine_LoginCase.StartEngine(sRowNum,s1, s2, s3, s4);
		
	}
    
	
    @AfterMethod
    public void testAfter() {
    	LoginKeywords.CloseBrowser("");

	} 
    
}
