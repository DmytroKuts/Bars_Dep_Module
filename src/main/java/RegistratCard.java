import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistratCard {
    WebDriver driver ;
    TopFunction topFunction;

    public RegistratCard(WebDriver driver) { this.driver = driver;
        this.topFunction = new TopFunction(this.driver);
    }
    private  static Select select;
    private By btContracts = By.xpath("//*[@id='btContracts']");
    private By CardRah = By.xpath("//*[@id='__tab_TabMainContainer_TabBPK']");
    private By CreateRah = By.xpath("//*[@id='TabMainContainer_TabBPK_btnCreateCard']");
    private By listProductGrp = By.xpath("//*[@id='listProductGrp']");
    private By listProjectZP = By.xpath("//*[@id='listProject']");
    private By listCard = By.xpath("//*[@id='listCard']");
    private By textMonths = By.xpath("//*[@id='textMonths']");
    private By textSecretWord = By.xpath("//*[@id='textSecretWord']");
    private By btnRegisterCard = By.xpath("//*[@id='btnRegisterCard']");
    private By btnBack = By.xpath("//*[@id='btnBack']");
    private By btnClientCard = By.xpath("//*[@id='btnClientCard']");

    public RegistratCard registratCard (String ProductGrp, String ProjectZP, String CardName, String MonthsOpenCard, String SecretWord ){
        topFunction.VoidXpath60sec(btContracts);
        driver.findElement(btContracts).click();

        topFunction.VoidXpath10sec(CardRah);
        driver.findElement(CardRah).click();

        topFunction.VoidXpath10sec(CreateRah);
        driver.findElement(CreateRah).click();

        topFunction.VoidXpath10sec(listProductGrp);
        getSelect(driver.findElement(this.listProductGrp));
        select.selectByValue(ProductGrp);

        topFunction.userDelay(3000);
        getSelect(driver.findElement(this.listProjectZP));
        select.selectByValue(ProjectZP);

        topFunction.userDelay(3000);
        getSelect(driver.findElement(this.listCard));
        select.selectByValue(CardName);

        topFunction.userDelay(3000);
        driver.findElement(textMonths).sendKeys(MonthsOpenCard);
        driver.findElement(textSecretWord).sendKeys(SecretWord);
        driver.findElement(btnRegisterCard).click();

        topFunction.userDelay(5000);
        driver.switchTo().alert().accept();

        topFunction.VoidXpath10sec(btnBack);
        driver.findElement(btnBack).click();

        topFunction.VoidXpath10sec(btnClientCard);
        driver.findElement(btnClientCard).click();


        return new RegistratCard(driver);
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}