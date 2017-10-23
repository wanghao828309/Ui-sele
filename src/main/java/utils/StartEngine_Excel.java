package utils;



//这个类的处理逻辑是和Excel表格对应的，如果要更改Excel只需要改这个类，或者新增加一个和Excel对应的类
public class StartEngine_Excel {

	public static String Keywords = null;
	public static String r;
	public static boolean bResult = true;

	public static void StartEngine(Object actionKeyWords,String caseSheet ) {
		ExcelUtils.setExcelFile(Contants.excelFile + Contants.excelName);

		/* LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS(); */
		for (int j = 1; j <= ExcelUtils.getLastRowNums(Contants.suitSheet); j++) {

			String Runmode = ExcelUtils.getCellDate(j, Contants.suitRunmode, Contants.suitSheet);
			String suitTestSuiteId = ExcelUtils.getCellDate(j, Contants.suitTestSuiteId, Contants.suitSheet);
			int sRowNum;
			// 根据stepTestSuiteId在caseSheet中循环查找相对应的执行步骤
			if (Runmode.equals("YES")) {
				for (sRowNum = 1; sRowNum <= ExcelUtils.getLastRowNums(caseSheet); sRowNum++) {
					String stepTestSuiteId = ExcelUtils.getCellDate(sRowNum, Contants.stepTestSuiteId,
							caseSheet);
					if (stepTestSuiteId.trim().equals(suitTestSuiteId)) {
						Keywords = ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum, caseSheet);
						r = ExcelUtils.getCellDate(sRowNum, Contants.excelPOCloNum, caseSheet);
						System.out.println(Keywords + "------------" + r);
						Common_Engine.action(Keywords, actionKeyWords,caseSheet, r, sRowNum, bResult);
						System.out.println(bResult);
						if (bResult == false) {
							ExcelUtils.setCellData(Contants.fail, j, Contants.suitResult,
									Contants.excelFile + Contants.excelName, Contants.suitSheet);
							break;

						}
					}
				}
				if (bResult == true) {
					ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,
							Contants.excelFile + Contants.excelName, Contants.suitSheet);
				}
			} else {

				System.out.println("没有要执行的用例");
				// break;
			}
		}
	}

	public static boolean getbResult() {
		return bResult;
	}

	public static void setbResult(boolean bResult) {
		StartEngine_Excel.bResult = bResult;
	}

}
