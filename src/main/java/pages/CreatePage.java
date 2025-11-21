package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.time.Duration;
import java.util.List;

public class CreatePage extends BasePage{


    public CreatePage(){

    }


    @FindBy(xpath = "/html/body/div/div[1]/nav/div/div/a/img")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }


    @FindBy(xpath = "//a[@data-testid='link-create']")
    private WebElement createButton;

    public void clickCreateButton(){
        createButton.click();
    }

    public boolean isCreateButtonVisible(){
        try {
           return createButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @FindBy(xpath = "//textarea[@data-testid='textarea-scene']")
    private WebElement sceneDescriptionInput;

    public void enterSceneDescription(String sceneDescription){
        waitAndClick(sceneDescriptionInput);
        sceneDescriptionInput.sendKeys(sceneDescription);
    }

    public boolean isSceneDescriptionVisible(){
        try {
            return sceneDescriptionInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean canEnterSceneDescription(String sceneDescription){
        try {
            return sceneDescriptionInput.getAttribute("value").equals(sceneDescription);
        }catch (Exception e){
            return false;
        }
    }

    public boolean isSceneDescriptionValidLength() {
        try {
            String text = sceneDescriptionInput.getAttribute("value");
            return text != null && text.length() >= 50;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath="//button[@data-testid='select-model']")
    private WebElement aiModelButton;

    public void clickAimodelButton(){
        aiModelButton.click();
    }

    public boolean isAiModelButtonVisible(){
        try {
            return aiModelButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }



    public void selectModel(String modelName) {

        String optionXpath = "//*[normalize-space(.)='" + modelName + "']";
        clickByXpath(optionXpath);
    }

    public boolean isModelOptionVisible(String modelName) {
        try {
            String optionXpath = "//*[normalize-space(text())='" + modelName + "']";
            WebElement optionElement = driver.findElement(By.xpath(optionXpath));
            return optionElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//button[@data-testid='button-check-enhanced']")
    private WebElement aiEnhancedButton;

    public void clickAiEnhancedButton(){
        waitAndClick(aiEnhancedButton);
    }

    public boolean isAiEnhancedButtonVisible(){
        try {
           return aiModelButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//button[text()='AZ']")
    private WebElement languageButton;

    public void clickLanguageButton(){
        languageButton.click();
    }

    public boolean isLanguageButtonVisible(){
        try{
            return languageButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//button[@type='button' and normalize-space(.)='Original']")
    private WebElement orijinalButton;

    public void clickOrijinalButton(){
        orijinalButton.click();
    }

    public boolean isOrijinalButtonVisibile (){
        try {
            return orijinalButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//button[@data-testid='button-generate-new']")
    private WebElement createNewButton;

    public void clickCreateNewButton(){
        createNewButton.click();
    }

    public boolean isCreateNewButtonVisible(){
        try {
        return createNewButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }



    public boolean waitForUrlChange(String oldUrl, int timeoutSeconds) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(driver -> !driver.getCurrentUrl().equals(oldUrl));
        } catch (Exception e) {
            return false;
        }
    }




















































}
