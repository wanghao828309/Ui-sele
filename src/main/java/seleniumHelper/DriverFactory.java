package seleniumHelper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;






public class DriverFactory {
	private static DriverFactory driverfactory;
	private static WebDriver driver = null;
	private static  Logger log =LogManager.getLogger(DriverFactory.class.getName());

	public DriverFactory() {

	}

	
	public static DriverFactory getInstance() {
		if (driverfactory == null) {
			synchronized (DriverFactory.class) {
				driverfactory = new DriverFactory();
			}
		}
		return driverfactory;
	}

	
	/**
	 * @author young Call GC
	 */
	public static void close() {
		if (driverfactory != null) {
			driverfactory = null;
		}
	}
	
	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.ie.driver", "D:\\python-2.7.11\\geckodriver.exe");
		ProfilesIni pi = new ProfilesIni();
		FirefoxProfile profile = pi.getProfile("default");
		FirefoxOptions firefoxOptions=new FirefoxOptions();
		firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver(firefoxOptions);
		
		log.info("Create FirefoxDriver ");
		//driver = new FirefoxDriver();
		return driver;	
	}
	
	
	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dike\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();  
		
		log.info("Create ChromeDriver ");
		return driver;	
	}
	
	public WebDriver getIEDriver() {
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");

		log.info("Create IEDriverServer ");
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(dc);
		return driver;
	}
	


	public WebDriver getDriver() {
		return driver;
	}

}
