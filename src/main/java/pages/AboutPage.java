package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{




    @FindBy(css = "#root > div.min-h-screen.bg-space-black > div > div > div > div > div.flex-1.min-w-0 > div > nav > ol > li:nth-child(1) > a > svg")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();

    }

    @FindBy(xpath = "//a[text()='About']")
    private WebElement aboutButton;

    public void clickAboutButton(){
        aboutButton.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/section[7]/div/div/a[2]/button")
    private WebElement plansButton;

    public void clickPlansButton(){
        plansButton.click();
    }

    @FindBy(xpath = "//input[@data-testid='input-custom-amount']")
    public WebElement amountInput;

    public void enterAmount(String amount){
        waitAndClick(amountInput);
        amountInput.sendKeys(amount);
    }

    @FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/div[5]/div")
    private WebElement packageSelect;

    public void selectPackage(){
        packageSelect.click();
    }

    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getAboutButton() {
        return aboutButton;
    }

    public WebElement getPlansButton() {
        return plansButton;
    }

    public WebElement getAmountInput() {
        return amountInput;
    }

    public WebElement getPackageSelect() {
        return packageSelect;
    }





}
