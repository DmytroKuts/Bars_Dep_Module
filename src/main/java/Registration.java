import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class Registration {
    private SelenideElement txtUserName = $(By.id("txtUserName"));
    private SelenideElement txtPassword = $(By.id("txtPassword"));
    private SelenideElement login_cl = $(By.id("btLogIn"));
    private SelenideElement ChangDate_cl = $(By.id("btChangDate"));


    public Registration UserName(String username){
        txtUserName.clear();
        txtUserName.sendKeys(username);
        return this;
    }

    public Registration Password(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public Registration registerUserPass (String password, String username){
        this.Password(password);
        this.UserName(username);
        login_cl.click();
        ChangDate_cl.click();
        return new Registration();
    }
}
