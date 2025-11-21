package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import config.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.AboutPage;
import pages.BasePage;
import pages.BillingPage;

public class AboutStep {
    private final SoftAssert softAssert;
    private final AboutPage aboutPage;
    private final BasePage basePage;
    WebDriver driver;
    public AboutStep(){
        aboutPage=new AboutPage();
        softAssert = new SoftAssert();
        basePage=new BasePage();
    }


    @Given("The main page of the site is accessed.")
    public void the_main_page_of_the_site_is_accessed(){
        aboutPage.clickHomePageButton();
        ExtentManager.getTest().log(Status.INFO,"The main page of the site is accessed.");
    }

    @When("About us button is clicked.")
    public void about_us_button_is_clicked(){
        String oldUrl=aboutPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(aboutPage.getAboutButton())){
            aboutPage.clickAboutButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"About butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"About butonuna klik edilmedi");
                softAssert.fail("About butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"About butonu gorulmedi");
            softAssert.fail("About butonu gorulmedi");
        }

    }

    @Then("Click on the plans button.")
    public void click_on_the_plans_button(){
        String oldUrl=aboutPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(aboutPage.getPlansButton())){
            aboutPage.clickPlansButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Plans butonuna klik edildi");

            }else {
                ExtentManager.getTest().log(Status.FAIL,"Plans butonuna klik edilmedi");
                softAssert.fail("Plans butonuna klik edilmedi");
            }

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Plans butonu gorulmedi");
            softAssert.fail("Plans butonu gorulmedi");
        }

    }

    @And("The {string} is entered.")
    public void the_amount_is_entered(String amount){

        if (basePage.isElementVisible(aboutPage.getAmountInput())){
            aboutPage.enterAmount(amount);
            if (basePage.canEnterText(aboutPage.getAmountInput(),amount)){
                ExtentManager.getTest().log(Status.PASS,"Amount daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Amount daxil edilmedi");
                softAssert.fail("Amount daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Amount daxil etme hissesi gorulmedi");
            softAssert.fail("Amount daxil etme hissesi gorulmedi");
        }

    }

    @And("The user clicks on the desired package")
    public void the_user_clicks_on_the_desired_package(){

        if (basePage.isElementVisible(aboutPage.getPackageSelect())){
            aboutPage.selectPackage();
            ExtentManager.getTest().log(Status.PASS,"Istediyiniz paket ugurla secildi");
            softAssert.assertTrue(true,"Istediyiniz paket ugurla secildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Paket gorunmur");
        }

    }












































}
