import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class RegistratCard {

    private static Select select;
    private SelenideElement CardRah = $(By.id("__tab_TabMainContainer_TabBPK"));
    private SelenideElement CreateRah = $(By.id("TabMainContainer_TabBPK_btnCreateCard"));
    private SelenideElement listProductGrp = $(By.id("listProductGrp"));
    private SelenideElement listCurrency = $(By.id("listCurrency"));
    private SelenideElement listProjectZP = $(By.id("listProject"));
    private SelenideElement listProduct = $(By.id("listProduct"));
    private SelenideElement listCard = $(By.id("listCard"));
    private SelenideElement textMonths = $(By.id("textMonths"));
    private SelenideElement textSecretWord = $(By.id("textSecretWord"));
    private SelenideElement btnRegisterCard = $(By.id("btnRegisterCard"));
    private SelenideElement btnBack = $(By.id("btnBack"));

    public RegistratCard registratCard(String ProductGrp,String ProjectZP,String Currency, String listProduct, String CardName, String MonthsOpenCard, String SecretWord) {

        CardRah.click();
        CreateRah.click();

        getSelect((this.listProductGrp).shouldBe(Condition.visible));
        select.selectByValue(ProductGrp);

        sleep(2000);
        getSelect((this.listProjectZP).shouldBe(Condition.visible));
        select.selectByValue(ProjectZP);

        sleep(2000);
        getSelect((this.listCurrency).shouldBe(Condition.visible));
        select.selectByValue(Currency);

        sleep(2000);
        getSelect((this.listProduct).shouldBe(Condition.visible));
        select.selectByValue(listProduct);

        sleep(2000);
        getSelect((this.listCard).shouldBe(Condition.visible));
        select.selectByValue(CardName);

        sleep(2000);
        textMonths.shouldBe(Condition.visible).clear();
        textMonths.shouldBe(Condition.visible).sendKeys(MonthsOpenCard);
        textSecretWord.sendKeys(SecretWord);
        btnRegisterCard.click();

        sleep(2000);
        switchTo().alert().accept();

        btnBack.click();

        return new RegistratCard();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}