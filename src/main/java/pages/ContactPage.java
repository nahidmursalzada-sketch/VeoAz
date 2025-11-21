package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    public ContactPage(){

    }

    @FindBy(css = "#root > div.min-h-screen.bg-space-black > nav > div > div > a > img")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "//a[contains(@class, 'text-text-muted') and text()='Contact']")
    private WebElement contactButton;

    public void clickContactButton(){
        waitAndClick(contactButton);
    }

    @FindBy(xpath = "//input[@data-testid='input-name']")
    private WebElement nameInput;

    public void enterName(String name){
        waitAndClick(nameInput);
        nameInput.sendKeys(name);
    }

    @FindBy(xpath = "//input[@data-testid='input-email']" )
    private WebElement emailInput;

    public void enterEmail(String email){
        waitAndClick(emailInput);
        emailInput.sendKeys(email);
    }

    @FindBy(xpath = "//input[@data-testid='input-subject']")
    private WebElement subjectInput;

    public void enterSubject(String subject){
        waitAndClick(subjectInput);
        subjectInput.sendKeys(subject);
    }

    @FindBy(xpath = "//textarea[@data-testid='textarea-message']")
    private WebElement messageInput;

    public void enterMessage(String message){
        waitAndClick(messageInput);
        messageInput.sendKeys(message);
    }

//    private final By categoryIframe = By.xpath("//iframe[starts-with(@name, '__privateStripeController')]");
//    public void switchToCategoryIframe() {
//        switchToIframe(categoryIframe);
//    }
//    @FindBy(xpath = "//button[@data-testid='select-category']")
//    private WebElement categoryButton;
//
//    public void clickCategoryButton(){
//        waitAndClick(categoryButton);
//    }
//
//
//    @FindBy(xpath = "//option[@value='partnership']")
//    private WebElement selectCategory;
//
//    public void enterCategory(){
//        waitAndClick(selectCategory);
//
//    }
//
//    @FindBy(xpath = "//button[@data-testid='button-submit']")
//    private WebElement sendMessageButton;
//
//    public void clickSendMessageButton(){
//        waitAndClick(sendMessageButton);
//    }
//
//    @FindBy(xpath = "//button[@data-testid='button-new-message']")
//    private WebElement messageAnotherButton;
//
//    public void clickMessageAnotherButton(){
//        waitAndClick(messageAnotherButton);
//    }


    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getContactButton() {
        return contactButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getSubjectInput() {
        return subjectInput;
    }

    public WebElement getMessageInput() {
        return messageInput;
    }
}
