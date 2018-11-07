import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.logging.Logger;

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
    Logger log = Logger.getLogger(Dep_UO.class.getName());

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
        //switchTo().frame($("#mainFrame"));
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
        Selenide.sleep(2000);
        getWebDriver().findElement(VidD).click();
        Selenide.sleep(2000);
        topFunction.GoWindow(getWindowHandle3);
        try {
            getWebDriver().findElement(By.xpath("//*[@id = 'td_21']")).click();
        } catch (Exception e){
            Selenide.sleep(4000);
            topFunction.GoWindow(getWindowHandle3);
            //getWebDriver().findElement(By.xpath("//*[@id = 'td_21']")).click();
            log.info("Не найден вид договора. Окно текущее: " + getWebDriver().getWindowHandle() + "// Окна " + getWebDriver().getWindowHandles()
                    +  "// Кондиция xPath " + $x("//*[@id = 'td_21']").shouldBe(Condition.visible));
            $x("//*[@id = 'td_21']").shouldBe(Condition.visible).click();
        }
        Selenide.sleep(3000);

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(cbCompProc).click();
        getWebDriver().findElement(tbNlsD).sendKeys(Nls);

        getWebDriver().findElement(tbSum).click();
        topFunction.GoWindow(getWindowHandle3);
        Selenide.sleep(2000);
        try {
            $(byValue("Ok")).click();
        } catch (Exception e){
            Selenide.sleep(3000);
            topFunction.GoWindow(getWindowHandle3);
            log.info("Не найдена кнопка ОК_1. Окно текущее: " + getWebDriver().getWindowHandle() + "// Окна " + getWebDriver().getWindowHandles()
                    +  "// Кондиция xPath " + $(byValue("Ok")).shouldBe(Condition.visible));
            $(byValue("Ok")).shouldBe(Condition.visible).click();
        }

        getWebDriver().switchTo().window(getWindowHandle3);
        //getWebDriver().findElement(tbSum).clear();
        //getWebDriver().findElement(tbSum).sendKeys(Sum);
        $(tbSum).shouldBe(Condition.visible).sendKeys(Sum);
        getWebDriver().findElement(tbIr).sendKeys(Proc);
        getWebDriver().findElement(btSave).click();

        topFunction.GoWindow(getWindowHandle3);
        Selenide.sleep(3000);
        try {
            getWebDriver().findElement(btOk).click();
        } catch (Exception e){
            Selenide.sleep(2000);
            topFunction.GoWindow(getWindowHandle3);
            log.info("Не найдена кнопка ОК_2. Окно текущее: " + getWebDriver().getWindowHandle() + "// Окна " + getWebDriver().getWindowHandles()
                    +  "// Кондиция xPath " + $(btOk).shouldBe(Condition.visible));
            getWebDriver().findElement(btOk).click();
        }
        Selenide.sleep(3000);

        getWebDriver().switchTo().window(getWindowHandle3);
        Selenide.sleep(2000);
        topFunction.GoWindow(getWindowHandle3);
        Selenide.sleep(2000);
        Boolean resultTest = $(byText("Зміни успішно збережені!")).isDisplayed();
        System.out.println(resultTest);
        try {
            $(byValue("Ok"));
        } catch (Exception e){
            Selenide.sleep(2000);
            topFunction.GoWindow(getWindowHandle3);
            Selenide.sleep(2000);
            log.info("Не найдена кнопка ОК_3. Окно текущее: " + getWebDriver().getWindowHandle() + "// Окна " + getWebDriver().getWindowHandles()
                    +  "// Кондиция xPath " + $(byValue("Ok")).isDisplayed());
            getWebDriver().findElement(btOk).click();

        }
        $(byValue("Ok")).click();

        getWebDriver().switchTo().window(getWindowHandle3);
        getWebDriver().findElement(btExit).click();
        getWebDriver().switchTo().window(getWindowHandle2);

        return new Dep_UO();
    }

    public Dep_UO registrat_Dep_UO_All_Null (String Rnk, String Product, String Currency, String Nls, String Sum, String Proc) {
        Selenide.sleep(4000);
        switchTo().frame($("#mainFrame"));
        String getWindowHandle2 = getWebDriver().getWindowHandle();
        BtIns.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle2);


        return new Dep_UO();
    }


}