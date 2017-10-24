package utils;

public class Contants {

//	定义访问地址
	//public static  String url="http://www.oschina.net/";
	public static  String url="https://www.baidu.com/";
//	定义基本路径
//	public static String baseUrl="D:/download/work/wang-Selenium-Test";
	public static String baseUrl=System.getProperty("user.dir");
//	定义驱动路径
	public static String driverUrl="C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe";
//	Excel的路径和名称
	public static String excelFile=baseUrl+"/src/main/resources/file/";
	//public static String excelName="dataEngine.xls";
	public static String excelName="dataEngine_02.xls";
//	用例sheet页
	public static String caseLoginSheet="login";
//	用例sheet页
	public static String caseRegisterSheet="register";
//	用例场景的sheet页
	public static String suitSheet="Suite";
//	用例场景的data页
	public static String dataSheet="Datas";
//	用例场景的data02页
	public static String dataSheet02="Datas02";
//	Suite页的设置
	public static int suitTestSuiteId=0;
	public static int suitRunmode=2;
	public static int suitResult=3;
	public static int suitAction=4;
//	用例步骤页的设置
	public static int stepTestSuiteId=0;
	public static int excelPOCloNum=4;
	public static int excelKWCloNum=5;
	public static int caseResult=6;
//	成功和失败
	public static  String fail="FAIL";
	public static  String pass="PASS";
//	对象仓库文件路径
	public static String ObjectReUrl=baseUrl+"/src/dataEngine/ObjectRepository";
//	登陆的用户明和密码
	public static String userName="13575906896";
	public static String userPassword="wanghao82830943";
	
	
	
	
}

