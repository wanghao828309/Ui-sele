package seleniumHelper;



import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import Assert.Assertion;
import utils.Contants;
import utils.OrpUtil;

public class LoginKeywords{
	private static RemoteWebDriver driver;

	public static void OpenBrowser(String OR) {
		// System.setProperty("webdriver.gecko.driver", "C:/Program Files
		// (x86)/Mozilla Firefox/geckodriver.exe");
		if(OR.equals("ie")){
			driver = (RemoteWebDriver) DriverFactory.getInstance().getIEDriver();
		}else if (OR.equals("chrome")) {
			driver = (RemoteWebDriver) DriverFactory.getInstance().getChromeDriver();
		}else {
			driver = (RemoteWebDriver) DriverFactory.getInstance().getFirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void Navigate(String OR) {
		String baseUrl = Contants.url;
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath(OrpUtil.readValue("Button"))).getAttribute("value");
		System.out.println(text);
		Assertion.verifyEquals(text, "百度一下2");
//		StartEngine_loginModule.setbResult(false);
//		assertEquals(text, "百度一下1");
	}

	public static void Input_Content(String OR) {
//		driver.findElement(By.cssSelector("#kw")).sendKeys(OR);
		driver.findElement(By.xpath(OrpUtil.readValue("Input"))).clear();
		driver.findElement(By.xpath(OrpUtil.readValue("Input"))).sendKeys(OR);
	}

	public static void Search_Click(String OR) {
		driver.findElement(By.xpath(OrpUtil.readValue("Button"))).click();
	}

	public static void CloseBrowser(String OR) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.close();
		driver.quit();
	}

}
