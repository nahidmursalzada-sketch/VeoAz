package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import config.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BlogTechnologyPage;

public class BlogTechnologyStep {

    private final BlogTechnologyPage blogTechnologyPage;

    WebDriver driver;
    public BlogTechnologyStep(){
        blogTechnologyPage=new BlogTechnologyPage();
    }


    @Given("Returns to the site's home page")
    public void returns_to_the_site_is_home_page(){
        blogTechnologyPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Returns to the site's home page");
    }

    @When("Click the blog button")
    public void click_the_blog_button(){
        blogTechnologyPage.clickBlogButton();
        ExtentManager.getTest().log(Status.INFO,"Click the blog button");
    }

    @Then("Click the technology button")
    public void click_the_technology_button(){
        blogTechnologyPage.clickTechnologyButton();
        ExtentManager.getTest().log(Status.INFO,"Click the technology button");
    }

    @And("Click the read more button")
    public void click_the_read_more_button(){
        blogTechnologyPage.clickReadMoreButton();
        ExtentManager.getTest().log(Status.INFO,"Click the read more button");
    }

    @And("Click the share button.")
    public void click_the_share_button(){
        blogTechnologyPage.clickShareButton();
        ExtentManager.getTest().log(Status.INFO,"Click the share button.");
    }

    @And("Click the back to blog button")
    public void click_the_back_to_blog_button(){
        blogTechnologyPage.clickBackBlogButton();
        ExtentManager.getTest().log(Status.INFO,"Click the back to blog button");
    }
























}
