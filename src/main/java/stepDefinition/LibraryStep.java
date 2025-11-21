package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LibraryPage;

import java.time.Duration;

public class LibraryStep {

    private final LibraryPage libraryPage;
    private final BasePage basePage;
    private final SoftAssert softAssert;
    WebDriver driver;

    public LibraryStep() {
        libraryPage = new LibraryPage();
        softAssert = new SoftAssert();
        basePage = new BasePage();
    }

    @Given("The user has entered the main safe of the platform.")
    public void the_user_has_entered_the_main_safe_of_the_platform() {
        String oldUrl = libraryPage.driver.getCurrentUrl();
        if (basePage.isElementVisible(libraryPage.getHomePageButton())) {
            libraryPage.clickHomePageButton();
            if (basePage.waitForUrlChange(oldUrl, 10)) {
                ExtentManager.getTest().log(Status.PASS, "Ana sehifeye giris edildi");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "Ana sehifeye giris edilmedi");
                softAssert.fail("Ana sehifeye giris edilmedi");
            }
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Ana sehifeye kecid butonu gorunmedi");
            softAssert.fail("Ana sehifeye kecid butonu gorunmedi");
        }


    }

    @When("Clicks on the library button")
    public void click_on_the_library_button() {
        String oldUrl = libraryPage.driver.getCurrentUrl();
        softAssert.assertTrue(basePage.isElementVisible(libraryPage.getLibraryButton()), "Library button görünmür!");

        if (basePage.isElementVisible(libraryPage.getLibraryButton())) {
            libraryPage.clickLibraryButton();

            // URL dəyişib-dəyişmədiyini yoxla
            if (basePage.waitForUrlChange(oldUrl, 10)) {
                ExtentManager.getTest().log(Status.PASS, "Library button klik edildi və URL dəyişdi");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "Library button klik edildi amma URL dəyişmədi");
                softAssert.fail("Library button klik edildi amma URL dəyişmədi!");
            }
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Library button görünmür");
            softAssert.fail("Library button görünmür!");
        }
    }


    @Then("User is searching for {string}")
    public void user_is_searching_for_video(String video) {

        // Input görünürsə davam et
        if (basePage.isElementVisible(libraryPage.getVideoSearchButton())) {

            // Video textini daxil et
            libraryPage.enterVideo(video);

            // Daxil edilən mətnin düzgün olub-olmadığını yoxla
            if (basePage.canEnterText(libraryPage.getVideoSearchButton(), video)) {
                ExtentManager.getTest().log(Status.PASS, "Video search inputuna text daxil edildi ");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "Video search inputuna text daxil edilmedi");
                softAssert.fail("Video search inputuna text daxil edilmedi");
            }

            if (basePage.isSearchSuccessful(By.xpath("/html/body/div/div[1]/div/main/div/div[2]/div/div[2]/div"), video)) {
                ExtentManager.getTest().log(Status.PASS, "Axtarış düzgün işləyir: ");
            } else {
                ExtentManager.getTest().log(Status.FAIL, "Axtarış zamanı texniki xəta baş verdi: ");
                softAssert.fail("Axtarış uğursuz icra olundu (texniki xəta): ");
            }

        } else {
            ExtentManager.getTest().log(Status.FAIL, "Video search input görünmür");
            softAssert.fail("Video search input görünmür");
        }
    }


    @And("Click the list button")
    public void click_the_list_button() {
        if (basePage.isElementVisible(libraryPage.getListButton())) {
            libraryPage.clickListButton();
            ExtentManager.getTest().log(Status.PASS, "List butonuna klik edildi");
            softAssert.assertTrue(true, "List butonuna klik edildi");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "List butonu gorunmur");
            softAssert.fail("List butonu gorunmur");
        }

    }


    @And("Click the all button")
    public void click_the_all_button() {
        if (basePage.isElementVisible(libraryPage.getAllButton())){
            libraryPage.clickAllButton();
            ExtentManager.getTest().log(Status.PASS,"All butonuna klik edildi");
            softAssert.assertTrue(true,"All butonuna klik edildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"All butonu gorunmedi");
            softAssert.fail("All butonu gorulmedi");
        }

    }



    @And("The button is selected in statusFilter")
    public void the_button_is_selected_in_status_filter() {

        if (basePage.isElementVisible(libraryPage.getSelectStatusFilter())){
            libraryPage.enterStatusFilter();
            ExtentManager.getTest().log(Status.PASS,"Status filter secildi");
            softAssert.assertTrue(true,"Status filter secildi");
        }else {
            ExtentManager.getTest().log(Status.FAIL,"Status filter gorulmedi");
            softAssert.fail("Status filter gorulmedi");
        }

    }

    @And("Click the newest button")
    public void click_the_newest_button() {
        boolean isVisible=libraryPage.isAllButtonVisible();
        softAssert.assertTrue(isVisible,"Newest butonu gorsenmir");



        if (isVisible) {
            libraryPage.clickNewestButton();


            try {
                WebDriverWait wait = new WebDriverWait(libraryPage.driver, Duration.ofSeconds(10));
                WebElement oldestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Oldest']")));

                if (oldestButton.isDisplayed()) {
                    ExtentManager.getTest().log(Status.PASS, " Newest butonuna klik ugurludur");
                } else {
                    ExtentManager.getTest().log(Status.FAIL, "Newest butonuna kliklenmedi");
                    softAssert.fail("Newest butonuna kliklenmedi");
                }

            } catch (TimeoutException e) {
                ExtentManager.getTest().log(Status.FAIL, "oldest elementi 10 saniyə ərzində görünmədi");
                softAssert.fail("Newest butonuna klik edildi, ancaq oldest görünmədi");
            }

        } else {
            ExtentManager.getTest().log(Status.FAIL, "Newest butonu gorunmur");
            softAssert.fail("Newest butonu gorunmur");
        }

    }


    @And("The {string} is selected.")
    public void the_sorting_filter_is_selected(String sortingFilter){
        boolean isVisible=libraryPage.isModelOptionVisible("Failed");
        softAssert.assertTrue(isVisible,"Failed butonu gorsenmir");


        if (isVisible) {

            libraryPage.enterNewest(sortingFilter);

            try {
                WebDriverWait wait = new WebDriverWait(libraryPage.driver, Duration.ofSeconds(10));
                WebElement oldestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Oldest']")));

                if (oldestButton.isDisplayed()) {
                    ExtentManager.getTest().log(Status.PASS, "sorting filter secildi");
                } else {
                    ExtentManager.getTest().log(Status.FAIL, "Oldest elementi tapildi amma gorunmur");
                    softAssert.fail("Oldest elementi gorunmur");
                }

            } catch (TimeoutException e) {
                ExtentManager.getTest().log(Status.FAIL, "Oldest elementi 10 saniyə ərzində görünmədi");
                softAssert.fail("Newest butonuna klik edildi, ancaq Oldest görünmədi");
            }

        } else {
            ExtentManager.getTest().log(Status.FAIL, "Oldest butonu gorunmur");
            softAssert.fail("Oldest butonu gorunmur");
        }
    }

    @And("The first video button is clicked")
    public void the_first_video_button_is_clicked(){
        String oldUrl = libraryPage.driver.getCurrentUrl();
        if(basePage.isElementVisible(libraryPage.getFirstVideoButton())){
            libraryPage.clickFirstVideoButton();

            if (basePage.waitForUrlChange(oldUrl,10)) {
                ExtentManager.getTest().log(Status.PASS, "first video butonuna klik edildi");
            }else {
                ExtentManager.getTest().log(Status.FAIL,"first video butonuna klik edilmedi");
                softAssert.fail("first video butonuna klik edilmedi");
            }

        }else {
            ExtentManager.getTest().log(Status.FAIL,"First video butonu gorunmedi");
            softAssert.fail("First video butonu gorunmedi");
        }

    }



































}
