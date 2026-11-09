
package fileupload.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // Site under test
    protected static final String SITE_URL = "https://gofile.io";

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get(SITE_URL);
    }

    // Browser selection: chrome, edge or firefox
    private WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException(
                    "Unknown browser: " + browser
                    + " (use chrome, edge or firefox)"
                );
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver == null) {
            return;
        }

        // Print test result and current page
        String status = result.isSuccess() ? "passed" : "failed";

        System.out.println(
            result.getName() + " " + status
            + " - page: " + driver.getCurrentUrl()
        );

        // Save screenshot
        saveScreenshot(result.getName() + "-" + status);

        // Keep browser open so the upload result can be viewed
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Close browser after 15 seconds
        driver.quit();
        driver = null;
    }

    private void saveScreenshot(String testName) {
        try {
            File shot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path folder = Paths.get("target", "screenshots");
            Files.createDirectories(folder);

            Path target = folder.resolve(testName + ".png");

            Files.copy(
                shot.toPath(),
                target,
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                "Screenshot saved: " + target.toAbsolutePath()
            );

        } catch (IOException e) {
            System.out.println(
                "Could not save screenshot: " + e.getMessage()
            );
        }
    }
}
