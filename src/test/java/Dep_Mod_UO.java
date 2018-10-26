import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Dep_Mod_UO {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);



    @BeforeClass
    public static void BeforeClassMethod() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
        Configuration.browser = "ie";
        open("http://10.10.17.22:8080/barsroot/account/login/");
        Configuration.holdBrowserOpen = true;
        //System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));

        String URL = url();
        Registration registration = new Registration();
        if (URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.17.40:8082/barsroot/account/login/") ||
                URL.equals("http://10.10.17.50:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.17.40:8080/barsroot/account/login/")) {
            registration.registerUserPass("qwerty", "absadm01");
        } else {
            registration.registerUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
        }

        ///////////////////// Логинимся под 2-м бранчом

        Come3Branch come3Branch = new Come3Branch();
        come3Branch.сome3Branch(2);
    }
    /////////////////////

    @Test
    public void CreateDep_UO() {
        //StackTraceElement[] ste = Thread.currentThread().getStackTrace();

        Dep_UO dep_UO = new Dep_UO();
        dep_UO.open_Dep_UO();

                    dep_UO.open_Dep_UO();
        }
        }


