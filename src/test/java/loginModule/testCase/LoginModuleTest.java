package loginModule.testCase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import seleniumHelper.LoginKeywords;

/**
 * Hello world!
 *
 */
public class LoginModuleTest 
{
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	
    @BeforeClass
    public void testBefore() {
    	System.setProperty(ESCAPE_PROPERTY, "false");

	} 
    
	@Test(dataProvider="excelProvider",dataProviderClass=loginDataProvider.class)
	public void test(String sRowNum,String s1,String s2,String s3,String s4){
//		System.out.println(s1);
		StartEngine_loginModule.StartEngine(sRowNum,s1, s2, s3, s4);
		
	}
	
	@Test(dataProvider="data02Provider",dataProviderClass=loginDataProvider.class)
	public void test02(String sRowNum,String s1,String s2,String s3){
		String s4=null;
		StartEngine_loginModule.StartEngine(sRowNum,s1, s2, s3, s4);
		
	}
    
	
    @AfterMethod
    public void testAfter() {
    	LoginKeywords.CloseBrowser("");

	} 
    
}
