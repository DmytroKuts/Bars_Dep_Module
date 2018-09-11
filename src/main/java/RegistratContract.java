import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistratContract {
    WebDriver driver ;
    TopFunction topFunction;
    private  static Select select;

    public RegistratContract(WebDriver driver) { this.driver = driver;
        this.topFunction = new TopFunction(this.driver);
    }
    //private String mainWindow = driver.getWindowHandle();
    private By btContracts = By.xpath("//*[@id='btContracts']");
    private By btCreateContract = By.xpath("//*[@id='TabMainContainer_TabDeposit_TabDepositContainer_TabContractMain_btCreateContract']");
    private By listTypes = By.xpath("//*[@id='listTypes']");
    private By listCurrency = By.xpath("//*[@id='listCurrency']");
    private By listContractType = By.xpath("//*[@id='listContractType']");
    private By textContractSum = By.xpath("//*[@id='textContractSum']");
    private By btnAccounts = By.xpath("//*[@id='btnAccounts']");
    private By btnSubmit = By.xpath("//*[@id='btnSubmit']");
    private By ValAcc = By.xpath("//tr[@id='r_1']/td[2]");     //td[contains(text(), '26209503197919')
    private By btNext = By.xpath("//*[@id='btNext']");
    private By textContractNumber = By.xpath("//*[@id='textContractNumber']");
    private By eadPrintContract_ibPrint = By.xpath("//*[@id='eadPrintContract_ibPrint']");


    public RegistratContract кegistratContract (String listTypesAc, String listCurrencyAc, String listContractTypeAc, String textContractSumAc){
        //String getWindowHandle = driver.getWindowHandle();

        topFunction.VoidXpath60sec(btContracts);
        driver.findElement(btContracts).click();

        topFunction.VoidXpath60sec(btCreateContract);
        driver.findElement(btCreateContract).click();

        topFunction.VoidXpath60sec(listTypes);
        getSelect(driver.findElement(this.listTypes));
        select.selectByValue(listTypesAc);

        topFunction.userDelay(3000);
        getSelect(driver.findElement(this.listCurrency));
        select.selectByValue(listCurrencyAc);

        topFunction.userDelay(3000);
        getSelect(driver.findElement(this.listContractType));
        select.selectByValue(listContractTypeAc);

        topFunction.userDelay(3000);
        driver.findElement(textContractSum).clear();
        driver.findElement(textContractSum).sendKeys(textContractSumAc);
        driver.findElement(btnSubmit).click();


        topFunction.VoidXpath60sec(btnAccounts);
        String getWindowHandle2 = driver.getWindowHandle();
        //String getWindowHandle3 = driver.getPageSource();
        driver.findElement(btnAccounts).click();
        for(String windowsHandles : driver.getWindowHandles()){
            if(!windowsHandles.equals(getWindowHandle2)){
                driver.switchTo().window(windowsHandles);
               // driver.manage().window().maximize();
            }
            driver.switchTo().window(windowsHandles);
        }

        topFunction.userDelay(3000);
        driver.findElement(ValAcc).click();

        topFunction.userDelay(3000);

        driver.switchTo().window(getWindowHandle2);
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        driver.findElement(btNext).click();


        return new RegistratContract(driver);
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

}

