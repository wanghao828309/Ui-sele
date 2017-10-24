package register.testCase;

import utils.*;

//这个类的处理逻辑是和Excel表格对应的，如果要更改Excel只需要改这个类，或者新增加一个和Excel对应的类
public class StartEngine_RegCase {

	public static String Keywords = null;
	public static String r;
	public static boolean sResult = true;

	public static void StartEngine(String sRowNum, String s1, String s2, String s3) {
		ExcelUtils.setExcelFile(Contants.excelFile + Contants.excelName);

		/* LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS(); */
		for (int j = 1; j <= ExcelUtils.getLastRowNums(Contants.suitSheet); j++) {

			String Runmode = ExcelUtils.getCellDate(j, Contants.suitRunmode, Contants.suitSheet);
			// System.out.println(Runmode);
			String suitTestSuiteId = ExcelUtils.getCellDate(j, Contants.suitTestSuiteId, Contants.suitSheet);
			// 根据stepTestSuiteId在caseSheet中循环查找相对应的执行步骤
			if (Runmode.equals("YES")) {
				if (sRowNum.trim().equals(suitTestSuiteId)) {

					RegCase.register(s1, s2, s3);

					if (sResult == false) {
						ExcelUtils.setCellData(Contants.fail, j, Contants.suitResult,
								Contants.excelFile + Contants.excelName, Contants.suitSheet);
						 break;

					} else {
						ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,
								Contants.excelFile + Contants.excelName, Contants.suitSheet);
						 break;
					}
				}
				// if (sResult == true) {
				// ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,
				// Contants.excelFile + Contants.excelName, Contants.suitSheet);
				// }
			}
		}
	}

	public static boolean getbResult() {
		return sResult;
	}

	public static void setbResult(boolean bResult) {
		StartEngine_RegCase.sResult = bResult;
	}

}
