package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage extends BasePage{

    public PricingPage(){

    }

    @FindBy(css ="#root > div.min-h-screen.bg-space-black > div.transition-all.duration-300.lg\\:pl-64 > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg" )
    private WebElement homeButton;

    public void clickHomeButton(){
        waitAndClick(homeButton);
    }

    @FindBy(xpath = "//a[@href='/pricing' and contains(@class, 'hover:text-electric-blue')]")
    private WebElement pricingButton;

    public void clickPricingButton(){
        waitAndClick(pricingButton);
    }

    @FindBy(xpath = "//input[@type='number' and @data-testid='input-custom-amount']")
    private WebElement amountInput;

    public void enterAmount(String amount){
        waitAndClick(amountInput);
        amountInput.sendKeys(amount);
    }

    @FindBy(xpath = "//button[@data-testid='button-purchase-custom']")
    private WebElement addCreditButton;

    public void clickAddCreditButton(){
        waitAndClick(addCreditButton);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/section/div/div/div[3]/div/div[6]/div/div/div[1]")
    private WebElement selectPackage;

    public void enterPackage(){
        waitAndClick(selectPackage);
    }



























}
