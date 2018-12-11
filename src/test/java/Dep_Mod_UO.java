import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Logger;

public class Dep_Mod_UO {
    @BeforeClass
    public static void beforeClassMethod() {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginPageStart("http://10.10.17.50:8080/barsroot/", "ie");
        Logger log = Logger.getLogger(Dep_Mod_UO.class.getName());
        Dep_UO dep_UO = new Dep_UO();

        log.info(" Логинимся под 2-м бранчом ");
        Come3Branch come3Branch = new Come3Branch();
        come3Branch.сome3Branch(2);

        log.info(" Открываем Форму Депозитов ЮО ");
        dep_UO.open_Dep_UO();
    }
    @Test
    public void сreateDep_UO_MaxSum() {
        Dep_UO dep_UO = new Dep_UO();
        dep_UO.registrat_Dep_UO("98116101", "4", "980", "2600830282", "9999999999", "2");
        }

    @Test
    public void сreateDep_UO_MinSum() {
        Dep_UO dep_UO2 = new Dep_UO();
        dep_UO2.registrat_Dep_UO("98116101", "4", "980", "2600830282", "1", "2");
    }

    @Test
    public void CreateDep_UO_NullValue() {
        Dep_UO dep_UO3 = new Dep_UO();
        Assert.assertEquals(dep_UO3.registrat_Dep_UO_All_Null(), "Is Displayed = truetruetruetruetrue");
    }
}


