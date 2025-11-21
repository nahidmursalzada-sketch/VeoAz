package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginNewAccountPage extends BasePage {

    public LoginNewAccountPage(){

    }

    @FindBy(xpath = "//a[@data-testid='button-sign-in']")
    private WebElement signInButton;

    public void clickSignInButton(){
        waitAndClick(signInButton);
    }

    public boolean isSignInButtonVisible() {
        try {
            return signInButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @FindBy(xpath = "//input[@type='email' and @name='email' and @data-testid='input-signin-email' and @placeholder='sizin@email.com']")
    private WebElement emailInput;

    public void enterEmail(String email){
        waitAndClick(emailInput);
        emailInput.sendKeys(email);
    }

    public boolean isEmailInputVisible() {
        try {
            return emailInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean canEnterEmail(String email) {
        try {
            return emailInput.getAttribute("value").equals(email);
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//input[@type='password' and @name='password' and @data-testid='input-signin-password' and @placeholder='Şifrənizi daxil edin']")
    private WebElement passwordInput;

    public void enterPassword(String password){
        waitAndClick(passwordInput);
        passwordInput.sendKeys(password);
    }

    public boolean isPasswordInputVisible() {
        try {
            return passwordInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean canEnterPassword(String password) {
        try {
            return passwordInput.getAttribute("value").equals(password);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordMasked() {
        try {
            String typeAttr = passwordInput.getAttribute("type");
            return "password".equals(typeAttr);
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//button[@data-testid='button-signin' and @type='submit' and text()='Daxil ol']")
    private WebElement submitButton;

    public void clickSubmitButton(){
        waitAndClick(submitButton);
    }

    public boolean isSubmitBUttonVisible(){
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


//  Urlin deyismesini yoxlamaq ucun metod
    public boolean waitForUrlChange(String oldUrl, int timeoutSeconds) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(driver -> !driver.getCurrentUrl().equals(oldUrl));
        } catch (Exception e) {
            return false;
        }
    }

















































}
