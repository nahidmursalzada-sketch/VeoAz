package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.VideoStatusPage;

public class VideoStatusStep {

    private final VideoStatusPage videoStatusPage;
    private final SoftAssert softAssert;
    private final BasePage basePage;

    public VideoStatusStep(){
        videoStatusPage=new VideoStatusPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
    }


    @Given("Entering the main part of the site")
    public void entering_the_main_part_of_the_site(){
        videoStatusPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Entering the main part of the site");
    }

    @When("Dashboard is then clicked on the video status button")
    public void click_dashboard_videoStatus(){
        videoStatusPage.clickDashboardButton();
        videoStatusPage.clickVideoStatusButton();
        ExtentManager.getTest().log(Status.INFO,"Dashboard is then clicked on the video status button");
    }

    @Then("Click on the refresh button.")
    public void click_on_the_refresh_button(){
        if (basePage.isElementVisible(videoStatusPage.getRefreshButton())){
            videoStatusPage.clickRefreshButton();
            ExtentManager.getTest().log(Status.FAIL,"Refresh butonuna klik ugursuzdur,hec bir yenilenme bas vermir");
            softAssert.assertTrue(true,"Refresh butonuna klik ugursuzdur,hec bir yenilenme bas vermir");

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Refresh butonu gorunmur");
            softAssert.fail("Refresh butonu gorunmur");
        }
    }

    @And("Click on the completed button")
    public void click_on_the_completed_button(){
        if (basePage.isElementVisible(videoStatusPage.getCompletedButton())){
            videoStatusPage.clickCompletedButton();
            if (basePage.isClickSuccessful(videoStatusPage.getCompletedButton(), By.xpath("//div[contains(@class,'rounded-full') and .//span[normalize-space(.)='Tamamlandı']]"))){
                ExtentManager.getTest().log(Status.PASS,"Completed butonuna klik edildi ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Completed butonuna klik edilmedi ve hec bir menu acilmadi");
                softAssert.fail("Completed butonuna klik edilmedi ve hec bir menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Completed butonu gorunmedi");
            softAssert.fail("Completed butonu gorunmedi");
        }
    }

    @And("Click on the video download button")
    public void click_on_the_download_button(){
        if (basePage.isElementVisible(videoStatusPage.getDownloadButton())){
            videoStatusPage.clickDownloadButton();
            ExtentManager.getTest().log(Status.FAIL,"Download butonuna klik ugursuzdur,hec bir yuklenme bas vermir");
            softAssert.assertTrue(true,"Download butonuna klik ugursuzdur,hec bir yuklenme bas vermir");

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Download butonu gorunmur");
            softAssert.fail("Download butonu gorunmur");
        }
    }

    @And("Click on the Failed button")
    public void click_on_the_failed_button(){
        if (basePage.isElementVisible(videoStatusPage.getFailedButton())){
            videoStatusPage.clickFailedButton();
            if (basePage.isClickSuccessful(videoStatusPage.getFailedButton(), By.xpath("//div[contains(@class,'rounded-lg') and .//p[normalize-space(.)='Video yoxdur']]"))){
                ExtentManager.getTest().log(Status.PASS,"Failed butonuna klik edildi ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Failed butonuna klik edilmedi ve hec bir menu acilmadi");
                softAssert.fail("Failed butonuna klik edilmedi ve hec bir menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Failed butonu gorunmedi");
            softAssert.fail("Failed butonu gorunmedi");
        }
    }


    @And("Click on the All button")
    public void click_on_the_All_button(){
        if (basePage.isElementVisible(videoStatusPage.getAllButton())){
            videoStatusPage.clickAllButton();
            if (basePage.isClickSuccessful(videoStatusPage.getAllButton(), By.xpath("//div[contains(@class,'rounded-full') and .//span[normalize-space(.)='Tamamlandı']]"))){
                ExtentManager.getTest().log(Status.PASS,"All butonuna klik edildi ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"All butonuna klik edilmedi ve hec bir menu acilmadi");
                softAssert.fail("All butonuna klik edilmedi ve hec bir menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"All butonu gorunmedi");
            softAssert.fail("All butonu gorunmedi");
        }
    }

























}
