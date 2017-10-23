package selenium_test01;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import utils.PublicUtil;
import utils.XMLTemplateReader;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {
		try {
			String userDir = PublicUtil.getUserDir();
			System.out.println(PublicUtil.getFileSeparator());
			System.out.println(PublicUtil.checkDigital("1"));
//			PublicUtil.zipDir("D:\\java\\android\\work\\selenium-test01\\src\\main\\resources\\", "test02..zip");
//			PublicUtil.unZipFile( "test01.zip","D:\\java\\android\\work\\selenium-test01\\src\\main\\resources\\");
			XMLTemplateReader.getMessageTemplate("test02.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
