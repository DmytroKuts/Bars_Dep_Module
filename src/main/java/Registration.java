import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Registration {
    private By txtUserName = By.xpath("//input[@id='txtUserName']");
    private By txtPassword = By.xpath("//input[@id='txtPassword']");
    private By login_cl = By.xpath("//input[@id='btLogIn']");
    private By ChangDate_cl = By.xpath("//*[@id='btChangDate']");

    public Registration UserName(String username){
       $(txtUserName).clear();
       $(txtUserName).sendKeys(username);
        return this;
    }

    public Registration Password(String password){
        $(txtPassword).clear();
        $(txtPassword).sendKeys(password);
        return this;
    }

    public Registration registerUserPass (String password, String username){
        this.Password(password);
        this.UserName(username);
        $(login_cl).click();
        $(ChangDate_cl).click();
        return new Registration();
    }
}
