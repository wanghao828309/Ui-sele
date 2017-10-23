package register.testCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import login.testCase.StartEngine_LoginCase;
import seleniumHelper.DriverFactory;
import seleniumHelper.LoginKeywords;
import utils.Contants;
import utils.ExcelUtils;

public class RegDataProvider {
	private static final String String = null;
	private static Object[][] obj;
	private static List parList = new ArrayList();
	private static List sonList = new ArrayList();

	// @DataProvider(name="loginProvider")
	@DataProvider
	public static Object[][] loginProvider() {

		parList.add(0, "1");
		parList.add(1, "2");
		// parList.add(1, "b");
		sonList.add(0, "a");
		sonList.add(1, "b");

		Object[] parray = parList.toArray();
		Object[] sarray = sonList.toArray();
		// obj = new Object[][] { {parList.get(0)}, {sonList.get(0)} };
		obj = new Object[][] { parray, sarray };
		return obj;

	}

	
	@DataProvider
	public static Object[][] data02Provider() {
		ExcelUtils.setExcelFile(Contants.excelFile + Contants.excelName);
		int rowSize=ExcelUtils.getLastRowNums(Contants.dataSheet02);
		int colSize=ExcelUtils.getLastCloNums(1, Contants.dataSheet02);
//		System.out.println(rowSize+"  "+colSize);
		Object[][] returnArray = new Object[rowSize][colSize];
		
		for (int i = 1; i<=rowSize; i++) {
			List<String> rowNum = ExcelUtils.getRowNum(i, Contants.dataSheet02);
			Object[] obj = rowNum.toArray();
//			System.out.println(Arrays.toString(obj));
		    returnArray[i-1]=obj;
		}
		return returnArray;

	}

	

}
