package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoStatusPage extends BasePage {

    public VideoStatusPage (){}

    @FindBy(css="#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[@data-testid='link-dashboard']")
    public WebElement dashboardButton;

    public void clickDashboardButton(){
        dashboardButton.click();
    }

    @FindBy(xpath = "//a[@data-testid='nav-link-video-status']")
    private WebElement videoStatusButton;

    public void clickVideoStatusButton(){
        waitAndClick(videoStatusButton);
    }

    @FindBy(xpath = "//button[normalize-space(.)='Yenilə']")
    private WebElement refreshButton;

    public void clickRefreshButton(){
        waitAndClick(refreshButton);
    }


    @FindBy(xpath = "//button[normalize-space(.)='Tamamlandı (1)']")
    private WebElement completedButton;

    public void clickCompletedButton(){
        waitAndClick(completedButton);
    }

    @FindBy(xpath = "/html/body/div/div[1]/div/main/div/div[3]/div[3]/div/div/div/div/div[2]/button[2]")
    private WebElement downloadButton;

    public void clickDownloadButton(){
        waitAndClick(downloadButton);
    }

    @FindBy(xpath = "//button[normalize-space(.)='Xəta (0)']")
    private WebElement failedButton;

    public void clickFailedButton(){
        waitAndClick(failedButton);
    }

    @FindBy(xpath = "//button[normalize-space(.)='Hamısı (1)']")
    private WebElement allButton;

    public void clickAllButton(){
        waitAndClick(allButton);
    }


    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getDashboardButton() {
        return dashboardButton;
    }

    public WebElement getVideoStatusButton() {
        return videoStatusButton;
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public WebElement getCompletedButton() {
        return completedButton;
    }

    public WebElement getDownloadButton() {
        return downloadButton;
    }

    public WebElement getFailedButton() {
        return failedButton;
    }

    public WebElement getAllButton() {
        return allButton;
    }
}
