package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage {

    public HelpPage(){

    }

    @FindBy(css = "img[src=\"/logo-full.png\"]")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "//a[@href='/support' and text()='Help']")
    private WebElement helpButton;

    public void clickHelpButton(){
        waitAndClick(helpButton);

    }

    @FindBy(xpath = "//button[normalize-space(text())='How do I create my first video?']")
    private WebElement firstVideoHowButton;

    public void clickFirstVideoHowButton(){
        doubleClick(firstVideoHowButton);
    }

    @FindBy(xpath = "//button[normalize-space(text())='How many videos can I create?']")
    private WebElement howManyVideosButton;

    public void clickHowManyVideosButton(){
        doubleClick(howManyVideosButton);
    }

    @FindBy(xpath = "//button[normalize-space(text())='Can I use videos commercially?']")
    private WebElement commerciallyButton;

    public void clickCommerciallyButton(){
        doubleClick(commerciallyButton);
    }

    @FindBy(xpath = "//button[normalize-space(text())=\"What if my video won't generate?\"]")
    private WebElement generateButton;

    public void clickGenerateButton(){
        doubleClick(generateButton);
    }

    @FindBy(xpath = "//input[@data-testid='input-search']")
    private WebElement searchInput;

    public void enterSearch(String search){
        waitAndClick(searchInput);
        searchInput.sendKeys(search);
    }

    @FindBy(xpath = "//button[@data-testid='button-search']")
    private WebElement searchButton;

    public void clickSearchButton(){
        waitAndClick(searchButton);
    }

    @FindBy(xpath = "//button[@data-testid='tab-contact']")
    private WebElement contactButton;

    public void clickContactButton(){
        waitAndClick(contactButton);
    }


    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getHelpButton() {
        return helpButton;
    }

    public WebElement getFirstVideoHowButton() {
        return firstVideoHowButton;
    }

    public WebElement getHowManyVideosButton() {
        return howManyVideosButton;
    }

    public WebElement getCommerciallyButton() {
        return commerciallyButton;
    }

    public WebElement getGenerateButton() {
        return generateButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getContactButton() {
        return contactButton;
    }
}
