package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.ContactPage;

public class ContactStep {

    private final ContactPage contactPage;
    private final SoftAssert softAssert;
    private final BasePage basePage;
    WebDriver driver;
    public ContactStep(){
        basePage=new BasePage();
        softAssert=new SoftAssert();
        contactPage=new ContactPage();
    }

    @Given("The user goes to the website’s homepage.")
    public void the_user_goes_to_the_website_is_homepage(){
        contactPage.clickHomePageButton();
        ExtentManager.getTest().log(Status.INFO,"The user goes to the website’s homepage.");
    }

    @When("The contact button is clicked")
    public void the_contact_button_is_clicked(){
        String oldUrl=contactPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(contactPage.getContactButton())){
            contactPage.clickContactButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"Contact butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Contact butonuna klik edilmedi");
                softAssert.fail("Contact butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Contact butonu gorunmedi");
            softAssert.fail("Contact butonu gorunmedi");
        }


    }

    @Then("The user enters their {string}")
    public void the_user_enters_their_name(String name){

        if (basePage.isElementVisible(contactPage.getNameInput())){
            contactPage.enterName(name);
            if (basePage.canEnterText(contactPage.getNameInput(),name)){
                ExtentManager.getTest().log(Status.PASS,"Name daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Name daxil edilmedi");
                softAssert.fail("Name daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Name input gorunmedi");
            softAssert.fail("Name input gorunmedi");
        }
    }

    @And("The user enters {string} address")
    public void the_user_enters_email_address(String email){

        if (basePage.isElementVisible(contactPage.getEmailInput())){
            contactPage.enterEmail(email);
            if (basePage.canEnterText(contactPage.getEmailInput(),email)){
                ExtentManager.getTest().log(Status.PASS,"Email daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Email daxil edilmedi");
                softAssert.fail("Email daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Email input gorunmedi");
            softAssert.fail("Email input gorunmedi");
        }

    }

    @And("The user adds a {string}.")
    public void the_user_adds_a_subject(String subject){
        if (basePage.isElementVisible(contactPage.getSubjectInput())){
            contactPage.enterSubject(subject);
            if (basePage.canEnterText(contactPage.getSubjectInput(),subject)){
                ExtentManager.getTest().log(Status.PASS,"Subject daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Subject daxil edilmedi");
                softAssert.fail("Subject daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Subject input gorunmedi");
            softAssert.fail("Subject input gorunmedi");
        }

    }

    @And("The user enters a {string}.")
    public void the_user_adds_a_message(String message){

        if (basePage.isElementVisible(contactPage.getMessageInput())){
            contactPage.enterMessage(message);
            if (basePage.canEnterText(contactPage.getMessageInput(),message)){
                ExtentManager.getTest().log(Status.PASS,"Message daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Message daxil edilmedi");
                softAssert.fail("Message daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Message input gorunmedi");
            softAssert.fail("Message input gorunmedi");
        }
    }

    @And("The category button is clicked")
    public void the_category_button_is_clicked(){
//        contactPage.switchToCategoryIframe();
//        contactPage.clickCategoryButton();
        ExtentManager.getTest().log(Status.INFO,"The category button is clicked");
    }

    @And("The user select category")
    public void the_user_select_category(){
//        contactPage.enterCategory();
//        driver.switchTo().defaultContent();
    }

    @And("The send message button is clicked")
    public void the_send_message_button(){
//        contactPage.clickSendMessageButton();
        ExtentManager.getTest().log(Status.INFO,"The send message button is clicked");
    }

    @And("The send message another button is clicked")
    public void the_send_message_another_button_is_clicked(){
//        contactPage.clickMessageAnotherButton();
        ExtentManager.getTest().log(Status.INFO,"The send message another button is clicked");
    }





































































}
