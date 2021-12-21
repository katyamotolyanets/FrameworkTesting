package utils;

import com.epam.ta.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult result) { }

    public void onTestSuccess(ITestResult result) {
        log.info("Test " + result.getName() + " succeed");
        saveScreenshot("SUCCESS", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        log.error("Test " + result.getName() + " failed");
        saveScreenshot("FAILED", result.getName());
    }

    public void onTestSkipped(ITestResult result) { }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

    public void onStart(ITestContext context) { }

    public void onFinish(ITestContext context) { }

    private void saveScreenshot(String status, String testName) {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" + status + "_" + testName + "_" + getCurrentTimeAsString() + ".png"));
        }
        catch(IOException exception) {
            log.error("Failed to save screenshot: " + exception.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}