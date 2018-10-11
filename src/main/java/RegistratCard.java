import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class RegistratCard {

    private  static Select select;
    private By btContracts = By.xpath("//*[@id='btContracts']");
    private By CardRah = By.xpath("//*[@id='__tab_TabMainContainer_TabBPK']");
    private By CreateRah = By.xpath("//*[@id='TabMainContainer_TabBPK_btnCreateCard']");
    private By listProductGrp = By.xpath("//*[@id='listProductGrp']");
    private By listProjectZP = By.xpath("//*[@id='listProject']");
    private By listCard = By.xpath("//*[@id='listCard']");
    private By textMonths = By.xpath("//*[@id='textMonths']");
    private By textSecretWord = By.xpath("//*[@id='textSecretWord']");
    private By btnRegisterCard = By.xpath("//*[@id='btnRegisterCard']");
    private By btnBack = By.xpath("//*[@id='btnBack']");
    private By btnClientCard = By.xpath("//*[@id='btnClientCard']");

    public RegistratCard registratCard (String ProductGrp, String ProjectZP, String CardName, String MonthsOpenCard, String SecretWord ){
        $(btContracts).click();
        $(CardRah).click();
        $(CreateRah).click();

        getSelect($(this.listProductGrp).shouldBe(Condition.visible));
        select.selectByValue(ProductGrp);

        sleep(2000);
        getSelect($(this.listProjectZP).shouldBe(Condition.visible));
        select.selectByValue(ProjectZP);

        sleep(2000);
        getSelect($(this.listCard).shouldBe(Condition.visible));
        select.selectByValue(CardName);



        sleep(2000);
        $(textMonths).shouldBe(Condition.visible).sendKeys(MonthsOpenCard);
        $(textSecretWord).sendKeys(SecretWord);
        $(btnRegisterCard).click();

        sleep(2000);
        switchTo().alert().accept();

        $(btnBack).click();
        $(btnClientCard).click();

        return new RegistratCard();
    }

    public static Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}