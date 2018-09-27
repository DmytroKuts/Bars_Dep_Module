///*import com.codeborne.selenide.Configuration;
//import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
//import org.junit.BeforeClass;
//import org.openqa.selenium.WebDriver;
//
//import static com.codeborne.selenide.Configuration.browser;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.url;
//
//public class MainClassTest {
//    //private WebDriver driver;
//    //private  RegistratCard registratCard;
//@BeforeClass
//public  static void BeforeClassMethod(){
//    /*System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
//    driver = new InternetExplorerDriver();
//    driver.manage().window().maximize();
//    driver.get("http://10.10.17.50:8080/barsroot/account/login/");
//    String URL = driver.getCurrentUrl();
//    registratCard = new RegistratCard(driver);*//*
//
//    System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
//    Configuration.browser = "ie";
//    open("http://10.10.17.22:8080/barsroot/account/login/");
//
//    String URL = url();
//    InvocationPlugins.Registration registration = new InvocationPlugins.Registration();
//    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/") ||
//            URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
//            URL.equals("http://10.10.17.50:8080/barsroot/account/login/")){
//        registration.registerUserPass("qwerty", "absadm01");
//    } else {
//        registration.registerUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
//    }
//
//    ///////////////////// Логинимся под 3-м бранчом \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//
//    Come3Branch come3Branch = new Come3Branch(driver);
//    come3Branch.сome3Branch();
//
//
//    ////////////////// Используя уже созданного клиента открываем Карточку Клиента \\\\\\\\\\\\\\\\\\\\\\
//
//    DepModule depModule = new DepModule(driver);
//    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/")){
//        depModule.openCustCard("0000000000", "319791901");
//    }
//    else if(URL.equals("http://10.10.17.22:8080/barsroot/account/login/")){
//        depModule.openCustCard("0000000000", "96281701");
//    }
//    else {
//        depModule.openCustCard("0000000000", "97709601");  //для "http://10.10.17.50:8080/barsroot/"
//    }
//
//}
//
//@Test
//        public void registrCard ()
//    {
//        registratCard.registratCard("SALARY", "1301",
//                "SAL_UAH_2_33_MSTNDDEB_36_3",
//                "36",
//                "qqq");
//    }
//}
