import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistratContract {
    TopFunction topFunction;
    private  static Select select;

    public RegistratContract() {
        this.topFunction = new TopFunction();
    }

    private By btContracts = By.xpath("//*[@id='btContracts']");
    private By btCreateContract = By.xpath("//*[@id='TabMainContainer_TabDeposit_TabDepositContainer_TabContractMain_btCreateContract']");
    private By listTypes = By.xpath("//*[@id='listTypes']");
    private By listCurrency = By.xpath("//*[@id='listCurrency']");
    private By listContractType = By.xpath("//*[@id='listContractType']");
    private By textContractSum = By.xpath("//*[@id='textContractSum']");
    private By btnAccounts = By.xpath("//*[@id='btnAccounts']");
    private By btnSubmit = By.xpath("//*[@id='btnSubmit']");
    private By ValAcc = By.xpath("//tr[@id='r_1']/td[3]");     //td[contains(text(), '26209503197919')
    private By btNext = By.xpath("//*[@id='btNext']");
    private By textContractNumber = By.xpath("//*[@id='textContractNumber']");
    private By eadPrintContract_ibPrint = By.xpath("//*[@id='eadPrintContract_ibPrint']");


    public RegistratContract кegistratContract (String listTypesAc, String listCurrencyAc, String listContractTypeAc, String textContractSumAc){

        $(btContracts).shouldBe(enabled).click() ;

        $(btCreateContract).click();
        sleep(1000);
        getSelect($(listTypes));
        select.selectByValue(listTypesAc);

        sleep(1000);
        getSelect($(listCurrency));
        select.selectByValue(listCurrencyAc);

        sleep(1000);
        getSelect($(listContractType));
        select.selectByValue(listContractTypeAc);

        sleep(3000);
        $(textContractSum).clear();
        $(textContractSum).sendKeys(textContractSumAc);
        $(btnSubmit).click();

        sleep(2000);
        String getWindowHandle2 =  getWebDriver().getWindowHandle();
        $(btnAccounts).click();
        for(String windowsHandles : getWebDriver().getWindowHandles()){
            if(!windowsHandles.equals(getWindowHandle2)){
                getWebDriver().switchTo().window(windowsHandles);
                getWebDriver().manage().window().maximize();
            }
            getWebDriver().switchTo().window(windowsHandles);
        }

        sleep(2000);
        //$(ValAcc).click();
        getWebDriver().findElement(ValAcc).click();

        getWebDriver().switchTo().window(getWindowHandle2);
        getWebDriver().switchTo().frame($(By.id("mainFrame")));
        $(btNext).shouldBe(enabled).click();


        return new RegistratContract();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

}

