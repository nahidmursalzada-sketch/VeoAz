package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HelpPage;

public class HelpStep {
    private final SoftAssert softAssert;
    private final BasePage basePage;
    private final HelpPage helpPage;
    WebDriver driver;
    public HelpStep(){
        helpPage=new HelpPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
    }

    @Given("The main page is entered")
    public void the_main_page_is_entered(){
        helpPage.clickHomePageButton();
        ExtentManager.getTest().log(Status.INFO,"The main page is entered");
    }

    @When("The help button is clicked")
    public void the_help_button_is_clicked(){

        String oldUrl=helpPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(helpPage.getHelpButton())){
            helpPage.clickHelpButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Help butonuna klik edildi ve yeni URl acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Help butonuna klik edilmedi ve yeni URL acilmadi");
                softAssert.fail("Help butonuna klik edilmedi ve yeni URL acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Help butonu gorunmedi");
            softAssert.fail("Help butonu gorunmedi");
        }
    }

    @Then("The how do i create my first video button is clicked")
    public void the_how_do_i_create_my_first_video_button_is_clicked(){

        if (basePage.isElementVisible(helpPage.getFirstVideoHowButton())){
            helpPage.clickFirstVideoHowButton();
            if (basePage.isClickSuccessful(helpPage.getFirstVideoHowButton(), By.xpath("//div[text()='Sign in to your account, go to \"Create Video\" page, enter your description and choose settings. Generation takes 1 minute.']"))){
                ExtentManager.getTest().log(Status.PASS,"First video how butonu kliklendi,ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"First video how butonu kliklenmedi,ve yeni menu acilmadi");
                softAssert.fail("First video how butonu kliklenmedi,ve yeni menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"First video how butonu gorunmedi");
            softAssert.fail("First video how butonu gorunmedi");
        }

    }

    @And("The how many videos can i create button is clicked")
    public void the_how_many_videos_can_i_button_is_clicked(){

        if (basePage.isElementVisible(helpPage.getHowManyVideosButton())){
            helpPage.clickHowManyVideosButton();
            if (basePage.isClickSuccessful(helpPage.getHowManyVideosButton(), By.xpath("//div[text()='You can create unlimited videos. The system is credit-based - simply top up your balance and create as many videos as you need.']"))){
                ExtentManager.getTest().log(Status.PASS,"How many videos butonu kliklendi,ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"How many videos butonu kliklenmedi,ve yeni menu acilmadi");
                softAssert.fail("How many videos butonu kliklenmedi,ve yeni menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"How many videos butonu gorunmedi");
            softAssert.fail("How many videos butonu gorunmedi");
        }

    }

    @And("The can i use videos commercially button is clicked")
    public void the_can_i_use_videos_comerically_button_is_clicked(){

        if (basePage.isElementVisible(helpPage.getCommerciallyButton())){
            helpPage.clickCommerciallyButton();
            if (basePage.isClickSuccessful(helpPage.getCommerciallyButton(), By.xpath("//div[text()='Yes, all created videos can be used for personal and commercial purposes without restrictions.']"))){
                ExtentManager.getTest().log(Status.PASS,"Comerically butonu kliklendi,ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Comerically butonu kliklenmedi,ve yeni menu acilmadi");
                softAssert.fail("Comerically butonu kliklenmedi,ve yeni menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Comerically butonu gorunmedi");
            softAssert.fail("Comerically butonu gorunmedi");
        }

    }

    @And("The what if my video won't generate button is clicked")
    public void the_what_if_my_video_wont_generate_button_is_clicked(){

        if (basePage.isElementVisible(helpPage.getGenerateButton())){
            helpPage.clickGenerateButton();
            if (basePage.isClickSuccessful(helpPage.getGenerateButton(), By.xpath("//div[text()='Check your internet connection, try simplifying the description, or contact support if the issue persists.']"))){
                ExtentManager.getTest().log(Status.PASS,"Generate butonu kliklendi,ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Generate butonu kliklenmedi,ve yeni menu acilmadi");
                softAssert.fail("Generate butonu kliklenmedi,ve yeni menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Generate butonu gorunmedi");
            softAssert.fail("Generate butonu gorunmedi");
        }

    }

    @And("Database {string} is being conducted")
    public void database_search_is_being_conducted(String search){

        if (basePage.isElementVisible(helpPage.getFirstVideoHowButton())){
            helpPage.enterSearch(search);
            if (basePage.canEnterText(helpPage.getSearchInput(),search)){
                ExtentManager.getTest().log(Status.PASS,"Search inputa text daxil edildi");

            }else {
                ExtentManager.getTest().log(Status.FAIL,"Search inputa text daxil edilmedi");
                softAssert.fail("Search inputa text daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL," Search input gorunmedi");
            softAssert.fail("Search input gorunmedi");
        }

    }

    @And("The search button is clicked")
    public void the_search_button_is_clicked(){

        if (basePage.isElementVisible(helpPage.getSearchButton())){
            helpPage.clickSearchButton();
            if (basePage.isClickSuccessful(helpPage.getSearchButton(),By.xpath(""))){
                ExtentManager.getTest().log(Status.PASS,"Search butonu kliklendi ve axtaris ugurla neticelendi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Search butonu kliklenmedi ve axtaris ugursuz oldu");
                softAssert.fail("Search butonu kliklenmedi ve axtaris ugursuz oldu");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Search butonu gorulmedi");
            softAssert.fail("Search butonu gorulmedi");
        }

    }

    @And("The user click on the contact button")
    public void the_user_click_contact_button(){

        if (basePage.isElementVisible(helpPage.getContactButton())){
            helpPage.clickContactButton();
            if (basePage.isClickSuccessful(helpPage.getContactButton(), By.xpath("//a[@data-testid='button-whatsapp']"))){
                ExtentManager.getTest().log(Status.PASS,"Contact butonu kliklendi,ve yeni menu acildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Contact butonu kliklenmedi ve yeni menu acilmadi");
                softAssert.fail("Contact butonu kliklenmedi ve yeni menu acilmadi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Contact butonu gorunmedi");
            softAssert.fail("Contact butonu gorunmedi");
        }

    }

















































































}
