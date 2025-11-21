package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.SosialIconsPage;

public class SosialIconsStep {

    private final SosialIconsPage sosialIconsPage;
    private final SoftAssert softAssert;
    private final BasePage basePage;
    public SosialIconsStep(){
        sosialIconsPage=new SosialIconsPage();
        basePage=new BasePage();
        softAssert=new SoftAssert();
    }

    @Given("The main page is accessed")
    public void the_main_page_is_accessed() {

        sosialIconsPage.clickHomePageButton();
    }

    @When("Click on the twitter button")
    public void click_on_the_twitter_button(){

        if (basePage.isElementVisible(sosialIconsPage.getTwitterButton())){
            sosialIconsPage.clickTwitterButton();
            ExtentManager.getTest().log(Status.FAIL,"Twitter butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
            softAssert.assertTrue(true,"Twitter butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Facebook butonu gorulmedi");
            softAssert.fail("Facebook butonu gorulmedi");
        }
    }

    @Then("Click on the facebook button")
    public void click_on_the_facebook_button(){

        if (basePage.isElementVisible(sosialIconsPage.getFacebookButton())){
            sosialIconsPage.clickFacebookButton();
            ExtentManager.getTest().log(Status.FAIL,"Facebook butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
            softAssert.assertTrue(true,"Facebook butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Facebook butonu gorulmedi");
            softAssert.fail("Facebook butonu gorulmedi");
        }
    }

    @And("Click on the instagram button")
    public void click_on_the_instagram_button(){

        if (basePage.isElementVisible(sosialIconsPage.getInstagramButton())){
            sosialIconsPage.clickInstagramButton();
            ExtentManager.getTest().log(Status.FAIL,"Instagram butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
            softAssert.assertTrue(true,"Instagram butonuna klik edildikden sonra hec bir deyisiklik bas vermedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Instagram butonu gorulmedi");
            softAssert.fail("Instagram butonu gorulmedi");
        }
    }








































































}
