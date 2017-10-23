package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//操作Excel工具类
public class ExcelUtils {

	public static HSSFSheet ExcelSheet;
	public static HSSFWorkbook ExcelBook;
	public static HSSFRow Row;
	public static HSSFCell Cell;

	/**
	 * 加载Excel
	 * 
	 * @param Path
	 *            文件路径
	 */
	public static void setExcelFile(String Path) {
		FileInputStream ExcelFile;
		try {
			ExcelFile = new FileInputStream(Path);
			ExcelBook = new HSSFWorkbook(ExcelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 值得写入
	 * 
	 * @param Result
	 * @param RowNum
	 * @param ColNum
	 * @param Path
	 * @param SheetName
	 */
	public static void setCellData(String Result, int RowNum, int ColNum, String Path, String SheetName) {
		try {
			// System.out.println(Result+" "+RowNum+" "+ColNum+" "+Path+"
			// "+SheetName);
			ExcelSheet = ExcelBook.getSheet(SheetName);
			Row = ExcelSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			File file = new File(Path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 写入Excel中对应单元格的值
	 * 
	 * @param Result
	 * @param RowNum
	 * @param ColNum
	 * @param Path
	 * @param SheetName
	 */
	public static void setRowData(String Result, int RowNum, int ColNum, String Path, String SheetName) {
		try {
			ExcelSheet = ExcelBook.getSheet(SheetName);
			Row = ExcelSheet.createRow(RowNum);
			// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Path);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取Excel中对应单元格的值
	 * 
	 * @param RowNum
	 * @param CloNum
	 * @param SheetName
	 * @return
	 */
	public static String getCellDate(int RowNum, int CloNum, String SheetName) {
		ExcelSheet = ExcelBook.getSheet(SheetName);
		Cell = ExcelSheet.getRow(RowNum).getCell(CloNum);
		String cellData = Cell.getStringCellValue();
		return cellData;

	}

	/**
	 * 获取到sheet页最后一行
	 * 
	 * @param SheetName
	 * @return
	 * 
	 */
	public static int getLastRowNums(String SheetName) {
		try {
			ExcelSheet = ExcelBook.getSheet(SheetName);
			int rowCount = ExcelSheet.getLastRowNum();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 获取到sheet页对应行的最后一列
	 * 
	 * @param SheetName
	 * @return
	 * 
	 */
	public static int getLastCloNums(int RowNum, String SheetName) {
		try {
			ExcelSheet = ExcelBook.getSheet(SheetName);
			int cellCount = ExcelSheet.getRow(RowNum).getLastCellNum();
			return cellCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	/**
	 * 获取Excel对应列的集合
	 * 
	 * @param CloNum
	 * @param SheetName
	 * @return
	 * 
	 */
	public static List<String> getCloNum(int CloNum, String SheetName) {
		List<String> list=new ArrayList<String>(); 
		for (int i = 1; i <= getLastRowNums(SheetName); i++) {
			list.add(getCellDate(i, CloNum, SheetName));
		}
		return list;		
	}
	
	
	
	/**
	 * 获取Excel对应行的集合
	 * 
	 * @param CloNum
	 * @param SheetName
	 * @return
	 * 
	 */
	public static List<String> getRowNum(int RowNum, String SheetName) {
		List<String> list=new ArrayList<String>(); 
		for (int i = 0; i <getLastCloNums(RowNum,SheetName); i++) {
			
			list.add(getCellDate(RowNum, i, SheetName));
		}
		return list;		
	}
	
	
}
