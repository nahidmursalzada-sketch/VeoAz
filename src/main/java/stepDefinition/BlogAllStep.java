package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.BlogAllPage;

public class BlogAllStep {


    private final BasePage basePage;
    private final SoftAssert softAssert;
    private final BlogAllPage blogAllPage;
    WebDriver driver;
    public BlogAllStep(){
        blogAllPage=new BlogAllPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
    }

    @Given("The user is redirected to the homepage of the site.")
    public void the_user_is_redirected_to_the_homepage_of_the_site(){
        blogAllPage.clickHomeButton();

        ExtentManager.getTest().log(Status.INFO,"The user is redirected to the homepage of the site.");
    }

    @When("The blog button is clicked.")
    public void the_blog_button_is_clicked(){
        String oldUrl=blogAllPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(blogAllPage.getBlogButton())){
            blogAllPage.clickBlogButton();
            if(basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Blog butonuna klik edilidi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Blog butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Blog butonu gorunmedi");
            softAssert.fail("Blog butonu gorunmedi");
        }

    }

    @Then("The read more button is clicked")
    public void the_read_more_button_is_clicked(){
        String oldUrl=blogAllPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(blogAllPage.getReadMoreButton())){
            blogAllPage.clickReadMoreButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Read More butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Read More butonuna klik edilmedi");
                softAssert.fail("Read More butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Read More Butonu gorunmedi");
            softAssert.fail("Read More Butonu gorunmedi");
        }

    }

    @And("The share button is clicked")
    public void the_share_button_is_clicked(){
        String oldUrl=blogAllPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(blogAllPage.getShareButton())){
            blogAllPage.clickShareButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Share butonuna klik edildi ve her hansi bir menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Share butonuna klik edilmedi ve hec bir menu acilmadi");
                softAssert.fail("Share butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Share butonu gorunmedi");
            softAssert.fail("Share butonu gorunmedi");
        }


    }

    @And("The back to blog button is clicked")
    public void the_back_to_blog_button_isclicked(){
        String oldUrl=blogAllPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(blogAllPage.getBackBlogButton())){
            blogAllPage.clickBackBlogButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Back blog butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Back blog butonuna klik edilmedi");
                softAssert.fail("Back blog butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Back blog butonu gorunmedi");
            softAssert.fail("Back blog butonu gorunmedi");
        }
    }

    @And("The read more two button clicked")
    public void the_read_more_two_button_clicked(){
        blogAllPage.clickReadMoreTwoButton();
        blogAllPage.clickShareButton();
        blogAllPage.clickBackBlogButton();

        ExtentManager.getTest().log(Status.INFO,"The read more two button clicked");
    }

    @And("The read more three button clicked")
    public void the_read_more_three_button_clicked(){
        blogAllPage.clickReadMoreThreeButton();
        blogAllPage.clickShareButton();
        blogAllPage.clickBackBlogButton();

        ExtentManager.getTest().log(Status.INFO,"The read more three button clicked");
    }

    @And("The read more four button is clicked")
    public void the_read_more_four_button_is_clicked(){
        blogAllPage.clickReadMoreFourButton();
        blogAllPage.clickShareButton();
        blogAllPage.clickBackBlogButton();

        ExtentManager.getTest().log(Status.INFO,"The read more four button is clicked");
    }

    @And("The read more five button is clicked")
    public void the_read_more_five_button_is_clicked(){
        blogAllPage.clickReadMoreFiveButton();
        blogAllPage.clickShareButton();
        blogAllPage.clickBackBlogButton();

        ExtentManager.getTest().log(Status.INFO,"The read more five button is clicked");
    }

    @And("Looking for {string}")
    public void looking_for_article(String article){

        if (basePage.isElementVisible(blogAllPage.getArticleInput())){
            blogAllPage.enterArticle(article);
            if (basePage.canEnterText(blogAllPage.getArticleInput(),article)){
                ExtentManager.getTest().log(Status.PASS,"Article daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Article daxil edilmedi");
                softAssert.fail("Article daxil edilmedi");
            }

            if (basePage.isSearchSuccessful(By.xpath("//div[contains(@class, 'rounded-lg') and contains(@class, 'border') and contains(@class, 'bg-card')]"),article)){

                ExtentManager.getTest().log(Status.PASS,"Axtaris ugurludur");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Axtaris ugursuzdur");
                softAssert.fail("Axtaris ugursuzdur");
            }

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Article input gorunmedi");
            softAssert.fail("Article input gorunmedi");
        }
    }




























































}
