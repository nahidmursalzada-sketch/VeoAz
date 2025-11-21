package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LegalPage;

public class LegalStep {

    private final BasePage basePage;
    private final LegalPage legalPage;
    private final SoftAssert softAssert;
    WebDriver driver;
    public LegalStep(){
        basePage=new BasePage();
        legalPage=new LegalPage();
        softAssert=new SoftAssert();
    }

    @Given("Access is granted to the main entry page of the site.")
    public void click_on_the_home_button(){
        legalPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Access is granted to the main entry page of the site.");
    }

    @When("Click on the privacy button")
    public void click_on_the_privacy_button(){
        String oldUrl=legalPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(legalPage.getPrivacyButton())){
            legalPage.clickPrivacyButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Privacy butonuna klik edildi ve URL deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Privacy butonuna klik edilmedi ve URL deyismedi");
                softAssert.fail("Privacy butonuna klik edilmedi ve URL deyismedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Privacy butonu gorunmedi");
            softAssert.fail("Privacy butonu gorunmedi");
        }
    }

    @Then("Going back")
    public void going_back(){
        legalPage.clickBackButton();
        ExtentManager.getTest().log(Status.INFO,"Going back");
    }

    @And("Click on the terms button")
    public void click_on_the_terms_button(){
        String oldUrl=legalPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(legalPage.getTermsButton())){
            legalPage.clickTermsButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Terms butonuna klik edildi ve URL deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Terms butonuna klik edilmedi ve URL deyismedi");
                softAssert.fail("Terms butonuna klik edilmedi ve URL deyismedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Terms butonu gorunmedi");
            softAssert.fail("Terms butonu gorunmedi");
        }
    }

    @And("The user returns back")
    public void the_user_returns_back(){
        legalPage.clickBackTwoButton();
        ExtentManager.getTest().log(Status.INFO,"The user returns back");
    }

    @And("Click on the refunds button")
    public void click_on_the_refunds_button(){

        String oldUrl=legalPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(legalPage.getRefundsButton())){
            legalPage.clickRefundsButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Refunds butonuna klik edildi ve URL deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Refunds butonuna klik edilmedi ve URL deyismedi");
                softAssert.fail("Refunds butonuna klik edilmedi ve URL deyismedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Refunds butonu gorunmedi");
            softAssert.fail("Refunds butonu gorunmedi");
        }
    }

    @And("Going back.")
    public void going_back_three(){
        legalPage.clickBackThreeButton();
        ExtentManager.getTest().log(Status.INFO,"Going back.");
    }

    @And("Click on the accessibility button")
    public void click_on_the_accessibility_button(){

        String oldUrl=legalPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(legalPage.getAccessibilityButton())){
            legalPage.clickAccessibilityButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Accessibility butonuna klik edildi ve URL deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Accessibility butonuna klik edilmedi ve URL deyismedi");
                softAssert.fail("Accessibility butonuna klik edilmedi ve URL deyismedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Accessibility butonu gorunmedi");
            softAssert.fail("Accessibility butonu gorunmedi");
        }
    }

























































}
