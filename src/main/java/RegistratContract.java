import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistratContract {
    TopFunction topFunction;
    private static Select select;

    public RegistratContract() {
        this.topFunction = new TopFunction();
    }

    private SelenideElement btCreateContract = $(By.id("TabMainContainer_TabDeposit_TabDepositContainer_TabContractMain_btCreateContract"));
    private SelenideElement listTypes = $(By.id("listTypes"));
    private SelenideElement listCurrency = $(By.id("listCurrency"));
    private SelenideElement listContractType = $(By.id("listContractType"));
    private SelenideElement textContractSum = $(By.id("textContractSum"));
    private SelenideElement btnAccounts = $(By.id("btnAccounts"));
    private SelenideElement btnSubmit = $(By.id("btnSubmit"));
    private By ValAcc = By.xpath("//tr[@id='r_1']/td[3]");
    private SelenideElement btNext = $(By.id("btNext"));
    private SelenideElement lbInfo = $(By.id("lbInfo"));

    public RegistratContract кegistratContract(String listTypesAc, String listCurrencyAc, String listContractTypeAc, String textContractSumAc) {

        btCreateContract.shouldBe(Condition.visible).click();
        sleep(1000);
        getSelect(listTypes);
        select.selectByValue(listTypesAc);

        sleep(2000);
        getSelect(listCurrency.shouldBe(Condition.visible));
        select.selectByValue(listCurrencyAc);

        sleep(1000);
        getSelect(listContractType);
        select.selectByValue(listContractTypeAc);

        sleep(5000);
        textContractSum.clear();
        textContractSum.sendKeys(textContractSumAc);
        btnSubmit.click();

        sleep(4000);
        String getWindowHandle2 = getWebDriver().getWindowHandle();
        btnAccounts.click();
        for (String windowsHandles : getWebDriver().getWindowHandles()) {
            if (!windowsHandles.equals(getWindowHandle2)) {
                getWebDriver().switchTo().window(windowsHandles);
                getWebDriver().manage().window().maximize();
            }
            getWebDriver().switchTo().window(windowsHandles);
        }

        sleep(4000);
        //ValAcc.click();                         // не работает, интересно почему?***********
        getWebDriver().findElement(ValAcc).click();

        getWebDriver().switchTo().window(getWindowHandle2);
        getWebDriver().switchTo().frame($(By.id("mainFrame")));
        btNext.shouldBe(Condition.visible).click();

        Assert.assertEquals( "Картка вкладу №", lbInfo.getText());

        return new RegistratContract();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

}

