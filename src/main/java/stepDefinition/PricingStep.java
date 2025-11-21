package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PricingPage;

public class PricingStep {

    private final PricingPage pricingPage;
    WebDriver driver;
    public PricingStep(){
        pricingPage=new PricingPage();
    }

    @Given("The user enters the site’s main landing page.")
    public void the_user_enters_the_site_is_main_landing_page(){
        pricingPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The user enters the site’s main landing page.");
    }

    @When("The user taps the pricing button.")
    public void the_user_taps_the_pricing_button(){
        pricingPage.clickPricingButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the pricing button.");
    }

    @Then("The user enters the {string}.")
    public void the_user_enters_the_amount(String amount){
        pricingPage.enterAmount(amount);
        ExtentManager.getTest().log(Status.INFO,String.format("The user enters the %s.",amount));
    }

    @And("The user taps the add credits button")
    public void the_user_taps_the_add_credits_button(){
        pricingPage.clickAddCreditButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the add credits button");
    }

    @And("The user selects a package")
    public void the_user_selects_a_package(){
        pricingPage.enterPackage();
        ExtentManager.getTest().log(Status.INFO,"The user selects a package");
    }



















































}
