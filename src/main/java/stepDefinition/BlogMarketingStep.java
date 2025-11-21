package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import pages.BlogMarketingPage;

public class BlogMarketingStep {

    private final BlogMarketingPage blogMarketingPage;
    WebDriver driver;
    public BlogMarketingStep (){
        blogMarketingPage=new BlogMarketingPage();
    }

    @Given("Redirecting to the main page of the site")
    public void redirecting_to_the_main_page_of_the_site(){
        blogMarketingPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Redirecting to the main page of the site");
    }

    @When("The blog view is active.")
    public void the_blog_view_is_active(){
        blogMarketingPage.clickBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The blog view is active.");
    }

    @Then("Click the marketing button")
    public void click_the_marketing_button(){
        blogMarketingPage.clickMarketingButton();
        ExtentManager.getTest().log(Status.INFO,"Click the marketing button");
    }

    @And("User clicks the Read More button.")
    public void user_clicks_the_read_more_button(){
        blogMarketingPage.clickReadMoreButton();
        ExtentManager.getTest().log(Status.INFO,"User clicks the Read More button.");
    }

    @And("User clicks the Share button.")
    public void user_clicks_the_share_button(){
        blogMarketingPage.clickShareButton();
        ExtentManager.getTest().log(Status.INFO,"User clicks the Share button.");
    }

    @And("User clicks the Back to Blog button.")
    public void user_clicks_the_back_to_blog_button(){
        blogMarketingPage.clickBackBlogButton();
        ExtentManager.getTest().log(Status.INFO,"User clicks the Back to Blog button.");
    }





































}
