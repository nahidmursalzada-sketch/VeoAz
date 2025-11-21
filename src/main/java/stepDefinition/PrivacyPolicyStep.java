package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PrivacyPolicyPage;

public class PrivacyPolicyStep {

    private final PrivacyPolicyPage privacyPolicyPage;
    WebDriver driver;
    public PrivacyPolicyStep(){
        privacyPolicyPage=new PrivacyPolicyPage();
    }

    @Given("The main part is being discussed.")
    public void the_main_part_is_being_discussed(){
        privacyPolicyPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The main part is being discussed.");
    }

    @When("Click on the privacy policy button")
    public void click_on_the_privacy_policy_button(){
        privacyPolicyPage.clickPrivacyPolicyButton();
        ExtentManager.getTest().log(Status.INFO,"Click on the privacy policy button");
    }


































































































}
