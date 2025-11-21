package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalPage extends BasePage {

    public LegalPage(){

    }

    @FindBy(xpath = "//a[@data-testid='link-home']")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[text()='Privacy']")
    private WebElement privacyButton;

    public void clickPrivacyButton(){
        waitAndClick(privacyButton);
    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement backButton;

    public void clickBackButton(){
        waitAndClick(backButton);
    }

    @FindBy(xpath = "//a[text()='Terms']")
    private WebElement termsButton;

    public void clickTermsButton(){
        waitAndClick(termsButton);
    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement backTwoButton;

    public void clickBackTwoButton(){
        waitAndClick(backTwoButton);
    }

    @FindBy(xpath = "//a[text()='Refunds']")
    private WebElement refundsButton;

    public void clickRefundsButton(){
        waitAndClick(refundsButton);
    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement backThreeButton;

    public void clickBackThreeButton(){
        waitAndClick(backThreeButton);
    }

    @FindBy(xpath = "//a[text()='Accessibility']")
    private WebElement accessibilityButton;

    public void clickAccessibilityButton(){
        waitAndClick(accessibilityButton);
    }


    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getPrivacyButton() {
        return privacyButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getTermsButton() {
        return termsButton;
    }

    public WebElement getBackTwoButton() {
        return backTwoButton;
    }

    public WebElement getRefundsButton() {
        return refundsButton;
    }

    public WebElement getBackThreeButton() {
        return backThreeButton;
    }

    public WebElement getAccessibilityButton() {
        return accessibilityButton;
    }
}
