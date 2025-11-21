package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.PremiumUserPage;

public class PremiumUserStep {
    private final SoftAssert softAssert;
    private final BasePage basePage;
    private final PremiumUserPage premiumUserPage;
    WebDriver driver;
    public PremiumUserStep(){
        premiumUserPage=new PremiumUserPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
    }

    @Given("Redirecting to the main page of the site.")
    public void redirecting_to_the_main_page_of_the_site(){
        premiumUserPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Redirecting to the main page of the site.");
    }

    @When("Click on the new video button")
    public void click_on_the_new_video_button(){

        if (basePage.isElementVisible(premiumUserPage.getNewVideoButton())){
            premiumUserPage.clickNewVideoButton();
            ExtentManager.getTest().log(Status.FAIL,"New video butonuna klik edilmedi");
            softAssert.assertTrue(true,"New video butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"New video butonu gorunmedi");
            softAssert.fail("New video butonu gorunmedi");
        }

    }

    @Then("Click on the create button")
    public void click_on_the_create_button(){

        if (basePage.isElementVisible(premiumUserPage.getCreateButton())){
            premiumUserPage.clickCreateButton();
            ExtentManager.getTest().log(Status.FAIL,"Create butonuna klik edilmedi");
            softAssert.assertTrue(true,"Create butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Create butonu gorunmedi");
            softAssert.fail("Create butonu gorunmedi");
        }

    }

    @And("Click on the library button")
    public void click_on_the_library_button(){

        if (basePage.isElementVisible(premiumUserPage.getLibraryButton())){
            premiumUserPage.clickLibraryButton();
            ExtentManager.getTest().log(Status.FAIL,"Library butonuna klik edilmedi");
            softAssert.assertTrue(true,"Library butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Library butonu gorunmedi");
            softAssert.fail("Library butonu gorunmedi");
        }


    }

    @And("Click on the settings button")
    public void _click_on_the_settings_button(){

        if (basePage.isElementVisible(premiumUserPage.getSettingsButton())){
            premiumUserPage.clickSettingsButton();
            ExtentManager.getTest().log(Status.FAIL,"Settings butonuna klik edilmedi");
            softAssert.assertTrue(true,"Settings butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Settings butonu gorunmedi");
            softAssert.fail("Settings butonu gorunmedi");
        }

    }

    @And("Click on the city view video button")
    public void click_on_the_city_view_video_button(){

        if (basePage.isElementVisible(premiumUserPage.getCityViewVideo())){
            premiumUserPage.clickCityViewVideoButton();
            ExtentManager.getTest().log(Status.FAIL,"City view video butonuna klik edilmedi");
            softAssert.assertTrue(true,"City view video butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"City view video butonu gorunmedi");
            softAssert.fail("City view video butonu gorunmedi");
        }
    }

    @And("Click on the city view video instal button")
    public void click_on_the_city_view_video_instal_button(){

        if (basePage.isElementVisible(premiumUserPage.getCityViewVideoInstalButton())){
            premiumUserPage.clickCityViewVideoInstalButton();
            ExtentManager.getTest().log(Status.FAIL,"City view video instal butonuna klik edilmedi");
            softAssert.assertTrue(true,"City view video instal butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"City view video instal butonu gorunmedi");
            softAssert.fail("City view video instal butonu gorunmedi");
        }

    }

    @And("Click on the city view video ellipsis button")
    public void click_on_the_city_view_video_ellipsis_button(){

        if (basePage.isElementVisible(premiumUserPage.getCityViewVideoEllipsisButton())){
            premiumUserPage.clickCityViewVideoEllipsisButton();
            ExtentManager.getTest().log(Status.FAIL,"City view video ellipsis butonuna klik edilmedi");
            softAssert.assertTrue(true,"City view video ellipsis butonuna klik edilmedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"City view video ellipsis butonu gorunmedi");
            softAssert.fail("City view video ellipsis butonu gorunmedi");
        }

    }

    @And("Click on the nature scene video button")
    public void click_on_the_nature_scene_video_button(){
        premiumUserPage.clickNatureSceneVideo();
        ExtentManager.getTest().log(Status.INFO,"Click on the nature scene video button");
    }

    @And("Click on the creativ space video button")
    public void click_on_the_creativ_space_video_button(){
        premiumUserPage.clickCreativSpaceVideo();
        ExtentManager.getTest().log(Status.INFO,"Click on the creativ space video button");
    }

    @And("Click on the creativ space video instal button")
    public void click_on_the_creativ_space_video_instal_button(){
        premiumUserPage.clickCreativSpaceVideoInstalButton();
        ExtentManager.getTest().log(Status.INFO,"Click on the creativ space video instal button");
    }


    @And("Click on the creativ space video ellipsis button")
    public void click_on_the_creativ_space_video_ellipsis_button(){
        premiumUserPage.clickCreativSpaceVideoEllipsisButton();
        ExtentManager.getTest().log(Status.INFO,"Click on the creativ space video ellipsis button");
    }



































































}
