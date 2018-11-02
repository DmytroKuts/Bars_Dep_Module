import com.codeborne.selenide.junit.TextReport;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


public class Dep_Mod_UO {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);

    @BeforeClass
    public static void BeforeClassMethod() {
       LoginPage loginPage = new LoginPage();
        loginPage.LoginPageStart("http://10.10.17.50:8080/barsroot/account/login/", "ie");
        ///////////////////// Логинимся под 2-м бранчом
        Come3Branch come3Branch = new Come3Branch();
        come3Branch.сome3Branch(2);
    }

    @Test
    public void CreateDep_UO() {
        Dep_UO dep_UO = new Dep_UO();
        dep_UO.open_Dep_UO();
        dep_UO.registrat_Dep_UO("98116101", "4", "980", "2600830282", "9999999999", "2");
        }
}


