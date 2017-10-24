package loginModule.testCase.login;

import seleniumHelper.LoginKeywords;

public class LoginCase {
	
	public static void login(String s1,String s2,String s3,String s4){
		LoginKeywords.OpenBrowser(s1);
		LoginKeywords.Navigate(s2);
		
		LoginKeywords.Input_Content(s3);
		LoginKeywords.Search_Click(s4);
		LoginKeywords.CloseBrowser("");
		
		
	}




}
