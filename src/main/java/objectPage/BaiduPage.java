package objectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class BaiduPage extends BasePage  {

	public BaiduPage(WebDriver driver) {
		super(driver);
	}


	
//	@FindBy(xpath="//*[@id='kw']")
	@FindBy(id="kw" )
	@CacheLookup
    private WebElement input;


    @FindBy(id="su" )
    @CacheLookup
    private WebElement submit;


    
    public void login(String value){

           
           this.input.sendKeys(value);

           submit.click();

    }
}
