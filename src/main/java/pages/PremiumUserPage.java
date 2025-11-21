package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PremiumUserPage extends BasePage{

    public PremiumUserPage(){

    }

    @FindBy(xpath = "//a[@data-testid='link-home']")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//button[contains(@class,'btn-primary') and contains(., 'New Video')]")
    private WebElement newVideoButton;

    public void clickNewVideoButton(){
       waitAndClick(newVideoButton);
    }

    @FindBy(xpath = "//div[contains(@class,'cursor-pointer') and contains(.,'Create')]")
    private WebElement createButton;

    public void clickCreateButton(){
        waitAndClick(createButton);
    }

    @FindBy(xpath = "//div[contains(@class,'cursor-pointer') and contains(.,'Library')]")
    private WebElement libraryButton;

    public void clickLibraryButton(){
        waitAndClick(libraryButton);
    }

    @FindBy(xpath = "//div[contains(@class,'cursor-pointer') and contains(.,'Settings')]")
    private WebElement settingsButton;

    public void clickSettingsButton(){
        waitAndClick(settingsButton);
    }

    @FindBy(xpath = "//h5[@class='font-medium mb-1' and text()='City View']")
    private WebElement cityViewVideo;

    public void clickCityViewVideoButton(){
        waitAndClick(cityViewVideo);
    }

    @FindBy(css = "#features > div > div.relative.cinematic-card.overflow-hidden > div.grid.lg\\:grid-cols-4.gap-6.p-6 > div.lg\\:col-span-3.space-y-6 > div:nth-child(2) > div > div:nth-child(1) > div.p-4 > div > div.flex.items-center.space-x-2 > button:nth-child(1)")
    private WebElement cityViewVideoInstalButton;

    public void clickCityViewVideoInstalButton(){
        waitAndClick(cityViewVideoInstalButton);
    }

    @FindBy(css="#features > div > div.relative.cinematic-card.overflow-hidden > div.grid.lg\\:grid-cols-4.gap-6.p-6 > div.lg\\:col-span-3.space-y-6 > div:nth-child(2) > div > div:nth-child(1) > div.p-4 > div > div.flex.items-center.space-x-2 > button:nth-child(2) > svg")
    private WebElement cityViewVideoEllipsisButton;

    public void clickCityViewVideoEllipsisButton(){
        waitAndClick(cityViewVideoEllipsisButton);
    }

    @FindBy(xpath = "//h5[@class='font-medium mb-1' and text()='Nature Scene']")
    private WebElement natureSceneVideo;

    public void clickNatureSceneVideo(){
        waitAndClick(natureSceneVideo);
    }

    @FindBy(xpath = "//h5[@class='font-medium mb-1' and text()='Creative Space']")
    private WebElement creativSpaceVideo;

    public void clickCreativSpaceVideo(){
        waitAndClick(creativSpaceVideo);
    }

    @FindBy(css = "#features > div > div.relative.cinematic-card.overflow-hidden > div.grid.lg\\:grid-cols-4.gap-6.p-6 > div.lg\\:col-span-3.space-y-6 > div:nth-child(2) > div > div:nth-child(3) > div.p-4 > div > div.flex.items-center.space-x-2 > button:nth-child(1) > svg")
    private WebElement creativSpaceVideoInstalButton;

    public void clickCreativSpaceVideoInstalButton(){
        waitAndClick(creativSpaceVideoInstalButton);
    }

    @FindBy(css = "#features > div > div.relative.cinematic-card.overflow-hidden > div.grid.lg\\:grid-cols-4.gap-6.p-6 > div.lg\\:col-span-3.space-y-6 > div:nth-child(2) > div > div:nth-child(3) > div.p-4 > div > div.flex.items-center.space-x-2 > button:nth-child(2) > svg")
    private WebElement creativSpaceVideoEllipsisButton;

    public void clickCreativSpaceVideoEllipsisButton(){
        waitAndClick(creativSpaceVideoEllipsisButton);
    }


    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getNewVideoButton() {
        return newVideoButton;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getLibraryButton() {
        return libraryButton;
    }

    public WebElement getSettingsButton() {
        return settingsButton;
    }

    public WebElement getCityViewVideo() {
        return cityViewVideo;
    }

    public WebElement getCityViewVideoInstalButton() {
        return cityViewVideoInstalButton;
    }

    public WebElement getCityViewVideoEllipsisButton() {
        return cityViewVideoEllipsisButton;
    }

    public WebElement getNatureSceneVideo() {
        return natureSceneVideo;
    }

    public WebElement getCreativSpaceVideo() {
        return creativSpaceVideo;
    }

    public WebElement getCreativSpaceVideoInstalButton() {
        return creativSpaceVideoInstalButton;
    }

    public WebElement getCreativSpaceVideoEllipsisButton() {
        return creativSpaceVideoEllipsisButton;
    }
}
