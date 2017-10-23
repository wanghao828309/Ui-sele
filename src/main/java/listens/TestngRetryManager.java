package listens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;



public class TestngRetryManager implements IRetryAnalyzer {
	Logger log = LogManager.getLogger(TestngRetryManager.class.getName());
	int defaultCount = 1;
	int maxTryCount=1;

	public TestngRetryManager() {
	}

	public boolean retry(ITestResult result) {

		if (defaultCount <= maxTryCount) {
			String message = "running retry for  '" + result.getName()
					+ "' on class " +

					this.getClass().getName() + " Retrying " + defaultCount
					+ " times";
			log.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (defaultCount + 1));
			defaultCount++;
			return true;
		}
		return false;
	}

}
