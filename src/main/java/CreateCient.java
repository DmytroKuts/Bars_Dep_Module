import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateCient {
    WebDriver driver ;

    public CreateCient (WebDriver driver) {
        this.driver = driver;
    }
    static WebDriverWait vait;

    private By mainStartWorkCust = By.xpath("//div[@class ='menuTitle']//td[contains(text(), 'АРМ Реєстрація клієнтів і рахунків (ФО)')]");
    private By StartWorkCust = By.xpath("//*[@id='oper-3039']");
    private By registerCust = By.xpath("//*[@id='registerCustBtn']");



}
