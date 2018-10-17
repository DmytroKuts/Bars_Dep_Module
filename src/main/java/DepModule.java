import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DepModule {

    private By ArmWorkWithCust = By.xpath("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Робота з клієнтом')]");
    private By StartWorkWithCust = By.xpath("//div [@id ='oper-4495']");
    private By btContracts = By.xpath("//*[@id='btContracts']");
    private By textClientCode = By.xpath("//*[@id='textClientCode']");
    private By btSearch = By.xpath("//*[@id='btSearch']");
    private By ddlSearchClient = By.xpath("//*[@id='ddlSearchClient']");
    private By btClientCard = By.xpath("//*[@id='btClientCard']");
    private static Select select;

    public DepModule openCustCard(String okpo, String customerRnk) {

        sleep(5000);

        $(By.id("btnBranches")).waitUntil(Condition.visible, 5000);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", $(ArmWorkWithCust));

        $(ArmWorkWithCust).shouldBe(Condition.enabled).click();
        $(StartWorkWithCust).shouldBe(Condition.enabled).click();

        switchTo().frame($("#mainFrame"));
        $(textClientCode).shouldBe(Condition.enabled).sendKeys(okpo);
        $(btSearch).click();

        getSelect($(this.ddlSearchClient));
        select.selectByValue(customerRnk);
        $(btClientCard).shouldBe(Condition.enabled).click();
        $(btContracts).shouldBe(enabled).click();
        return new DepModule();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}
