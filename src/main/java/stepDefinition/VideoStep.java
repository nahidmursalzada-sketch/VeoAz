package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import config.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.VideoPage;

public class VideoStep {
    WebDriver driver;

    private final VideoPage videoPage;
    private final BasePage basePage;
    private final SoftAssert softAssert;
    public VideoStep(){
        videoPage=new VideoPage();
        basePage=new BasePage();
        softAssert=new SoftAssert();
        this.driver = WebDriverManager.getChromeDriver();
    }


    @Given("The user returns to the main entrance of the site")
    public void click_on_the_home_button(){
        videoPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The user returns to the main entrance of the site");
    }

    @When("Click on the library button.")
    public void click_on_the_library_button(){
        videoPage.clickLibraryButton();
        ExtentManager.getTest().log(Status.INFO,"Click on the library button.");
    }

    @Then("Click on the video status button")
    public void click_on_the_video_status_button()throws InterruptedException{
        videoPage.clickVideoStatusButton();
        Thread.sleep(1000);
        ExtentManager.getTest().log(Status.INFO,"Click on the video status button");
    }

    @And("Click the library button again")
    public void click_the_library_button_again()throws InterruptedException{
        videoPage.clickAgainLibraryButton();
        Thread.sleep(10000);
        ExtentManager.getTest().log(Status.INFO,"Click the library button again");
    }

    @And("The mouse is moved over the video")
    public void the_mouse_is_moved_over_the_video() {

        if (basePage.isElementVisible(videoPage.getVideoHover())){
            videoPage.mouseHoverVideo();
            ExtentManager.getTest().log(Status.PASS,"Mouse ugurla videonun uzerine getirildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Mouse videonun uzerine getirilmedi");
            softAssert.fail("Mouse videonun uzerine getirilmedi");
        }

    }

    @And("Click on the play button")
    public void click_on_the_play_button(){

        if (basePage.isElementVisible(videoPage.getPlayButton())){
            videoPage.clickPlayButton();
            if (basePage.isClickSuccessful(videoPage.getPlayButton(), By.xpath("//button[@data-testid='button-download-video']"))){
                ExtentManager.getTest().log(Status.PASS,"Play butonuna klik edildi ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Play butonuna klik edilmedi ve her hansi deyisiklik bas vermedi");
                softAssert.fail("Play butonuna klik edilmedi ve her hansi deyisiklik bas vermedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Play butonu gorulmedi");
            softAssert.fail("Play butonu gorulmedi");
        }

    }

    @And("Click on the open button")
    public void click_on_the_open_button()throws InterruptedException{

        if (basePage.isElementVisible(videoPage.getOpenButton())){
            videoPage.clickOpenButton();
            Thread.sleep(5000);
            ExtentManager.getTest().log(Status.PASS,"Open butonuna klik edildi ve video oynadildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Open butonu gorulmedi");
            softAssert.fail("Open butonu gorulmedi");
        }

    }

    @And("When the video is played, the change of the second is viewed")
    public void videoSeconds(){
        WebElement video = driver.findElement(By.xpath("//span[@data-orientation='horizontal' and contains(@class,'bg-primary')]"));

        boolean isPlaying = basePage.isVideoPlaying(video, 5);

        if (isPlaying) {
            ExtentManager.getTest().log(Status.PASS,"Video oynadildi ve saniye dogru sekilde isledi");
        } else {
            ExtentManager.getTest().log(Status.FAIL,"Video oynadildi ancaq saniye deyismedi");
            softAssert.fail("Video oynadildi ancaq saniye deyismedi");

    }
    }

    @And("Click on the back and forward button")
    public void click_on_the_back_and_forward_button(){


        if (basePage.isElementVisible(videoPage.getBackButton())){
            videoPage.clickBackButton();
            ExtentManager.getTest().log(Status.PASS,"Back butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Back butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Back butonu gorulmedi ve klik ugursuz oldu");
        }

        if (basePage.isElementVisible(videoPage.getForwardButton())){
            videoPage.clickForwardButton();
            ExtentManager.getTest().log(Status.PASS,"Forward butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Forward butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Forward butonu gorulmedi ve klik ugursuz oldu");
        }

    }

    @And("Click on the pause button")
    public void click_on_the_pause_button(){

        if (basePage.isElementVisible(videoPage.getPauseButton())){
            videoPage.clickPauseButton();
            ExtentManager.getTest().log(Status.PASS,"Pause butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Pause butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Pause butonu gorulmedi ve klik ugursuz oldu");
        }
    }

    @And("Click on the sound button")
    public void click_on_the_sound_button(){

        if (basePage.isElementVisible(videoPage.getSoundButton())){
            videoPage.clickSoundButton();
            ExtentManager.getTest().log(Status.PASS,"Sound butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Sound butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Sound butonu gorulmedi ve klik ugursuz oldu");
        }
    }

    @And("Click on the full screen button")
    public void click_on_the_full_screen_button(){

        if (basePage.isElementVisible(videoPage.getFullScreenButton())){
            videoPage.clickFullScreenButton();
            ExtentManager.getTest().log(Status.PASS,"Full screen butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Full screen butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Full screen butonu gorulmedi ve klik ugursuz oldu");
        }
    }

    @And("Click on the instal button")
    public void click_on_the_instal_button(){

        if (basePage.isElementVisible(videoPage.getInstalButton())){
            videoPage.clickInstalButton();
            ExtentManager.getTest().log(Status.PASS,"Instal butonu goruldu,ugurla klik edildi ve video yuklendi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Instal butonu gorulmedi,klik ugursuz oldu ve video yuklenmedi");
            softAssert.fail("Instal butonu gorulmedi,klik ugursuz oldu ve video yuklenmedi");
        }
    }

    @And("Click on the close button")
    public void click_on_the_close_button(){

        if (basePage.isElementVisible(videoPage.getCloseButton())){
            videoPage.clickCloseButton();
            ExtentManager.getTest().log(Status.PASS,"Close butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Close butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Close butonu gorulmedi ve klik ugursuz oldu");
        }
    }

    @And("Click on the context button")
    public void click_on_the_context_button(){
        videoPage.mouseHoverVideo();

        if (basePage.isElementVisible(videoPage.getContextButton())){
            videoPage.clickContextButton();
            ExtentManager.getTest().log(Status.PASS,"Context butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Context butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Context butonu gorulmedi ve klik ugursuz oldu");
        }

    }

    @And("Click on the download button")
    public void click_on_the_download_button(){

        if (basePage.isElementVisible(videoPage.getDownloadButton())){
            videoPage.clickDownloadButton();
            ExtentManager.getTest().log(Status.PASS,"Download butonu goruldu ve ugurla klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Download butonu gorulmedi ve klik ugursuz oldu");
            softAssert.fail("Download butonu gorulmedi ve klik ugursuz oldu");
        }
    }
















































































}
