package pages;

import config.WebDriverManager;
import io.cucumber.core.stepexpression.ExpressionArgument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillingPage extends BasePage {



    public BillingPage(){

    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    public WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "//a[@data-testid='link-dashboard']")
    public WebElement controlPanelButton;

    public void clickControlPanelButton(){
        controlPanelButton.click();
    }

    @FindBy(xpath = "//a[@data-testid='nav-link-billing']")
    public WebElement paymentButton;

    public void clickPaymentButton(){
        paymentButton.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/main/div/div/div[2]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]")
    public WebElement packageSelect;

    public void enterPackage(){
        packageSelect.click();
    }

    @FindBy(xpath = "//input[@id='custom-amount']")
    public WebElement amountInput;

    public void enterAmount(String amount){
        waitAndClick(amountInput);
        amountInput.sendKeys(amount);
    }

    private final By cardIframe = By.xpath("/html/body/div/div[1]/div/main/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/form/div[1]/div/div/iframe");
    public void switchToCardIframe() {
        switchToIframe(cardIframe);
    }

    public final By cardNumberInput = By.name("cardnumber");
    public void enterCardNumber(String cardNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cardInput = wait.until(ExpectedConditions.elementToBeClickable(cardNumberInput));
        cardInput.sendKeys(cardNumber);
    }

    private final By monthYearInput=By.name("exp-date");
    public void enterMonthYear(String monthYear){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement monthAndYearInput=wait.until(ExpectedConditions.elementToBeClickable(monthYearInput));
        monthAndYearInput.sendKeys(monthYear);
    }

    private final By securityInput=By.name("cvc");
    public void enterSecurity(String security){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement cssInput=wait.until(ExpectedConditions.elementToBeClickable(securityInput));
        cssInput.sendKeys(security);
    }


    @FindBy(xpath = "//input[@type='checkbox' and @id='save-card']")
    public WebElement cardKeepButton;

    public void clickCardKeep(){
        cardKeepButton.click();
    }

    @FindBy(xpath = "//button[contains(@class, 'text-sm') and contains(text(), 'Saved Cards')]")
    public WebElement savedCardButton;

    public void clickSavedCardbutton(){
        savedCardButton.click();
    }


    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getControlPanelButton() {
        return controlPanelButton;
    }

    public WebElement getPaymentButton() {
        return paymentButton;
    }

    public WebElement getPackageSelect() {
        return packageSelect;
    }

    public WebElement getAmountInput() {
        return amountInput;
    }

    public By getCardIframe() {
        return cardIframe;
    }

    public By getCardNumberInput() {
        return cardNumberInput;
    }

    public By getMonthYearInput() {
        return monthYearInput;
    }

    public By getSecurityInput() {
        return securityInput;
    }

    public WebElement getCardKeepButton() {
        return cardKeepButton;
    }

    public WebElement getSavedCardButton() {
        return savedCardButton;
    }
}
