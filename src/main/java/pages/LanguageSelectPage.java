package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class LanguageSelectPage extends BasePage {

    public LanguageSelectPage(){}

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div/div[1]/div/nav/ol/li[1]/a")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "/html/body/div/div[1]/nav/div/div/div[1]/button[1]")
    private WebElement languageButton;

    public void clickLanguageButton() {
       waitAndClick(languageButton);
    }

    public boolean isLanguageButtonVisible(){
        try {
            return languageButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @FindBy(xpath = "//div[@data-testid='menu-item-en']")
    private WebElement usButton;

    public void  clickUsButton(){
    waitAndClick(usButton);
    }

    public boolean isUsButtonVisible(){
        try {
            return usButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//a[@data-testid='link-create']")
    private WebElement createButton;

    public boolean isEnglishLanguageApplied() {
        try {
            String createText = createButton.getText();
            return createText.equalsIgnoreCase("Create");
        } catch (Exception e) {
            return false;
        }
    }































}
