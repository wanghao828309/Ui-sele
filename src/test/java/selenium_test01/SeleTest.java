package selenium_test01;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

import seleniumHelper.DriverFactory;

public class SeleTest {
	
	
	@Test
	public void test(){
		ChromeDriver c = (ChromeDriver) DriverFactory.getInstance().getChromeDriver();
		SessionId sessionId = c.getSessionId();
		System.out.println(sessionId.toString());
	}

}
