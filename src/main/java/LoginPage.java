import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public   class LoginPage {
    private SelenideElement txtUserName = $(By.id("txtUserName"));
    private SelenideElement txtPassword = $(By.id("txtPassword"));
    private SelenideElement login_cl = $(By.id("btLogIn"));
    private SelenideElement ChangDate_cl = $(By.id("btChangDate"));

    public  void LoginPageStart(String url, String browser) {
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).arch32().setup();
        Configuration.browser = browser;
        open(url);
        Configuration.holdBrowserOpen = true;
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String URL = url();
        if (URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.17.40:8082/barsroot/account/login/") ||
                URL.equals("http://10.10.17.50:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.10.198:11111/barsroot/account/login/") ||
                URL.equals("http://10.10.17.24:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.17.40:8080/barsroot/account/login/")) {
            RegisterUserPass("qwerty", "absadm01");
        } else {
            RegisterUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
        }
    }


    public  void RegisterUserPass  (String password, String username){
        txtPassword.clear();
        txtPassword.sendKeys(password);
        txtUserName.clear();
        txtUserName.sendKeys(username);
        login_cl.click();
        ChangDate_cl.click();
    }
}
