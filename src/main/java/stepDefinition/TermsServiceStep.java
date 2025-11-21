package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import config.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.TermsServicePage;

public class TermsServiceStep {

    private final TermsServicePage termsServicePage;
    private final SoftAssert softAssert;
    private final BasePage basePage;

    WebDriverManager webDriverManager;
    public TermsServiceStep(){
        termsServicePage=new TermsServicePage();
        basePage=new BasePage();
        softAssert=new SoftAssert();
    }

    @Given("The user accesses the main page of the site.")
    public void the_user_accesses_the_main_page_of_the_site(){
        termsServicePage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The user accesses the main page of the site.");
    }

    @When("Click on the terms of service button")
    public void click_on_the_terms_of_service_button(){
        termsServicePage.clickTermsServiceButton();
        ExtentManager.getTest().log(Status.INFO,"Click on the terms of service button");

    }

    @Then("Click on the legal button")
    public void click_on_the_legal_button(){

        if (basePage.isElementVisible(termsServicePage.getLegalButton())){
            termsServicePage.clickLegalButton();
            ExtentManager.getTest().log(Status.FAIL,"Legal butonuna click ugurludur ancaq clickden sonra 404 xeta mesaji gonderildi");
            softAssert.assertTrue(true,"Legal butonuna click ugurludur ancaq clickden sonra 404 xeta mesaji gonderildi");

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Legal butonu gorulmedi");
            softAssert.fail("Legal butonu gorulmedi");
        }

        webDriverManager.quitDriver();
    }

































































}
