import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.sql.SQLException;

public class MainWorkClass {

public static void main (String[] args) throws SQLException {
    System.setProperty("webdriver.ie.driver", "C:\\Users\\dmytro.kuts\\IdeaProjects\\Selenium_Test\\src\\test\\driver\\IEDriverServer.exe");
    WebDriver driver = new InternetExplorerDriver();
    driver.manage().window().maximize();
    driver.get("http://10.10.17.50:8080/barsroot/account/login/");
    String URL = driver.getCurrentUrl();

    Registration registration = new Registration(driver);
    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/") ||
            URL.equals("http://10.10.17.22:8080/barsroot/account/login/") ||
            URL.equals("http://10.10.17.50:8080/barsroot/account/login/")){
        registration.registerUserPass("qwerty", "absadm01");
    } else {
        registration.registerUserPass("qwerty123", "absadm"); //для "http://10.10.17.46:8080/barsroot/"
    }

    Come3Branch come3Branch = new Come3Branch(driver);
    come3Branch.сome3Branch();

    DepModule depModule = new DepModule(driver);
    if(URL.equals("http://10.10.17.40:8080/barsroot/account/login/")){
        depModule.openCustCard("0000000000", "319791901");     //  для "http://10.10.17.40:8080/barsroot/"
    }
    else if(URL.equals("http://10.10.17.22:8080/barsroot/account/login/")){    //для "http://10.10.17.22:8080/barsroot/"
        depModule.openCustCard("0000000000", "96281701");
    }
    else {
        depModule.openCustCard("0000000000", "97709601");  //для "http://10.10.17.50:8080/barsroot/"
    }

//    RegistratCard registratCard = new RegistratCard(driver);
//    registratCard.registratCard("SALARY", "1301",
//            "SAL_UAH_2_33_MSTNDDEB_36_3",
//            "36",
//            "qqq");

   RegistratContract registratContract = new RegistratContract(driver);
    registratContract.кegistratContract("48", "980",
 "2063", "100000");
}
}

/*Connection conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@<10.10.17.23>:<1521>:<COBUSUPABS_TEST_MMFO_DB>", "<bars>", "<barsbars>");*/
