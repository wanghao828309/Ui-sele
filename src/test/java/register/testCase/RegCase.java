package register.testCase;

import seleniumHelper.LoginKeywords;

public class RegCase {
	
	public static void register(String s1,String s2,String s4){
		LoginKeywords.OpenBrowser(s1);
		LoginKeywords.Navigate(s2);
		
		LoginKeywords.Search_Click(s4);
		LoginKeywords.CloseBrowser("");
		
		
	}




}
