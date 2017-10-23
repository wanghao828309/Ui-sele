package selenium_test01;

import org.testng.annotations.Test;


public class SeleTest {
	
	
	@Test
	public void test(){
//		ChromeDriver c = (ChromeDriver) DriverFactory.getInstance().getChromeDriver();
//		SessionId sessionId = c.getSessionId();
//		System.out.println(sessionId.toString());
		
//		String path = this.getClass().getClassLoader().getResource("/").getPath();
//		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		
	}

}
