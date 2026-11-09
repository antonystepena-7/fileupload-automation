package fileupload.pages;

import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // the page has a single file input
    private final By fileInput = By.cssSelector("input[type='file']");

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void uploadFiles(List<Path> files) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));

        // several files go in one string, separated by a new line
        List<String> paths = new ArrayList<>();
        for (Path file : files) {
            paths.add(file.toAbsolutePath().toString());
        }
        input.sendKeys(String.join("\n", paths));
    }

    // waits up to 60 seconds for the file name to show up on the page
    public boolean isFileListed(String fileName) {
        By nameOnPage = By.xpath("//*[contains(text(), '" + fileName + "')]");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOfElementLocated(nameOnPage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
