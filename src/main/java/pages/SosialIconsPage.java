package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SosialIconsPage extends BasePage{

    public SosialIconsPage (){}

    @FindBy(css = "svg[data-testid=\"breadcrumb-home\"]")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(css = "svg.lucide.lucide-twitter.h-5.w-5")
    private WebElement twitterButton;

    public void clickTwitterButton(){
        waitAndClick(twitterButton);
    }


    @FindBy(css = "svg.lucide.lucide-facebook.h-5.w-5")
    private WebElement facebookButton;

    public void clickFacebookButton(){
        waitAndClick(facebookButton);
    }

    @FindBy(css = "svg.lucide.lucide-instagram.h-5.w-5")
    private WebElement instagramButton;

    public void clickInstagramButton(){
        waitAndClick(instagramButton);
    }



    public WebElement getTwitterButton() {
        return twitterButton;
    }

    public WebElement getFacebookButton() {
        return facebookButton;
    }

    public WebElement getInstagramButton() {
        return instagramButton;
    }
}
