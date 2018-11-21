import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TopFunction {
    Logger log = Logger.getLogger(TopFunction.class.getName());

    void GoWindow(String window) {
        getWebDriver().getWindowHandle(); ///// костыль т.к. при первом вызове getWebDriver().getWindowHandle()  возвращает null
        for (String windowsHandles : getWebDriver().getWindowHandles()) {
            if (!windowsHandles.equals(window)) {
                getWebDriver().switchTo().window(windowsHandles);
            }
        }
    }

    void MaxWindow() {
        getWebDriver().manage().window().maximize();
    }

    Select GetSelect(SelenideElement element) {
        Select select = new Select(element);
        return select;
    }

    void waitGoWindowElementCl(SelenideElement Element1, SelenideElement Element2) {
        //sleep(4000);
        Set<String> oldWindowsSet = getWebDriver().getWindowHandles();
        Element1.click();
        sleep(2000);
        Set<String> newWindowsSet = getWebDriver().getWindowHandles();
        sleep(2000);

        newWindowsSet.removeAll(oldWindowsSet);
        sleep(4000);
        String newWindowHandle = newWindowsSet.iterator().next();
        //sleep(4000);
        getWebDriver().switchTo().window(newWindowHandle);
        //sleep(2000);
        Element2.click();
    }
    void waitGoWindowElementCl(SelenideElement Element1, Set<String>  Window) {
        sleep(2000);
        Set<String> oldWindowsSet = Window;
        Set<String> newWindowsSet = getWebDriver().getWindowHandles();

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        getWebDriver().switchTo().window(newWindowHandle);
        sleep(2000);
        Element1.click();
    }

    void waitGoWindowElementCl(Set<String>  Window) {
        sleep(2000);
        Set<String> oldWindowsSet = Window;
        Set<String> newWindowsSet = getWebDriver().getWindowHandles();

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        getWebDriver().switchTo().window(newWindowHandle);
        sleep(2000);
    }
}
