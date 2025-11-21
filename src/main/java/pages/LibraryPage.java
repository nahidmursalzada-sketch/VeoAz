package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LibraryPage extends BasePage {

    public LibraryPage(){

    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "//a[@data-testid='link-library']")
    private WebElement libraryButton;

    public void clickLibraryButton(){
        libraryButton.click();
    }


    @FindBy(xpath = "//input[@data-testid='input-search']")
    private WebElement videoSearchButton;

    public void enterVideo(String video){
        waitAndClick(videoSearchButton);
        videoSearchButton.sendKeys(video);
    }

    @FindBy(xpath = "//button[@data-testid='button-list-view']")
    private WebElement listButton;

    public void clickListButton(){
        waitAndClick(listButton);
    }

    @FindBy(xpath = "//button[@data-testid='select-filter']")
    private WebElement allButton;

    public void clickAllButton(){
        waitAndClick(allButton);
    }
    public boolean isAllButtonVisible(){
        try {
            return allButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//*[text()='Failed']")
    private WebElement selectStatusFilter;

    public void enterStatusFilter() {

        waitAndClick(selectStatusFilter);
    }

    @FindBy(xpath = "//button[@data-testid='select-sort']" )
    private WebElement newestButton;

    public void clickNewestButton(){
        waitAndClick(newestButton);
    }

    public void enterNewest(String sortingFilter) {

        String optionXpath = "//*[normalize-space(.)='" + sortingFilter + "']";
        clickByXpath(optionXpath);
    }


    @FindBy(xpath = "//a[@data-testid='button-create-first']")
    private WebElement firstVideoButton;

    public void clickFirstVideoButton(){
        waitAndClick(firstVideoButton);
    }


    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getLibraryButton() {
        return libraryButton;
    }

    public WebElement getVideoSearchButton() {
        return videoSearchButton;
    }

    public WebElement getListButton() {
        return listButton;
    }

    public WebElement getAllButton() {
        return allButton;
    }

    public WebElement getSelectStatusFilter() {
        return selectStatusFilter;
    }

    public WebElement getNewestButton() {
        return newestButton;
    }

    public WebElement getFirstVideoButton() {
        return firstVideoButton;
    }
}
