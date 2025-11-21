package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.functors.IfClosure;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.LoginNewAccountPage;


@Slf4j
public class LoginNewAccountStep {


    private final SoftAssert softAssert;
    private final LoginNewAccountPage loginNewAccountPage;
    WebDriver driver;
    public LoginNewAccountStep(){
        loginNewAccountPage=new LoginNewAccountPage();
        softAssert=new SoftAssert();

    }


    @Given("Access to the site is granted.")
    public void access_to_the_site_is_granted(){
        String main="https://veo.az/";
        loginNewAccountPage.driver.get(main);
        loginNewAccountPage.driver.manage().window().maximize();

        ExtentManager.getTest().log(Status.INFO,"Access to the site is granted.");
    }

    @When("Click on the Sign In button")
    public void click_on_the_sign_in_button(){

        String oldUrl = loginNewAccountPage.driver.getCurrentUrl();

        boolean isVisible = loginNewAccountPage.isSignInButtonVisible();
        softAssert.assertTrue(isVisible, "Sign In düyməsi görünmür");
        loginNewAccountPage.clickSignInButton();

        if (isVisible) {
            boolean urlChanged = loginNewAccountPage.waitForUrlChange(oldUrl, 10);
            softAssert.assertTrue(urlChanged, "Klikdən sonra səhifənin URL-i dəyişmədi!");
           if (urlChanged){
               ExtentManager.getTest().log(Status.PASS,"sig in duymesi kliklendi ve url deyisdi");
           }else {
               ExtentManager.getTest().log(Status.FAIL, " Klikdən sonra səhifənin URL-i dəyişmədi!");
               softAssert.fail("Klikdən sonra səhifənin URL-i dəyişmədi!");
           }
        }else {
            ExtentManager.getTest().log(Status.FAIL, "Sign In düyməsi görünmür.");
            softAssert.fail("Sign In düyməsi görünmür");
        }
    }

    @Then("{string} address and {string} are entered")
    public void email_address_and_password_are_entered(String email,String password){

        softAssert.assertTrue(loginNewAccountPage.isEmailInputVisible(), "Email input görünmür!");
        softAssert.assertTrue(loginNewAccountPage.isPasswordInputVisible(), "Şifrə input görünmür!");

        loginNewAccountPage.enterEmail(email);
        loginNewAccountPage.enterPassword(password);

        softAssert.assertTrue(loginNewAccountPage.canEnterEmail(email), "Email inputa yazmaq mümkün olmadı!");
        softAssert.assertTrue(loginNewAccountPage.canEnterPassword(password), "Şifrə inputa yazmaq mümkün olmadı!");

        softAssert.assertTrue(loginNewAccountPage.isPasswordMasked(), "Password input sahəsi şifrə kimi maskalanmayıb!");

        if (loginNewAccountPage.isEmailInputVisible()) {

            if (loginNewAccountPage.canEnterEmail(email)) {
                ExtentManager.getTest().log(Status.PASS, "email sahesine yazmaq mumkundur");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "email sahesine yazmaq mumkun deyil");
                softAssert.fail("email sahesine yazmaq mumkun deyil");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Email input gorunmur");
            softAssert.fail("Email input gorunmur");
        }

        if (loginNewAccountPage.isPasswordInputVisible()){
            if (loginNewAccountPage.canEnterPassword(password)){
                ExtentManager.getTest().log(Status.PASS,"Password yazmaq mumkundur");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"password yazmaq mumkun deyil");
                softAssert.fail("password yazmaq mumkun deyil");
            }

            if (loginNewAccountPage.isPasswordMasked()){
                ExtentManager.getTest().log(Status.PASS,"password hissesi maskalanib");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"password hissesi maskalanmayib");
                softAssert.fail("password hissesi maskalanmayib");
            }

        }else {
            ExtentManager.getTest().log(Status.FAIL,"password input gorunmur");
            softAssert.fail("password input gorunmur");
        }

    }

    @And("The submit button is clicked")
    public void the_submit_button_is_clicked(){
        String oldUrl=loginNewAccountPage.driver.getCurrentUrl();
        boolean isVisible=loginNewAccountPage.isSubmitBUttonVisible();
        softAssert.assertTrue(isVisible,"submit duymesi gorunmur");

        loginNewAccountPage.clickSubmitButton();

        if (isVisible) {
            boolean urlChanged = loginNewAccountPage.waitForUrlChange(oldUrl, 10);
            softAssert.assertTrue(urlChanged, "Klikdən sonra səhifənin URL-i dəyişmədi!");
            if (urlChanged){
                ExtentManager.getTest().log(Status.PASS,"klikden sonra url deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Klikden sonra url deyismedi");
                softAssert.fail("Klikden sonra url deyismedi");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"submit duymesi gorunmur");
            softAssert.fail("submit duymesi gorunmur");
        }

        softAssert.assertAll();

    }



























































































}
