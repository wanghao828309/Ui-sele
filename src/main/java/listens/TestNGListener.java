package listens;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import seleniumHelper.DriverFactory;







/**
 * 
 * @author Young
 *
 */
public class TestNGListener extends TestListenerAdapter {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	//private static log log = log.getlog(TestNGListener.class);
	private static Logger log = LogManager.getLogger(TestNGListener.class.getName());


	@Override
	public void onTestSuccess(ITestResult tr) {
		log.info("================On Test Success======================");
		super.onTestSuccess(tr);
		//takeScreenShot(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.error("================On Test error======================");
		Throwable throwable = tr.getThrowable();
		if (throwable != null) {
			log.error(throwable.getMessage());
		}
		log.error(tr.getTestName() + " \n" + tr.getStatus());

		super.onTestFailure(tr);
		takeScreenShot(tr);
//		WebDriver currentDriver = DriverFactory.getInstance().getDriver();
//		if (!currentDriver.equals(null)) {
//			currentDriver.close();
//		}
	}


	@Override
	public void onTestSkipped(ITestResult tr) {
		log.info("================On Test Skipped======================");
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("================On Test Start======================");
		super.onTestStart(result);
	}

	@Override
	public void onStart(ITestContext testContext) {
		ITestNGMethod[] methods = testContext.getAllTestMethods();
		for (ITestNGMethod method : methods) {
			String[] groups = method.getGroups();
			for (String group : groups) {
				log.info("----------------Test Group-------------");
				log.debug(group);
				log.info("---------------------------------------");
			}
		}

		super.onStart(testContext);
		Date date1 = testContext.getStartDate();

		log.info("----------------Test Start-------------");
		log.info("---------------------------------------");
		log.info("----------------" + sf.format(date1) + "-------------");
		log.info("---------------------------------------");
		
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// collect all id's from passed test
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			log.info("PassedTests = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
			log.info("failedTest = " + failedTest.getName());
			// id = class + method + dataprovider
			int failedTestId = getId(failedTest);

			// if we saw this test as a failed test before we mark as to be
			// deleted
			// or delete this failed test if there is at least one passed
			// version
			if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}

		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator =

				testContext.getFailedTests().getAllResults().iterator(); iterator.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testsToBeRemoved.contains(testResult)) {
				log.info("Remove repeat Fail Test: " + testResult.getName());
				iterator.remove();
			}
		}

		log.info("Test Finish");
		Date date2 = testContext.getStartDate();

		log.info("----------------Test Finish-------------");
		log.info("---------------------------------------");
		log.info("----------------" + sf.format(date2) + "-------------");
		log.info("---------------------------------------");


	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		return id;
	}
	
	
	
	
	private void takeScreenShot(ITestResult tr) {

		WebDriver currentDirver = DriverFactory.getInstance().getDriver();
		//log.info(currentDirver.getTitle() + "\n");

		takeScreenShot();

	}
	
	
	public void takeScreenShot() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		WebDriver currentDriver = DriverFactory.getInstance().getDriver();
		//log.info(currentDriver.getTitle() + "\n");
		String path = this.getClass().getSimpleName() + "_" + dateStr + ".jpg";
		takeScreenShot((TakesScreenshot) currentDriver, path);
	}

	/**
	 * @author Young
	 * @param drivername
	 * @param path
	 */
	public void takeScreenShot(TakesScreenshot drivername, String path) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name
		String currentPath = System.getProperty("user.dir"); // get current work
		Reporter.log("<img src='"+currentPath+"/"+path+"' hight='100' width='100'/>");
		Reporter.log("<a href='"+currentPath+"/"+path+"'>"+path+"</a>");
		log.info(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		try {
			log.info("save snapshot path is:" + currentPath + path);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		} catch (Exception e) {
			log.error("Can't save screenshot");
			e.printStackTrace();
		} finally {
			log.info("screen shot finished");
		}
	}

	
}
