import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Come3Branch {

    private SelenideElement btnBranches1 = $(By.id("btnBranches"));
    private SelenideElement btnBranchesSl = $x("//div[@id='treeview']//ul[@class = 'k-group']//span[@class='k-icon k-plus']");   // //span [contains(text(),' /300465/ ')]/ancestor-or-self::span/preceding-sibling::span[@class = 'k-icon k-plus']"
    private SelenideElement btnBranches2 = $x("//*[@id='treeview_tv_active']/ul/li[1]/div/span[1]");
    private SelenideElement btnBranches3 = $x("//*[@id='treeview_tv_active']/ul/li/div/span/span[1]");
    private SelenideElement btnBranches4 = $x("//*[@id='treeview_tv_active']/ul/li[1]/div/span[2]/span[1]");

    public Come3Branch сome3Branch(Number branch) {
        if(branch.equals(2)) {
            btnBranches1.shouldBe(Condition.visible).click();
            btnBranchesSl.shouldBe(Condition.visible).click();
            btnBranches4.shouldBe(Condition.visible).click();
        }
        else {
            btnBranches1.shouldBe(Condition.visible).click();
            btnBranchesSl.shouldBe(Condition.visible).click();
            btnBranches2.shouldBe(Condition.visible).click();
            btnBranches3.shouldBe(Condition.visible).click();
        }
            return new Come3Branch();

    }
}
