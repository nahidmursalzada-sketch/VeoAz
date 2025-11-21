package stepDefinition;

import com.aventstack.extentreports.Status;
import config.ExtentManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CreatePage;
import config.WebDriverManager;

import java.time.Duration;

public class CreateStep {

     private final CreatePage createPage;
     private final SoftAssert softAssert;
     public CreateStep (){
     createPage=new CreatePage();
     softAssert=new SoftAssert();
     }

     @Given("The main safe of the site is entered")
     public void the_main_safe_of_the_site_is_entered(){

          createPage.clickHomePageButton();
          ExtentManager.getTest().log(Status.INFO,"The main safe of the site is entered");
     }

     @When("Click on the create button.")
     public void click_on_the_create_button(){
          String oldUrl=createPage.driver.getCurrentUrl();
          boolean isVisible=createPage.isCreateButtonVisible();
          softAssert.assertTrue(isVisible,"Create butonu gorsenmir");
          createPage.clickCreateButton();
          if (isVisible){
               boolean urlChanged = createPage.waitForUrlChange(oldUrl, 10);
               softAssert.assertTrue(urlChanged, "Klikdən sonra səhifənin URL-i dəyişmədi!");
               if (urlChanged){
                    ExtentManager.getTest().log(Status.PASS,"Create butonu kliklendi ve Url deyisdi");
               }else {
                    ExtentManager.getTest().log(Status.FAIL,"Create butonuna klik etdikden sonra url deyismedi");
                    softAssert.fail("Create butonuna klik etdikden sonra url deyismedi");
               }
          }else {
               ExtentManager.getTest().log(Status.FAIL,"Create butonu gorsenmir");
               softAssert.fail("Create butonu gorsenmir");
          }

     }

     @Then("{string} is included")
     public void scene_description_is_included(String sceneDescription){
         softAssert.assertTrue(createPage.isSceneDescriptionVisible(),"scene description input gorsenmir");
         createPage.enterSceneDescription(sceneDescription);
         softAssert.assertTrue(createPage.canEnterSceneDescription(sceneDescription),"Scene description inputa yazmaq mumkun olmadi");
         softAssert.assertTrue(createPage.isSceneDescriptionValidLength(),"Daxil edilən mətn 50 simvol tələbini ödəmir.");
          if (createPage.isSceneDescriptionVisible()){
               if (createPage.canEnterSceneDescription(sceneDescription)){
                    ExtentManager.getTest().log(Status.PASS,"scene description sahesine yazmaq mumkundur");
               }else {
                    ExtentManager.getTest().log(Status.FAIL,"scene description sahesine yazmaq mumkun deyil");
                    softAssert.fail("scene description sahesine yazmaq mumkun deyil");
               }

               if (createPage.isSceneDescriptionValidLength()){
                    ExtentManager.getTest().log(Status.PASS,"daxil edilen metn 50 simvol telebini odeyir");
               }else {
                    ExtentManager.getTest().log(Status.FAIL,"Daxil edilen metn 50 simvol telebini odemir");
                    softAssert.fail("Daxil edilen metn 50 simvol telebini odemir");
               }
          }else {
               ExtentManager.getTest().log(Status.FAIL,"scene description input gorunmur");
               softAssert.fail("scene description input gorunmur");
          }
     }

     @And("Clicking on the AI model button")
     public void clicking_on_the_AI_model_button(){
          boolean isVisible=createPage.isAiModelButtonVisible();
          softAssert.assertTrue(isVisible,"AI model butonu gorsenmir");



          if (isVisible) {
               createPage.clickAimodelButton();


               try {
                    WebDriverWait wait = new WebDriverWait(createPage.driver, Duration.ofSeconds(10));
                    WebElement veo2Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Veo 2']")));

                    if (veo2Button.isDisplayed()) {
                         ExtentManager.getTest().log(Status.PASS, " AI model butonuna klik ugurludur");
                    } else {
                         ExtentManager.getTest().log(Status.FAIL, "AI model butonuna kliklenmedi");
                         softAssert.fail("AI model butonuna kliklenmedi");
                    }

               } catch (TimeoutException e) {
                    ExtentManager.getTest().log(Status.FAIL, "Veo 2 elementi 10 saniyə ərzində görünmədi");
                    softAssert.fail("AI model butonuna klik edildi, ancaq Veo 2 görünmədi");
               }

          } else {
               ExtentManager.getTest().log(Status.FAIL, "AI model butonu gorunmur");
               softAssert.fail("AI model butonu gorunmur");
          }

     }

     @And("AI {string} is selected")
     public void AI_model_is_selected(String modelName){
          boolean isVisible=createPage.isModelOptionVisible("Veo 2");
          softAssert.assertTrue(isVisible,"Veo 2 butonu gorsenmir");


          if (isVisible) {

               createPage.selectModel(modelName);

               try {
                    WebDriverWait wait = new WebDriverWait(createPage.driver, Duration.ofSeconds(10));
                    WebElement veo2Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Veo 2']")));

                    if (veo2Button.isDisplayed()) {
                         ExtentManager.getTest().log(Status.PASS, "Veo 2 elementi gorundu - klik ugurludur");
                    } else {
                         ExtentManager.getTest().log(Status.FAIL, "Veo 2 elementi tapildi amma gorunmur");
                         softAssert.fail("Veo 2 elementi gorunmur");
                    }

               } catch (TimeoutException e) {
                    ExtentManager.getTest().log(Status.FAIL, "Veo 2 elementi 10 saniyə ərzində görünmədi");
                    softAssert.fail("AI model butonuna klik edildi, ancaq Veo 2 görünmədi");
               }

          } else {
               ExtentManager.getTest().log(Status.FAIL, "Veo 2 butonu gorunmur");
               softAssert.fail("Veo 2 butonu gorunmur");
          }

     }

     @And("Clicking the AI Enhanced button")
     public void clicking_the_AI_Enhanced_button()throws InterruptedException{
         boolean isVisible=createPage.isAiEnhancedButtonVisible();
         softAssert.assertTrue(isVisible,"AI Enhanced butonu gorsenmir");
          createPage.clickAiEnhancedButton();
         Thread.sleep(10000);

         if (isVisible){
              ExtentManager.getTest().log(Status.PASS,"AI Enhanced butonuna klik edildi ");
         }else {
              ExtentManager.getTest().log(Status.FAIL, "AI Enhanced butonu gorsenmir");
              softAssert.fail("AI Enhanced butonu gorsenmir");
         }

     }

     @And("Language selection for enhanced AI")
     public void language_selection_for_enhanced_ai()throws  InterruptedException{
          boolean isVisible=createPage.isLanguageButtonVisible();
          softAssert.assertTrue(isVisible,"Language selection gorsenmir ");
          createPage.clickLanguageButton();
          Thread.sleep(15000);
          if (isVisible){
               ExtentManager.getTest().log(Status.PASS,"Language selection kliklendi ve dil deyisimi ugurlu oldu");
          }else {
               ExtentManager.getTest().log(Status.FAIL, "Language selectionlar gorsenmir");
               softAssert.fail("language selectionlar gorsenmir");
          }
     }

     @And("The orijinal button is clicked")
     public void the_orijinal_button_is_clicked(){
          boolean isVisible=createPage.isOrijinalButtonVisibile();
          softAssert.assertTrue(isVisible,"Orijinal butonu gorsenmir");
          createPage.clickOrijinalButton();

          if (isVisible){
               ExtentManager.getTest().log(Status.PASS,"Orijinal butonuna kliklendi ve metn orijinal veziyyetine qayitdi");
          }else {
               ExtentManager.getTest().log(Status.FAIL, "orijinal butonu gorsenmir");
               softAssert.fail("orijinal butonu gorsenmir");
          }

     }

     @And("The create new button is clicked")
     public void the_create_new_button_is_clicked()throws InterruptedException {
          boolean isVisible = createPage.isCreateNewButtonVisible();
          softAssert.assertTrue(isVisible, "Create new butonu gorsenmir");
          createPage.clickCreateNewButton();
          Thread.sleep(10000);
          if (isVisible) {
               ExtentManager.getTest().log(Status.PASS, "Create new butonu kliklendi ve yeni senario yaradildi");
          } else{
               ExtentManager.getTest().log(Status.FAIL, "Create new button gorsenmir");
          softAssert.fail("Create new button gorsenmir");
     }

     }








































































































































}
