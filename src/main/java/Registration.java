import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Registration {
    WebDriver driver ;
    TopFunction topFunction;



    public Registration (WebDriver driver) { this.driver = driver;
    this.topFunction = new TopFunction(this.driver);
    }

    private By txtUserName = By.xpath("//input[@id='txtUserName']");
    private By txtPassword = By.xpath("//input[@id='txtPassword']");
    private By login_cl = By.xpath("//input[@id='btLogIn']");
    private By ChangDate_cl = By.xpath("//*[@id='btChangDate']");
    private By header = By.xpath("//h1[contains(text(), 'Вхід в систему')]");

    public Registration UserName(String username){
        driver.findElement(txtUserName).clear();
        driver.findElement(txtUserName).sendKeys(username);
        return this;
    }

    public Registration Password(String password){
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
        return this;
    }

    public Registration registerUserPass (String password, String username){
        topFunction.VoidXpath60sec(header);
        this.Password(password);
        this.UserName(username);
        driver.findElement(login_cl).click();
        topFunction.VoidXpath10sec(ChangDate_cl);
        driver.findElement(ChangDate_cl).click();
        return new Registration(driver);
    }
}
