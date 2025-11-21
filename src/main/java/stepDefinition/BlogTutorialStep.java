package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BlogTutorialPage;

public class BlogTutorialStep {

    private final BlogTutorialPage blogTutorialPage;

    WebDriver driver;
    public BlogTutorialStep(){
        blogTutorialPage=new BlogTutorialPage();
    }

    @Given("The user opens the site is homepage.")
    public void the_user_opens_the_site_is_homepage(){
        blogTutorialPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"The user opens the site is homepage.");
    }

    @When("The user taps the blog button.")
    public void the_user_taps_the_blog_button(){
    blogTutorialPage.clickBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the blog button.");
    }

    @Then("The user taps the tutorial button")
    public void the_user_taps_the_tutorial_button(){
        blogTutorialPage.clickTutorialButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the tutorial button");
    }

    @And("The user taps the Read More button.")
    public void the_user_taps_the_read_more_button(){
        blogTutorialPage.clickReadMoreButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the Read More button.");
    }

    @And("The user taps the Share button")
    public void the_user_taps_the_share_button(){
        blogTutorialPage.clickShareButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the Share button");
    }

    @And("The user taps the back to blog button")
    public void the_user_the_back_to_blog_button(){
        blogTutorialPage.clickBackBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The user taps the back to blog button");
    }








































}
