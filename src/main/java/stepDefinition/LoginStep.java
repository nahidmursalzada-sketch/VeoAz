package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import org.testng.asserts.SoftAssert;
;
import pages.LoginPage;

@Slf4j
public class LoginStep {



    private final LoginPage loginPage;
    private final SoftAssert softAssert;
    public LoginStep(){
        loginPage = new LoginPage();
        softAssert=new SoftAssert();
    }

    @Given("The user navigates to the homepage.")
    public void the_user_navigates_to_the_homepage(){

        String firstPage = "https://veo.az/";
        loginPage.driver.get(firstPage);
        loginPage.driver.manage().window().maximize();
        ExtentManager.getTest().log(Status.INFO, "The user navigates to the homepage.");
    }

    @When("The login button is clicked.")
    public void the_login_button_is_clicked(){
        String oldUrl = loginPage.driver.getCurrentUrl();

        boolean isVisible = loginPage.isLoginButtonVisible();
        softAssert.assertTrue(isVisible, "Login düyməsi görünmür");

        loginPage.clickLoginButton();

        if (isVisible) {
            boolean urlChanged = loginPage.waitForUrlChange(oldUrl, 10);
            softAssert.assertTrue(urlChanged, "Klikdən sonra səhifənin URL-i dəyişmədi!");
            if (urlChanged){
                ExtentManager.getTest().log(Status.PASS,"Login duymesi kliklendi ve url deyisdi");
            }else {
                ExtentManager.getTest().log(Status.FAIL, " Klikdən sonra səhifənin URL-i dəyişmədi!");
                softAssert.fail("Klikdən sonra səhifənin URL-i dəyişmədi!");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL, "Sign In düyməsi görünmür.");
            softAssert.fail("Sign In düyməsi görünmür");
        }


    }

    @Then("{string} and {string} are entered.")
    public void email_and_password_are_entered(String email, String password){


        softAssert.assertTrue(loginPage.isEmailInputVisible(), "Email input görünmür!");
        softAssert.assertTrue(loginPage.isPasswordInputVisible(), "Şifrə input görünmür!");

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        softAssert.assertTrue(loginPage.canEnterEmail(email), "Email inputa yazmaq mümkün olmadı!");
        softAssert.assertTrue(loginPage.canEnterPassword(password), "Şifrə inputa yazmaq mümkün olmadı!");

        softAssert.assertTrue(loginPage.isPasswordMasked(), "Password input sahəsi şifrə kimi maskalanmayıb!");

        if (loginPage.isEmailInputVisible()) {

            if (loginPage.canEnterEmail(email)) {
                ExtentManager.getTest().log(Status.PASS, "email sahesine yazmaq mumkundur");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "email sahesine yazmaq mumkun deyil");
                softAssert.fail("email sahesine yazmaq mumkun deyil");
            }
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Email input gorunmur");
            softAssert.fail("Email input gorunmur");
        }

        if (loginPage.isPasswordInputVisible()){
            if (loginPage.canEnterPassword(password)){
                ExtentManager.getTest().log(Status.PASS,"Password sahesine yazmaq mumkundur");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Password yazmaq mumkun deyil");
                softAssert.fail("Password sahesine yazmaq mumkun deyil");
            }

            if (loginPage.isPasswordMasked()){
                ExtentManager.getTest().log(Status.PASS,"Password hissesi maskalanib");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"Password hissesi maskalanmayib");
                softAssert.fail("Password hissesi maskalanmayib");
            }

        }else {
            ExtentManager.getTest().log(Status.FAIL,"Password input gorunmur");
            softAssert.fail("Password input gorunmur");
        }

    }

    @And("Click the submit button")
    public void click_the_submit_button(){
        String oldUrl=loginPage.driver.getCurrentUrl();
        boolean isVisible=loginPage.isSubmitBUttonVisible();
        softAssert.assertTrue(isVisible,"submit duymesi gorunmur");


        loginPage.clickSubmitButton();

        if (isVisible) {
            boolean urlChanged = loginPage.waitForUrlChange(oldUrl, 10);
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



    }
}




















