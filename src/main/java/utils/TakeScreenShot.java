package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import seleniumHelper.DriverFactory;

public class TakeScreenShot {
	private static Logger log = LogManager.getLogger(TakeScreenShot.class.getName());
	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
	public static void takeScreenShot() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		WebDriver currentDriver = DriverFactory.getInstance().getDriver();
		//log.info(currentDriver.getTitle() + "\n");
		String path = dateStr + ".jpg";
		takeScreenShot((TakesScreenshot) currentDriver, path);
	}

	/**
	 * @author Young
	 * @param drivername
	 * @param path
	 */
	public static void takeScreenShot(TakesScreenshot drivername, String path) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name
		String currentPath = System.getProperty("user.dir"); // get current work
		Reporter.log("<img src='"+currentPath+"/test-reports/img/"+path+"' hight='100' width='100'/>");
		Reporter.log("<a href='"+currentPath+"/test-reports/img/"+path+"'>"+path+"</a>");
		log.info(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		try {
			log.info("save snapshot path is: " + currentPath +"/test-reports/img/"+path);
			FileUtils.copyFile(scrFile, new File(currentPath + "/test-reports/img/" + path));
		} catch (Exception e) {
			log.error("Can't save screenshot");
			e.printStackTrace();
		} finally {
			log.info("screen shot finished");
		}
	}

}
