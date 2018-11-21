import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Dep_Mod_FO {

    @BeforeClass
    public static void BeforeClassMethod() {
        LoginPage loginPage = new LoginPage();
        Logger log = Logger.getLogger(Dep_Mod_FO.class.getName());
        log.info("*** Старт логина ФО***");
        loginPage.LoginPageStart("http://10.10.17.50:8080/barsroot/", "ie");

        log.info("*** Логинимся под 3-м бранчом ФО***");
        Come3Branch come3Branch = new Come3Branch();
        come3Branch.сome3Branch(3);

        log.info("*** Используя уже созданного клиента открываем Карточку Клиент ФО***");
        DepModule depModule = new DepModule();
        depModule.depModule(url());
    }

    @Test
    public void registratCard() {
        Logger log = Logger.getLogger(Dep_Mod_FO.class.getName());
        log.info("***Создаем по клиенту карточный счет, передаем параметры карточки ФО***");
        if ( url().equals("http://10.10.10.198:11111/barsroot/account/login/")) {
            try {
                RegistratCard registratCard = new RegistratCard();
                registratCard.registratCard("PENSION", "-1", "980",
                        "PENS_SOC_UAH_24",
                        "PENS_SOC_UAH_24_MDUKKPP_0",
                        "60",
                        "qqq");
            } catch (Exception e) {
                $x("//*[@id='btnBack']").click();
                throw new NullPointerException("Test is in exeption 198:111111");
            }
        }
            else {
                try {
                    RegistratCard registratCard = new RegistratCard();
                    registratCard.registratCard("SALARY", "1301","980",
                            "SAL_UAH_2_33",
                            "SAL_UAH_2_33_MSTNDDEB_36_3",
                            "36",
                            "qqq");
                } catch (Exception e) {
                    $x("//*[@id='btnBack']").click();
                    throw new NullPointerException("Test is in exeption " + url() + e.getStackTrace());
                }
            }
            }
    @Test
    public void registratContract() {
        Logger log = Logger.getLogger(Dep_Mod_FO.class.getName());
        log.info("*** Создаем депозит ФО ***");
        RegistratContract registratContract = new RegistratContract();
        registratContract.кegistratContract("48", "980",
                "2063", "100000");
    }

    @AfterClass
    public static void exit() {
        Selenide.close();
    }
}