package objectPage;

import org.openqa.selenium.WebDriver;

import seleniumHelper.DriverFactory;



public class TestBaidu {
	
    public void login1(String username)
    {
    WebDriver driver= DriverFactory.getInstance().getFirefoxDriver();
    driver.get("https://www.baidu.com/");

//    BaiduPage m=PageFactory.initElements(driver, BaiduPage.class);
    BaiduPage baiduPage=new BaiduPage(driver);
    baiduPage.login( username);
    }
   
    public static void main(String[] args)
    {
        TestBaidu tl = new TestBaidu();
        tl.login1("135135");
    }
    
}
