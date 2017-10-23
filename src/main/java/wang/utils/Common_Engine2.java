package wang.utils;

import java.lang.reflect.Method;

import login.testCase.StartEngine_LoginCase;
import utils.*;


public class Common_Engine2 {
	
//	执行关键字中的方法
	public static void action(String Keywords,Object actionKeyWords,String caseSheet,String r,int sRowNum,boolean bResult){
//		new LoginKeyWords();
//		java反射拿到对应的所有方法
		/*actionKeyWords= new LoginKeyWords();*/
		Method[] method=actionKeyWords.getClass().getMethods();
		for(int i=0;i<method.length;i++){
			if(method[i].getName().trim().equals(Keywords)){
							

				   //System.out.println(method[i].getName()+"#######"+Keywords+"#######"+r);

					try {
						method[i].invoke(actionKeyWords,r);
					} catch (Exception e) {
						
						StartEngine_LoginCase.setbResult(false);
						bResult=false;
					} 
					if(bResult == true){
						ExcelUtils.setCellData(Contants.pass, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName,caseSheet);
					}else{
						ExcelUtils.setCellData(Contants.fail, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName,caseSheet);
						//break;
					}
					
					
				
			}
		}
	}
}
