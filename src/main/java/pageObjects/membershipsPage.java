package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Base;

import java.io.IOException;
import java.util.List;

public class membershipsPage extends Base {

    private @FindBy(xpath = "//div[@class='panel panel-bordered ng-scope']//div[@class='panel-body']")
    WebElement details;

    private @FindBy(xpath = "//h2[contains(text(),'Current Membership')]")
    WebElement currentMembershipTitle;
    private @FindBy(xpath = "//span[@class='ng-binding']")
    List<WebElement> membershipDetails;

    public boolean areMembershipDetailsDisplayed(String text) {

        for (WebElement element : membershipDetails) {
            if (element.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }


    public boolean isCurrentMembershipDisplayed(String text) {
        utils.waitForElementVisibility(driver,currentMembershipTitle);
        return currentMembershipTitle.isDisplayed();
    }
}