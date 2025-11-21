package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends BasePage {

    public VideoPage(){

    }

    @FindBy(css="#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath ="//a[@data-testid=\"link-library\"]" )
    private WebElement libraryButton;

    public void clickLibraryButton(){
        waitAndClick(libraryButton);
    }

    @FindBy(xpath = "//a[@data-testid='nav-link-video-status']")
    private WebElement videoStatusButton;

    public void clickVideoStatusButton(){
        waitAndClick(videoStatusButton);
    }

    @FindBy(xpath = "//a[@data-testid='nav-link-library']")
    private WebElement againLibraryButton;

    public void clickAgainLibraryButton(){
        waitAndClick(againLibraryButton);
    }

    @FindBy(xpath = "/html/body/div/div[1]/div/main/div/div[4]/div")
    private WebElement videoHover;

    public void mouseHoverVideo(){
        hoverOverElement(videoHover);
    }

    @FindBy(xpath = "//button[contains(@class, 'bg-electric-blue')]")
    private WebElement playButton;

    public void clickPlayButton(){
        hoverOverElement(playButton);
        waitAndClick(playButton);
    }

    @FindBy(xpath = "//button[@data-testid=\"button-play-center\"]")
    private WebElement openButton;

    public void clickOpenButton(){
        waitAndClick(openButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-skip-back']")
    private WebElement backButton;

    public void clickBackButton(){
        waitAndClick(backButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-skip-forward']")
    private WebElement forwardButton;

    public void clickForwardButton(){
        waitAndClick(forwardButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-play-pause']")
    private WebElement pauseButton;

    public void clickPauseButton(){
        hoverOverElement(pauseButton);
        waitAndClick(pauseButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-toggle-mute']")
    private WebElement soundButton;

    public void clickSoundButton(){
        waitAndClick(soundButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-toggle-fullscreen']")
    private WebElement fullScreenButton;

    public void clickFullScreenButton(){
        waitAndClick(fullScreenButton);
    }

    @FindBy(xpath = "//button[@data-testid='button-download-video']")
    private WebElement instalButton;

    public void clickInstalButton(){
        waitAndClick(instalButton);
    }

    @FindBy(xpath="//button[@data-testid='button-close-player']")
    private WebElement closeButton;

    public void clickCloseButton(){
        waitAndClick(closeButton);
    }

    @FindBy(xpath="//button[starts-with(@data-testid, 'button-actions-')]")
    private WebElement contextButton;

    public void clickContextButton(){
        waitAndClick(contextButton);
    }

    @FindBy(xpath = "//div[starts-with(@data-testid, 'action-download-')]")
    private WebElement downloadButton;

    public void clickDownloadButton(){
        waitAndClick(downloadButton);
    }

//    @FindBy(xpath = "/html/body/div[2]/div/div[3]")
//    private WebElement shareButton;
//
//    public void clickShareButton(){
//        waitAndClick(shareButton);
//    }




    public WebElement getVideoHover() {
        return videoHover;
    }

    public WebElement getPlayButton() {
        return playButton;
    }

    public WebElement getOpenButton() {
        return openButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getForwardButton() {
        return forwardButton;
    }

    public WebElement getPauseButton() {
        return pauseButton;
    }

    public WebElement getSoundButton() {
        return soundButton;
    }

    public WebElement getFullScreenButton() {
        return fullScreenButton;
    }

    public WebElement getInstalButton() {
        return instalButton;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getContextButton() {
        return contextButton;
    }

    public WebElement getDownloadButton() {
        return downloadButton;
    }


}
