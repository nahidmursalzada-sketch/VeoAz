package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Languageselect.feature",
        glue = {"stepDefinition","config"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/json/CucumberTestReportPositive.json",
                "html:target/cucumber-reports/html/CucumberTestReportPositive.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
        ,tags ="@LanguageSelect"
)
public class LanguageSelectRunner {
}
