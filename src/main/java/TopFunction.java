import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TopFunction {
    void GoWindow (String window){

        for (String windowsHandles : getWebDriver().getWindowHandles()) {
            if (!windowsHandles.equals(window))
            {
                getWebDriver().switchTo().window(windowsHandles);
                //getWebDriver().manage().window().maximize();
            }
            getWebDriver().switchTo().window(windowsHandles);
        }
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

}
