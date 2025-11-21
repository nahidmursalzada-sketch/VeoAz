package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogAllPage extends BasePage {


    public BlogAllPage(){}

    @FindBy(css ="#root > div.min-h-screen.bg-space-black > nav > div > div > a > img" )
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogButton;

    public void clickBlogButton(){
        waitAndClick(blogButton);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[3]/div/div[1]/div[2]/a/button")
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

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[3]/div/div[2]/div[2]/a/button")
    private WebElement readMoreTwoButton;

    public void clickReadMoreTwoButton(){
        waitAndClick(readMoreTwoButton);
    }

    @FindBy(xpath = "/html/body/div/div[1]/div/main/div/div/div[4]/div[1]/div[2]/a/button")
    private WebElement readMoreThreeButton;

    public void clickReadMoreThreeButton(){
        waitAndClick(readMoreThreeButton);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[4]/div[2]/div[2]/a/button")
    private WebElement readMoreFourButton;

    public void clickReadMoreFourButton(){
        waitAndClick(readMoreFourButton);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[4]/div[3]/div[2]/a/button")
    private WebElement readMoreFiveButton;

    public void clickReadMoreFiveButton(){
        waitAndClick(readMoreFiveButton);
    }

    @FindBy(xpath = "//input[@placeholder='Search articles...']")
    public WebElement articleInput;

    public void enterArticle(String article){
        waitAndClick(articleInput);
        articleInput.sendKeys(article);
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getBlogButton() {
        return blogButton;
    }

    public WebElement getReadMoreButton() {
        return readMoreButton;
    }

    public WebElement getShareButton() {
        return shareButton;
    }

    public WebElement getBackBlogButton() {
        return backBlogButton;
    }

    public WebElement getReadMoreTwoButton() {
        return readMoreTwoButton;
    }

    public WebElement getReadMoreThreeButton() {
        return readMoreThreeButton;
    }

    public WebElement getReadMoreFourButton() {
        return readMoreFourButton;
    }

    public WebElement getReadMoreFiveButton() {
        return readMoreFiveButton;
    }

    public WebElement getArticleInput() {
        return articleInput;
    }
}
