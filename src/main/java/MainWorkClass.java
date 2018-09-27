import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainWorkClass {

public static void main (String[] args)  {
   /* System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
    WebDriver driver = new InternetExplorerDriver();
    driver.manage().window().maximize();
    driver.get("http://10.10.17.22:8080/barsroot/account/login/");*/


    System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
    Configuration.browser = "ie";
    open("http://10.10.17.22:8080/barsroot/account/login/");

    String URL = url();

    Registration registration = new Registration();
    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/") ||
            URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
            URL.equals("http://10.10.17.50:8080/barsroot/account/login/")){
        registration.registerUserPass("qwerty", "absadm01");
    } else {
        registration.registerUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
    }

    ///////////////////// Логинимся под 3-м бранчом \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    Come3Branch come3Branch = new Come3Branch();
    come3Branch.сome3Branch();


    ////////////////// Используя уже созданного клиента открываем Карточку Клиента \\\\\\\\\\\\\\\\\\\\\\
/*
    DepModule depModule = new DepModule(driver);
    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/")){
        depModule.openCustCard("0000000000", "319791901");
    }
    else if(URL.equals("http://10.10.17.22:8080/barsroot/account/login/")){
        depModule.openCustCard("0000000000", "96281701");
    }
    else {
        depModule.openCustCard("0000000000", "97709601");  //для "http://10.10.17.50:8080/barsroot/"
    }

    /////////////////// Создаем по клиенту карточный счет, передаем параметры карточки \\\\\\\\\\\\\\\\\\\\\\\\\

    RegistratCard registratCard = new RegistratCard(driver);
    registratCard.registratCard("SALARY", "1301",
            "SAL_UAH_2_33_MSTNDDEB_36_3",
            "36",
            "qqq");

    //////////////////// Создаем по клиенту депозит, передаем параметры депозита \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

   RegistratContract registratContract = new RegistratContract(driver);
    registratContract.кegistratContract("48", "980",
 "2063", "100000");*/
}
}

/*Connection conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@<10.10.17.23>:<1521>:<COBUSUPABS_TEST_MMFO_DB>", "<bars>", "<barsbars>");*/
