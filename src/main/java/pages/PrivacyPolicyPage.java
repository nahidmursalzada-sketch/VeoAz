package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends BasePage {

    public PrivacyPolicyPage (){

    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[@href='/legal/privacy' and text()='Privacy Policy']")
    private WebElement privacyPolicyButton;

    public void clickPrivacyPolicyButton(){
        waitAndClick(privacyPolicyButton);
    }




































































}
