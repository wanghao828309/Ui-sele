package listens;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


/**
 * 
 * @author young
 *
 */
public class ImplTestNGListener implements ITestListener {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================On Test Start======================");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================On Test Success======================");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================On Test failure======================");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("================On test skip======================");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Date date1 = context.getStartDate();
		System.out.println("================" + sf.format(date1) + " ======================");
		System.out.println("================On **** Start======================");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Date date2 = context.getStartDate();
		System.out.println("================" + sf.format(date2) + " ======================");
		System.out.println("================On ***Finish ======================");

	}



}
