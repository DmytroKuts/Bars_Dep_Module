import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopFunction {
    WebDriver driver;
    public TopFunction (WebDriver driver) {
        this.driver = driver;
    }
    static WebDriverWait vait;

    void  VoidXpath10sec (By name){
        vait = (WebDriverWait) new WebDriverWait(driver, 10,10).ignoring(NoSuchElementException.class);
        vait.until(ExpectedConditions.presenceOfElementLocated(name));
        }

    void  VoidXpath60sec (By name){
        vait = new WebDriverWait(driver, 30,6000);
        vait.until(ExpectedConditions.presenceOfElementLocated(name));
    }

    void userDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}