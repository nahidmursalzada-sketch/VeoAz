package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsServicePage extends BasePage {

    public TermsServicePage(){

    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[@href='/legal/terms' and text()='Terms of Service']")
    private WebElement termsServiceButton;

    public void clickTermsServiceButton(){
        waitAndClick(termsServiceButton);
    }

    @FindBy(xpath = "//a[@data-testid='breadcrumb-link-legal']")
    private WebElement legalButton;

    public void clickLegalButton(){
        waitAndClick(legalButton);
    }

    public WebElement getLegalButton() {
        return legalButton;
    }
}
