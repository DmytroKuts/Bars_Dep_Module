import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DepModule {

    private SelenideElement ArmWorkWithCust = $x("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Робота з клієнтом')]");
    private SelenideElement StartWorkWithCust = $(By.id("oper-4495"));
    private SelenideElement btContracts = $(By.id("btContracts"));
    private SelenideElement textClientCode = $(By.id("textClientCode"));
    private SelenideElement btSearch = $(By.id("btSearch"));
    private SelenideElement ddlSearchClient = $(By.id("ddlSearchClient"));
    private SelenideElement btClientCard = $(By.id("btClientCard"));
    private static Select select;

    public DepModule openCustCard(String okpo, String customerRnk) {

        sleep(5000);

        $(By.id("btnBranches")).waitUntil(Condition.visible, 5000);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", ArmWorkWithCust);

        ArmWorkWithCust.shouldBe(Condition.visible).click();
        StartWorkWithCust.shouldBe(Condition.visible).click();

        switchTo().frame($("#mainFrame"));
        textClientCode.shouldBe(Condition.visible).sendKeys(okpo);
        btSearch.click();

        getSelect(ddlSearchClient);
        select.selectByValue(customerRnk);
        btClientCard.shouldBe(Condition.visible).click();
        btContracts.shouldBe(Condition.visible).click();
        return new DepModule();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}
