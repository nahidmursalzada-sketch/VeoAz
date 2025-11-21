package config;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {


    private static ExtentReports extent;


    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

            spark.config().setDocumentTitle(" veo.az Test Result");
            spark.config().setReportName("veo.az Regression Test Suite");
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Tester", "Nahid Mursalzada");
            extent.setSystemInfo("Environment", "Production");
            extent.setSystemInfo("Execution Time", java.time.LocalTime.now().toString());

        }
        return extent;
    }

    public static synchronized void createParentTest(String featureName) {
        ExtentTest extentTest = getExtentReports().createTest(featureName);
        parentTest.set(extentTest);
    }

    public static synchronized void createTest(String scenarioName) {
        ExtentTest extentTest = parentTest.get().createNode(scenarioName);
        test.set(extentTest);
    }

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

}


