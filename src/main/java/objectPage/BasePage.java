package objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final int TIMEOUT = 1;             // short timeout for web-element
    private static final int TIMEOUT_LONG = 10;       // long timeout for web-element
    public WebDriver driver;
    public WebDriverWait driverWait;
    public WebDriverWait driverLongWait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(this.driver, TIMEOUT);
        this.driverLongWait = new WebDriverWait(this.driver, TIMEOUT_LONG);
        PageFactory.initElements(this.driver, this);  // ���ǳ���Ҫ�������д�Ļ����ܱ��벻�ᱨ�����Ǻ���Ҫ˵��ҳ��Ԫ��������ʱһ�����Ҳ���
    }

}
