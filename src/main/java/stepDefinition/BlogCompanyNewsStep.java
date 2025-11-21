package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import pages.BlogCompanyNewsPage;

public class BlogCompanyNewsStep {

    private final BlogCompanyNewsPage blogCompanyNewsPage;
    WebDriver driver;
    public BlogCompanyNewsStep(){
        blogCompanyNewsPage=new BlogCompanyNewsPage();
    }

    @Given("Accessing the main part of the site")
    public void accessing_the_main_part_of_the_site(){
        blogCompanyNewsPage.clickHomeButton();
        ExtentManager.getTest().log(Status.INFO,"Accessing the main part of the site");
    }

    @When("The blog button is activated")
    public void the_blog_button_is_activated(){
        blogCompanyNewsPage.clickBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The blog button is activated");
    }

    @Then("Click the company news button")
    public void click_the_company_news_button(){
        blogCompanyNewsPage.clickCompanyNewsButton();
        ExtentManager.getTest().log(Status.INFO,"Click the company news button");
    }

    @And("The user click on the read more button")
    public void the_user_on_the_read_more_button(){
        blogCompanyNewsPage.clickReadMoreButton();
        ExtentManager.getTest().log(Status.INFO,"The user click on the read more button");
    }

    @And("The user click on the share button")
    public void the_user_click_on_the_share_button(){
        blogCompanyNewsPage.clickShareButton();
        ExtentManager.getTest().log(Status.INFO,"The user click on the share button");
    }

    @And("The user click on the back to blog button")
    public void the_user_click_on_the_back_to_blog_button(){
        blogCompanyNewsPage.clickBackBlogButton();
        ExtentManager.getTest().log(Status.INFO,"The user click on the back to blog button");
    }

































}
