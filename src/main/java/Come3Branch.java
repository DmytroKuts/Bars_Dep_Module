import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Come3Branch {


    private By btnBranches1 = By.xpath("//a[@id='btnBranches']");
    private By btnBranchesSl = By.xpath("//div[@id='treeview']//ul[@class = 'k-group']//span[@class='k-icon k-plus']");
    private By btnBranches2 = By.xpath("//*[@id='treeview_tv_active']/ul/li[1]/div/span[1]");
    private By btnBranches3 = By.xpath("//*[@id='treeview_tv_active']/ul/li/div/span/span[1]");


    public Come3Branch сome3Branch (){
        $(btnBranches1).click();
        $(btnBranchesSl).click();
        $(btnBranches2).click();
        $(btnBranches3).click();
        return new Come3Branch();
    }
    }
