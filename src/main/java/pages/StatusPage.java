package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatusPage extends BasePage{

    public StatusPage(){}

    @FindBy(css = "svg[data-testid=\"breadcrumb-home\"]")
    private WebElement homePageButton;

    public void clickHomePageButton(){
        homePageButton.click();
    }

    @FindBy(xpath = "//a[text()='Status']")
    private WebElement statusButton;

    public void clickStatusButton(){
        waitAndClick(statusButton);
    }


    public WebElement getStatusButton() {
        return statusButton;
    }
}
