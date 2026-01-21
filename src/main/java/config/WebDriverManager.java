package config;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;
    private WebDriverManager(){}

    public static WebDriver getChromeDriver(){
        if (driver==null){
            ChromeOptions options=new ChromeOptions();

            options.addArguments("--disable-gpu");
            options.addArguments("--disable-notification");

            //CI ucun headless
            if ("true".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }


            driver=new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        return driver;

    }

    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }



}


