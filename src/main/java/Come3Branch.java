import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Come3Branch {
    WebDriver driver ;
    TopFunction topFunction;


    public Come3Branch(WebDriver driver) { this.driver = driver;
    this.topFunction = new TopFunction(this.driver);}

    private By btnBranches1 = By.xpath("//a[@id='btnBranches']");
    private By btnBranchesSl = By.xpath("//div[@id='treeview']//ul[@class = 'k-group']//span[@class='k-icon k-plus']");
    private By btnBranches2 = By.xpath("//*[@id='treeview_tv_active']/ul/li[1]/div/span[1]");
    private By btnBranches3 = By.xpath("//*[@id='treeview_tv_active']/ul/li/div/span/span[1]");


    public Come3Branch сome3Branch (){
        topFunction.VoidXpath60sec(btnBranches1);
        driver.findElement(btnBranches1).click() ;
        driver.findElement(btnBranchesSl).click();
        topFunction.VoidXpath10sec(btnBranches2);
        driver.findElement(btnBranches2).click();
        topFunction.VoidXpath10sec(btnBranches3);
        driver.findElement(btnBranches3).click();
        return new Come3Branch(driver);
    }
    }
