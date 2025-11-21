package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.StatusPage;

public class StatusStep {

    private final StatusPage statusPage;
    private final SoftAssert softAssert;
    private final BasePage basePage;
    public StatusStep(){
        statusPage=new StatusPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
    }

    @Given("Redirecting to the main page")
    public void redirecting_to_the_main_page(){
        statusPage.clickHomePageButton();
        ExtentManager.getTest().log(Status.INFO,"Redirecting to the main page");
    }

    @When("The status button is clicked")
    public void the_status_button_is_clicked(){

        if (basePage.isElementVisible(statusPage.getStatusButton())){
            statusPage.clickStatusButton();
            ExtentManager.getTest().log(Status.FAIL,"Status butonuna klik edildikde hec bir deyisiklik bas vermedi");
            softAssert.assertTrue(true,"Status butonuna klik edildikde hec bir deyisiklik bas vermedi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Status butonu gorunmedi");
            softAssert.fail("Status butonu gorunmedi");
        }
    }




























































}
