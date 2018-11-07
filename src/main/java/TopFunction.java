import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TopFunction {
    Logger log = Logger.getLogger(TopFunction.class.getName());
     void   GoWindow (String window){
        getWebDriver().getWindowHandle(); ///// костыль т.к. при первом вызове getWebDriver().getWindowHandle()  возвращает null
        for (String windowsHandles : getWebDriver().getWindowHandles()) {
            if (!windowsHandles.equals(window))
            {
                getWebDriver().switchTo().window(windowsHandles);
            }
        }
    }

    void MaxWindow(){
        getWebDriver().manage().window().maximize();
    }

    Select GetSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    void userDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void WaitGoWindowElementCl(SelenideElement Element, String Window) {
        try {
            GoWindow(Window);
            sleep(2000);
            $(Element).click();
        } catch (Exception e) {
            sleep(2000);
            GoWindow(Window);
            sleep(2000);
            log.info("Окно текущее: " + getWebDriver().getWindowHandle() + "// Окна " + getWebDriver().getWindowHandles()
                    + "// Кондиция xPath " + $(Element).shouldBe(Condition.visible));
            $(Element).click();
        }
    }


}
