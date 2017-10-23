package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


//操作对象库的的工具类
public class OrpUtil implements InterfaceUtils{
	

	public static String  readValue(String name){
		Properties pro=new Properties();
		String value=null;
		try {
			InputStream in =new BufferedInputStream(new FileInputStream(objectPath));
//			InputStream in=getClass().getResourceAsStream("/info.properties");
			pro.load(in);
			value=pro.getProperty(name);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
