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


