import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TopFunction {
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


}
