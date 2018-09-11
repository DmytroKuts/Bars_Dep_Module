import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DepModule {

    WebDriver driver ;
    TopFunction topFunction;

    public DepModule (WebDriver driver) { this.driver = driver;
        this.topFunction = new TopFunction(this.driver);
    }

    private By ArmWorkWithCust = By.xpath("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Робота з клієнтом ')]");
    private By StartWorkWithCust = By.xpath("//div [@id ='oper-4495']");
    private By textClientCode = By.xpath("//*[@id='textClientCode']");
    private By btSearch = By.xpath("//*[@id='btSearch']");
    private By ddlSearchClient = By.xpath("//*[@id='ddlSearchClient']");
    private By btClientCard = By.xpath("//*[@id='btClientCard']");
    private  static Select select;


    public DepModule openCustCard (String okpo, String customerRnk){

        topFunction.userDelay(15000);
       // topFunction.VoidXpath60sec(ArmWorkWithCust);
        driver.findElement(ArmWorkWithCust).click();
        driver.findElement(StartWorkWithCust).click();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        topFunction.VoidXpath10sec(textClientCode);
        driver.findElement(textClientCode).sendKeys(okpo);
        driver.findElement(btSearch).click();
        topFunction.VoidXpath10sec(ddlSearchClient);
        getSelect(driver.findElement(this.ddlSearchClient));
        select.selectByValue(customerRnk);
        topFunction.userDelay(5000);
        driver.findElement(btClientCard).click();
        return new DepModule(driver);
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}
