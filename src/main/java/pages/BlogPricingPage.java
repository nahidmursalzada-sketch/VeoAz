package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPricingPage extends  BasePage{

    public BlogPricingPage(){

    }

    @FindBy(css ="#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg" )
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogButton;

    public void clickBlogButton(){
        waitAndClick(blogButton);
    }

    @FindBy(xpath = "//button[normalize-space(text())='Pricing']")
    private WebElement pricingButton;

    public void clickPricingButton(){
        waitAndClick(pricingButton);
    }

    @FindBy(xpath = "//button[normalize-space(text())='Read More']")
    private WebElement readMoreButton;

    public void clickReadMoreButton(){
        waitAndClick(readMoreButton);
    }

    @FindBy(xpath="//button[text()='Share']")
    private WebElement shareButton;

    public void clickShareButton(){
        waitAndClick(shareButton);
    }

    @FindBy(xpath = "//button[contains(text(), 'Back to Blog')]")
    private WebElement backBlogButton;

    public void clickBackBlogButton(){
        waitAndClick(backBlogButton);
    }



















































































































}
