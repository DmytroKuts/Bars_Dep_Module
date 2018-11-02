import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dep_UO {
    private SelenideElement ArmDep_UO = $x("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Депозити юридичних осіб ')]");
    private SelenideElement DepPort_UO = $(By.id("oper-3406"));
    private By btOk = By.xpath("//*[@id = 'btOk']");
    private SelenideElement BtIns = $(By.id("btIns"));
    private By Rnk = By.xpath("//*[@id = 'tbRnk']");
    private SelenideElement Product = $(By.id("ddProduct"));
    private SelenideElement Currency = $(By.id("ddKv"));
    private By VidD = By.id("ddVidD");
    private By cbCompProc = By.id("cbCompProc");
    private By tbNlsD = By.id("tbNlsD");
    private By tbSum = By.id("tbSum");
    private By tbIr = By.id("tbIr");
    private By btSave = By.id("btSave");
    private By btExit = By.id("btExit");
    TopFunction topFunction = new TopFunction();

    public Dep_UO open_Dep_UO () {
        Selenide.sleep(5000);

        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", ArmDep_UO);

        ArmDep_UO.shouldBe(Condition.visible).click();
        String getWindowHandle = getWebDriver().getWindowHandle();

        DepPort_UO.shouldBe(Condition.visible).click();
        topFunction.GoWindow(getWindowHandle);

        getWebDriver().findElement(btOk).click();
        //$(DepFiltr).shouldBe(Condition.visible).click();

        getWebDriver().switchTo().window(getWindowHandle);
        switchTo().frame($("#mainFrame"));
        return new Dep_UO();
    }


    public Dep_UO registrat_Dep_UO (String Rnk, String Product, String Currency, String Nls, String Sum, String Proc) {
        String getWindowHandle2 = getWebDriver().getWindowHandle();
        BtIns.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle2);
        getWebDriver().findElement(this.Rnk).sendKeys(Rnk);
        topFunction.GetSelect(this.Product).selectByValue(Product);
        topFunction.GetSelect(this.Currency).selectByValue(Currency);

        String getWindowHandle3 = getWebDriver().getWindowHandle();
        Selenide.sleep(2000);
        getWebDriver().findElement(VidD).click();
        Selenide.sleep(3000);
        topFunction.GoWindow(getWindowHandle3);
        getWebDriver().findElement(By.xpath("//*[@id = 'td_21']")).click();
        Selenide.sleep(3000);

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(cbCompProc).click();
        getWebDriver().findElement(tbNlsD).sendKeys(Nls);

        getWebDriver().findElement(tbSum).click();
        topFunction.GoWindow(getWindowHandle3);
        $(byValue("Ok")).click();

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(tbSum).sendKeys(Sum);
        getWebDriver().findElement(tbIr).sendKeys(Proc);
        getWebDriver().findElement(btSave).click();

        topFunction.GoWindow(getWindowHandle3);
        try {
            getWebDriver().findElement(btOk).click();
        } catch (Exception e){
            System.out.println(getWebDriver().getWindowHandles());
            System.out.println(getWebDriver().getWindowHandle());
            Selenide.sleep(2000);
            getWebDriver().findElement(btOk).click();
        }
        Selenide.sleep(5000);

        getWebDriver().switchTo().window(getWindowHandle3);
        topFunction.GoWindow(getWindowHandle3);
        Boolean resultTest = $(byText("Зміни успішно збережені!")).isDisplayed();
        $(byValue("Ok")).click();

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(btExit).click();

        return new Dep_UO();
    }
}
