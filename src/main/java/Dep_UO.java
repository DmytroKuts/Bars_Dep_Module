import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dep_UO {
    private SelenideElement ArmDep_UO = $x("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Депозити юридичних осіб ')]");
    private SelenideElement DepPort_UO = $(By.id("oper-3406"));
    private By DepFiltr = By.id("btOk");
    private SelenideElement BtIns = $(By.id("btIns"));
    private SelenideElement Rnk = $(By.id("tbRnk"));
    private SelenideElement Product = $(By.id("ddProduct"));
    private SelenideElement Currency = $(By.id("ddKv"));
    private SelenideElement VidD = $(By.id("ddVidD"));
   // private By VidD = By.id("ddVidD");
    private static Select select;

    TopFunction topFunction = new TopFunction();

    public Dep_UO open_Dep_UO ()
    {
        Selenide.sleep(5000);

        $(By.id("btnBranches")).waitUntil(Condition.visible, 5000);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", ArmDep_UO);

        ArmDep_UO.shouldBe(Condition.visible).click();
        String getWindowHandle = getWebDriver().getWindowHandle();
        DepPort_UO.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle);
        topFunction.userDelay(4000);
        getWebDriver().findElement(DepFiltr).click();

        getWebDriver().switchTo().window(getWindowHandle);
        switchTo().frame($("#mainFrame"));

        /////////// регистрация депозита
        String getWindowHandle2 = getWebDriver().getWindowHandle();
        BtIns.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle2);
        Rnk.sendKeys("98116101");

        topFunction.GetSelect(Product).selectByValue("4");
        topFunction.GetSelect(Currency).selectByValue("980");

        String getWindowHandle3 = getWebDriver().getWindowHandle();
        getWebDriver().findElement(VidD).click();
      //  VidD.shouldBe(Condition.visible).click();

        topFunction.GoWindow(getWindowHandle3);
        $(By.id("td_21")).shouldBe(Condition.visible).click();


        return new Dep_UO();
    }
}
