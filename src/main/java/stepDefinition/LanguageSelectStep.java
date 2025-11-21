package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.commons.collections4.functors.IfClosure;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.LanguageSelectPage;

public class LanguageSelectStep {

    private final LanguageSelectPage languageSelectPage;
    private final SoftAssert softAssert;
    public LanguageSelectStep (){
        languageSelectPage=new LanguageSelectPage();
        softAssert=new SoftAssert();
    }


    @Given("The site's home page opens.")
    public void the_site_is_page_opens()throws InterruptedException{
        languageSelectPage.clickHomePageButton();
        Thread.sleep(1000);
        ExtentManager.getTest().log(Status.INFO,"The site's home page opens.");
    }

    @When("The language selection button is clicked")
    public void the_language_selection_button_is_clicked(){

        boolean isVisible=languageSelectPage.isLanguageButtonVisible();
        softAssert.assertTrue(isVisible,"Dil secim butonu gorunmur");

        languageSelectPage.clickLanguageButton();

        if (languageSelectPage.isLanguageButtonVisible()){
            ExtentManager.getTest().log(Status.PASS,"Dil secim butonuna klik edildi ve menu acildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Dil secim butonu gorunmur");
            softAssert.fail("Dil secim butonu gorunmur");
        }
    }

    @Then("Click the US button")
    public void click_the_US_button()throws InterruptedException {
        boolean isVisible=languageSelectPage.isUsButtonVisible();
        softAssert.assertTrue(isVisible,"US butonu gorunmur");

        languageSelectPage.clickUsButton();

        boolean isEnglishApplied = languageSelectPage.isEnglishLanguageApplied();
        softAssert.assertTrue(isEnglishApplied,"Dil ingilis diline deyisdirilmedi");

        if (isVisible){
            ExtentManager.getTest().log(Status.PASS,"US butonuna klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"US butonu gorunmur");
            softAssert.fail("US butonu gorunmur");
        }

        if (isEnglishApplied){
            ExtentManager.getTest().log(Status.PASS,"Dil ugurla deyisdirildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Dil deyisdirilmedi");
            softAssert.fail("Dil deyisdirilmedi");
        }
        Thread.sleep(15000);


    }
























































}
