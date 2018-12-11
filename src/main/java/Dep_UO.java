import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Set;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dep_UO {
    private SelenideElement ArmDep_UO = $x("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Депозити юридичних осіб ')]");
    private SelenideElement DepPort_UO = $(By.id("oper-3406"));
    private SelenideElement VidNum = $x("//*[@id = 'td_21']");
    private SelenideElement Product = $(By.id("ddProduct"));
    private SelenideElement Currency = $(By.id("ddKv"));
    private SelenideElement Ок = $(byValue("Ok"));
    private SelenideElement BtIns = $(By.id("btIns"));
    private SelenideElement btSave2 = $(By.id("btSave"));
    private SelenideElement VidD = $(By.id("ddVidD"));
    private SelenideElement btOk = $(By.id("btOk"));
    private SelenideElement tbSum = $(By.id("tbSum"));
    private SelenideElement btSave = $(By.id("btSave"));
    private By Rnk = By.xpath("//*[@id = 'tbRnk']");
    private By cbCompProc = By.id("cbCompProc");
    private By tbNlsD = By.id("tbNlsD");
    private By tbIr = By.id("tbIr");
    private By btExit = By.id("btExit");

    TopFunction topFunction = new TopFunction();
    Logger log = Logger.getLogger(Dep_UO.class.getName());

    public Dep_UO open_Dep_UO () {
        Selenide.sleep(5000);
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", ArmDep_UO);

        ArmDep_UO.shouldBe(Condition.visible).click();
        String getWindowHandle = getWebDriver().getWindowHandle();

        DepPort_UO.shouldBe(Condition.visible).click();
        topFunction.GoWindow(getWindowHandle);
        btOk.click();
        getWebDriver().switchTo().window(getWindowHandle);
        return new Dep_UO();
    }
    public Dep_UO registrat_Dep_UO (String Rnk, String Product, String Currency, String Nls, String Sum, String Proc) {
        Selenide.sleep(4000);
        switchTo().frame($("#mainFrame"));
        String getWindowHandle2 = getWebDriver().getWindowHandle();
        BtIns.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle2);
        getWebDriver().findElement(this.Rnk).sendKeys(Rnk);
        topFunction.GetSelect(this.Product).selectByValue(Product);
        topFunction.GetSelect(this.Currency).selectByValue(Currency);

        String getWindowHandle3 = getWebDriver().getWindowHandle();
        Set<String> getWindowHandle3Set = getWebDriver().getWindowHandles();

        VidD.click();
        sleep(3000);
        topFunction.GoWindow(getWindowHandle3);
        sleep(3000);
        VidNum.click();


        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(cbCompProc).click();
        getWebDriver().findElement(tbNlsD).sendKeys(Nls);

        sleep(2000);

        String getWindowHandle4 = getWebDriver().getWindowHandle();
        tbSum.click();
        sleep(2000);
        topFunction.GoWindow(getWindowHandle4);
        sleep(2000);
        Ок.click();

        getWebDriver().switchTo().window(getWindowHandle3);
        $(tbSum).shouldBe(Condition.visible).sendKeys(Sum);
        getWebDriver().findElement(tbIr).sendKeys(Proc);

        topFunction.waitGoWindowElementCl(btSave,btOk);
        Selenide.sleep(3000);

        getWebDriver().switchTo().window(getWindowHandle3);
        sleep(2000);
        topFunction.GoWindow(getWindowHandle3);
        sleep(2000);
        Ок.click();

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(btExit).click();
        getWebDriver().switchTo().window(getWindowHandle2);
        return new Dep_UO();
    }

    public  String registrat_Dep_UO_All_Null () {
        Selenide.sleep(4000);
        switchTo().frame($("#mainFrame"));
        String getWindowHandle2 = getWebDriver().getWindowHandle();

        BtIns.shouldBe(Condition.visible).click();
        topFunction.GoWindow(getWindowHandle2);
        String getWindowHandle3 = getWebDriver().getWindowHandle();
        Set<String> getWindowHandle3Set = getWebDriver().getWindowHandles();
        btSave2.click();

        topFunction.waitGoWindowElementCl(getWindowHandle3Set);
        sleep(3000);
        String s = ("Is Displayed = " +$(byText("Не заповнений реквізит <№ договору>")).isDisplayed() +
        $(byText("Не заповнений реквізит <Вид депозитного договору>Не заповнений реквізит <Рег.№ клієнта>")).isDisplayed() +
        $(byText("Не заповнений реквізит <Періодичність виплати %%>")).isDisplayed() +
        $(byText("Не заповнений реквізит <Процентна ставка>")).isDisplayed() +
        $(byText("Не вказані реквізити рахунку повернення депозиту.")).isDisplayed());
        log.info(s);
        $(byValue("Ok")).click();

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(btExit).click();
        getWebDriver().switchTo().window(getWindowHandle2);
        return   s;
    }
}
