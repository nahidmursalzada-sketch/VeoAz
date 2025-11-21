package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import config.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.BillingPage;

public class BillingStep {


    private final BillingPage billingPage;
    WebDriver driver;
    private final SoftAssert softAssert;
    private final BasePage basePage;
    public BillingStep(){
        billingPage=new BillingPage();
        softAssert=new SoftAssert();
        basePage=new BasePage();
        this.driver = WebDriverManager.getChromeDriver();
    }

    @Given("User enters the main vault.")
    public void user_enters_the_main_vault(){
        billingPage.clickHomePageButton();

        ExtentManager.getTest().log(Status.INFO,"User enters the main vault.");

    }

    @When("The user clicks on the control panel.")
    public void the_user_clicks_on_the_control_panel(){
       String oldUrl=billingPage.driver.getCurrentUrl();

        if (basePage.isElementVisible(billingPage.getControlPanelButton())){
            billingPage.clickControlPanelButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"control panel butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"control panel butonu kliklenmedi");
                softAssert.fail("control panel butonu kliklenmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"control panel button gorunmedi");
            softAssert.fail("control panel button gorunmedi");
        }

    }

    @Then("The user clicks the payment button.")
    public void the_user_clicks_the_payment_button(){
        String oldUrl=billingPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(billingPage.getPaymentButton())){
            billingPage.clickPaymentButton();
            if (basePage.waitForUrlChange(oldUrl,10)){
                ExtentManager.getTest().log(Status.PASS,"payment butonuna ugurla klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"payment butonuna klik edilmedi");
                softAssert.fail("payment butonuna klik edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.PASS,"payment butonu gorunmedi");
            softAssert.fail("payment butonu gorunmedi");
        }



    }

    @And("The user deposits the package they want.")
    public void the_user_deposits_the_package_they_want(){
        if (basePage.isElementVisible(billingPage.getPackageSelect())){
            billingPage.enterPackage();
            ExtentManager.getTest().log(Status.PASS,"Package gorundu ve klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Package gorunmedi");
            softAssert.fail("Package gorunmedi");
        }

    }

    @And("{string} is entered")
    public void amount_is_entered(String amount){
        if (basePage.isElementVisible(billingPage.getAmountInput())) {
            billingPage.enterAmount(amount);
            if (basePage.canEnterText(billingPage.getAmountInput(),amount)){
                ExtentManager.getTest().log(Status.PASS,"Text ugurla daxil edildi");

            }else {
                ExtentManager.getTest().log(Status.FAIL,"Text daxil edilmedi");
                softAssert.fail("Text daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Amount daxil etme butonu gorunmedi");
            softAssert.fail("Amount daxil etme butonu gorunmedi");
        }


    }

    @And("Inserting a new {string}")
    public void Inserting_a_new_card(String cardNumber){
    billingPage.switchToCardIframe();

        By cardLocator = billingPage.getCardNumberInput();
        if (basePage.isElementVisibleBy(cardLocator)){

        billingPage.enterCardNumber(cardNumber);

        if (basePage.canEnterTextBy(billingPage.getCardNumberInput(),cardNumber)){
            ExtentManager.getTest().log(Status.PASS,"Card number ugurla daxil edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Card number daxil edilmedi");
            softAssert.fail("Card number daxil edilmedi");
        }
    }else {
        ExtentManager.getTest().log(Status.FAIL,"Card number input gorunmedi");
    }
        driver.switchTo().defaultContent();
    }

    @And("{string} are entered")
    public void month_and_year_entered(String monthYear) {
        billingPage.switchToCardIframe();
        By monthYearLocator = billingPage.getMonthYearInput();

        if (basePage.isElementVisibleBy(monthYearLocator)) {
            billingPage.enterMonthYear(monthYear);
            ExtentManager.getTest().log(Status.PASS,"Month and year daxil edildi");
            softAssert.assertTrue(true,"Month and year daxil edildi");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Month and year input görünmədi");
            softAssert.fail("Month and year input görünmədi");
        }


    }

    @And("Entering {string} code")
    public void entering_security_code(String security){

        By securityLocator = billingPage.getSecurityInput();
        if (basePage.isElementVisibleBy(securityLocator)){
            billingPage.enterSecurity(security);
            if (basePage.canEnterTextBy(billingPage.getSecurityInput(),security)){
                ExtentManager.getTest().log(Status.PASS,"security ugurla daxil edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"security daxil edilmedi");
                softAssert.fail("security daxil edilmedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"security input gorunmedi");
        }
        driver.switchTo().defaultContent();
    }


    @And("Click the Save card for future payments button.")
    public void click_the_save_card_for_future_payments_button(){

        if (basePage.isElementVisible(billingPage.getPaymentButton())){
            billingPage.clickCardKeep();
            ExtentManager.getTest().log(Status.PASS,"card for future payments button gorundu ve klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"card for future payments button gorunmedi");
            softAssert.fail("card for future payments button gorunmedi");
        }
    }



    @And("Click the saved card button")
    public void click_the_saved_card_button(){

         if (basePage.isElementVisible(billingPage.getSavedCardButton())){
             billingPage.clickSavedCardbutton();
             if (basePage.isClickSuccessful(billingPage.getSavedCardButton(),By.xpath("//p[text()='No saved cards']"))){
                 ExtentManager.getTest().log(Status.PASS,"Saved card butonuna klik edildi");
             }else {
                 ExtentManager.getTest().log(Status.FAIL,"Saved card butonuna klik edimedi");
                 softAssert.fail("Saved card butonuna klik edimedi");
             }
         }else {
             ExtentManager.getTest().log(Status.FAIL,"Saved card butonu gorunmedi");
             softAssert.fail("Saved card butonu gorunmedi");
         }

    }
































}
