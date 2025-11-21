package pages;

import config.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    public JavascriptExecutor js;
    private String mainWindowHandle;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverManager.getChromeDriver();
        this.js = (JavascriptExecutor) driver;
        this.mainWindowHandle = driver.getWindowHandle();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    public void waitAndSendKeys(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(text);
        } catch (RuntimeException e) {
            System.out.println("Element tapılmadı və ya doldurula bilmədi: " + e.getMessage());
            throw e;
        }
    }

    public void fillFieldAndEnter(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }
    public void waitAndClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            try {
                element.click();
            } catch (ElementClickInterceptedException ex) {

                js.executeScript("arguments[0].click();", element);
            }
        } catch (RuntimeException e) {
            System.out.println("Element not found/clickable: " + e.getMessage());
            throw e;
        }
    }

    public void waitAndClickTwo(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            try {
                element.click();
                System.out.println("Normal klik uğurlu: " + locator);
            } catch (Exception e) {
                System.out.println("Normal klik alınmadı, JS click ilə sınayıram: " + e.getMessage());
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        } catch (TimeoutException te) {
            throw new RuntimeException("Element tapılmadı və ya kliklənə bilmir: " + locator, te);
        }
    }

    public void waitUntilAtLeastOne(By itemsLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(itemsLocator).size() > 0);
    }


    public void scrollToElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (Exception e) {
            throw e;
        }
    }

    public void switchToNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);  // Yeni pəncərəyə keçid
                return;
            }
        }
        throw new RuntimeException("Yeni sekme bulunamadı!");
    }

    public void switchToOriginalTab() {
        driver.switchTo().window(mainWindowHandle);  // Əsas pəncərəyə qayıt
    }


    public void closeNewTabAndReturn() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                return;
            }
        }
        throw new RuntimeException("Yeni sekme bulunamadı!");
    }


    public void scrollToBottom() {
        js.executeScript("window.scrollTo(20, document.body.scrollHeight);");
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }


    public void closeBrowser() {
        WebDriverManager.quitDriver();  //
    }

    public void switchToNewTabAndCloseOriginal() {
        String originalHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        if (allHandles.size() > 1) {
            for (String handle : allHandles) {
                if (!handle.equals(originalHandle)) {
                    driver.switchTo().window(handle);

                    driver.switchTo().window(originalHandle).close();

                    driver.switchTo().window(handle);
                    break;
                }
            }
        } else {
            System.out.println("Yeni tab tapılmadı!");
        }
    }

    public String waitAndGetText(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (RuntimeException e) {
            System.out.println("Element not found or not visible: " + e.getMessage());
            return null;
        }


    }

    public void doubleClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
        } catch (RuntimeException e) {
            System.out.println("Element double-click üçün tapılmadı: " + e.getMessage());
            throw e;
        }
    }


    public void switchToIframe(By iframeLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
            driver.switchTo().frame(iframe);
        } catch (RuntimeException e) {
            System.out.println("Iframe tapılmadı və ya keçid mümkün olmadı: " + e.getMessage());
            throw e;
        }
    }



    public void clickByXpath(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            element.click();
        } catch (RuntimeException e) {
            System.out.println("Element kliklənə bilmədi (xpath: " + xpath + "): " + e.getMessage());
            throw e;
        }

    }


    public void hoverOverElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (RuntimeException e) {
            System.out.println("Elementin üzərinə hover edilə bilmədi: " + e.getMessage());
            throw e;
        }
    }


    public void waitUntilVisible(WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (RuntimeException e) {
            System.out.println("Element gözlənilən vaxt ərzində görünmədi: " + e.getMessage());
            throw e;
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (RuntimeException e) {
            System.out.println("Element görünmür: " + e.getMessage());
            return false;
        }
    }

    public boolean waitForUrlChange(String oldUrl, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(d -> !d.getCurrentUrl().equals(oldUrl));
        } catch (RuntimeException e) {
            System.out.println("URL gözlənilən vaxt ərzində dəyişmədi. Köhnə URL: "
                    + oldUrl + " | Cari URL: " + driver.getCurrentUrl()
                    + " | Səbəb: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickableAndResultVisible(WebElement button, By expectedAfterClick) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(button));

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
            button.click();

            WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(expectedAfterClick));
            return resultElement.isDisplayed();
        } catch (RuntimeException e) {
            System.out.println("Element klik edilə bilmədi və ya nəticə görünmədi: " + e.getMessage());
            throw e;
        }
    }

    public boolean canEnterText(WebElement inputElement, String expectedText) {
        try {
            // Elementin görünməsini gözlə
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(inputElement));

            // Value ilə müqayisə et
            boolean isCorrect = inputElement.getAttribute("value").equals(expectedText);
            if (isCorrect) {
                System.out.println("Input sahəsinə daxil edilən mətn düzgün: " + expectedText);
            } else {
                System.out.println("Input sahəsinə daxil edilən mətn düzgün deyil. Gözlənilən: "
                        + expectedText + ", Daxil edilən: " + inputElement.getAttribute("value"));
            }
            return isCorrect;
        } catch (RuntimeException e) {
            System.out.println("Input sahəsinə yazmaq mümkün olmadı: " + e.getMessage());
            return false;
        }
    }

    public boolean canEnterTextBy(By locator, String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            boolean isCorrect = false;
            int attempts = 0;

            while(attempts < 5) { // 5 dəfə yoxla
                String actualValue = (String) js.executeScript("return arguments[0].value;", input);
                if(actualValue.equals(expectedText)){
                    isCorrect = true;
                    break;
                }
                Thread.sleep(50); // 50ms gözlə
                attempts++;
            }

            if (isCorrect) {
                System.out.println("Input sahəsinə daxil edilən mətn düzgün: " + expectedText);
            } else {
                System.out.println("Input sahəsinə daxil edilən mətn düzgün deyil. Gözlənilən: "
                        + expectedText + ", Daxil edilən: " + js.executeScript("return arguments[0].value;", input));
            }
            return isCorrect;

        } catch (Exception e) {
            System.out.println("Input sahəsinə yazmaq mümkün olmadı: " + e.getMessage());
            return false;
        }
    }


    public boolean isSearchSuccessful(By resultsLocator, String expectedKeyword) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsLocator));

            if (results.isEmpty()) {
                System.out.println("Axtarış nəticəsi tapılmadı!");
                return false;
            }

            // Nəticələrdə expectedKeyword olub-olmadığını yoxla
            boolean matchFound = results.stream()
                    .anyMatch(el -> el.getText().toLowerCase().contains(expectedKeyword.toLowerCase()));

            if (matchFound) {
                System.out.println("Axtarış uğurludur. Açar söz tapıldı: " + expectedKeyword);
            } else {
                System.out.println("Axtarış nəticələri var, amma açar söz tapılmadı: " + expectedKeyword);
            }

            return matchFound;

        } catch (RuntimeException e) {
            System.out.println("Axtarış zamanı xəta baş verdi: " + e.getMessage());
            return false;
        }
    }

    public boolean isClickSuccessful(WebElement clickableElement, By elementToAppear) {
        try {
            // Əvvəlcə elementə click et
            clickableElement.click();

            // Klikdən sonra gözlənilən elementin görünməsini gözlə
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement appearedElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(elementToAppear)
            );

            if (appearedElement.isDisplayed()) {
                System.out.println("Klik uğurludur. Element göründü: " + elementToAppear.toString());
                return true;
            } else {
                System.out.println("Klikdən sonra element görünmədi: " + elementToAppear.toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("Klik zamanı xəta baş verdi: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementVisibleBy(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public boolean isVideoPlaying(WebElement videoElement, int waitSeconds) {
        try {
            Long currentTimeBefore = (Long) js.executeScript(
                    "return Math.floor(arguments[0].currentTime);", videoElement);

            js.executeScript("arguments[0].play();", videoElement);
            Thread.sleep(waitSeconds * 1000);

            Long currentTimeAfter = (Long) js.executeScript(
                    "return Math.floor(arguments[0].currentTime);", videoElement);

            if (currentTimeBefore.equals(currentTimeAfter)) {
                System.out.println("BUG: Video oynadılmır, currentTime dəyişməyib!");
                return false;
            } else {
                System.out.println("Video normal oynayır. Start=" + currentTimeBefore + "s, End=" + currentTimeAfter + "s");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Video yoxlama zamanı xəta: " + e.getMessage());
            return false;
        }
    }



}

