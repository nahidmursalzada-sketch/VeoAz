package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BlogPricingPage;

public class BlogPricingStep {

    private final BlogPricingPage blogPricingPage;
    WebDriver driver;
    public BlogPricingStep(){
        blogPricingPage=new BlogPricingPage();
    }

    @Given("The user is redirected to the homepage.")
    public void the_user_is_redirected_to_the_homepage(){
        blogPricingPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The user is redirected to the homepage.");
    }

    @When("The blog button view is active.")
    public void the_blog_button_view_is_active(){
        blogPricingPage.clickBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The blog button view is active.");
    }

    @Then("Click the pricing button")
    public void click_the_pricing_button(){
        blogPricingPage.clickPricingButton();
        ExtentManager.getTest().log(Status.INFO,"Click the pricing button");
    }

    @And("The user selects the Read More option.")
    public void the_user_selects_the_read_more_option(){
        blogPricingPage.clickReadMoreButton();
        ExtentManager.getTest().log(Status.INFO,"The user selects the Read More option.");
    }

    @And("The user initiates the Share action.")
    public void the_user_initiates_the_share_action(){
        blogPricingPage.clickShareButton();
        ExtentManager.getTest().log(Status.INFO,"The user initiates the Share action.");
    }

    @And("The user navigates back using the Back to Blog button.")
    public void the_user_navigates_back_using_the_back_to_blog_button(){
        blogPricingPage.clickBackBlogButton();
        ExtentManager.getTest().log(Status.INFO,"");
    }

























































}
