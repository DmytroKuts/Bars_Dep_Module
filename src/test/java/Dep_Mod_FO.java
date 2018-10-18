import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Configuration.fastSetValue;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Dep_Mod_FO {

    @BeforeClass
    public static void BeforeClassMethod() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
        Configuration.browser = "ie";
        open("http://10.10.17.50:8080/barsroot/account/login/");
        Configuration.holdBrowserOpen = true;
        fastSetValue = true;

        String URL = url();
        Registration registration = new Registration();
        if (URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
                URL.equals("http://10.10.17.40:8082/barsroot/account/login/") ||
                URL.equals("http://10.10.17.50:8080/barsroot/account/login/")||
                URL.equals("http://10.10.17.40:8080/barsroot/account/login/")) {
            registration.registerUserPass("qwerty", "absadm01");
        } else {
            registration.registerUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
        }

        ///////////////////// Логинимся под 3-м бранчом

        Come3Branch come3Branch = new Come3Branch();
        come3Branch.сome3Branch(3);

        ////////////////// Используя уже созданного клиента открываем Карточку Клиента

        DepModule depModule = new DepModule();
        if (URL.equals("http://10.10.17.40:8080/barsroot/account/login/")) {
            depModule.openCustCard("0000000000", "319791901");
        } else if (URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
                (URL.equals("http://10.10.17.40:8082/barsroot/account/login/") )) {
            depModule.openCustCard("0000000000", "96281701");
        } else {
            depModule.openCustCard("0000000000", "97709601");  //для "http://10.10.17.50:8080/barsroot/"
        }
    }


    @Test
/////////////////// Создаем по клиенту карточный счет, передаем параметры карточки
    public void registratCard() {
        try {
            RegistratCard registratCard = new RegistratCard();
            registratCard.registratCard("SALARY", "1301",
                    "SAL_UAH_2_33_MSTNDDEB_36_3",
                    "36",
                    "qqq");
        } catch (Exception e) {
            $x("//*[@id='btnBack']").click();
        }
    }

////////////////////////// Создаем депозит
    @Test
    public void registratContract() {
        RegistratContract registratContract = new RegistratContract();
        registratContract.кegistratContract("48", "980",
                "2063", "100000");
    }
}