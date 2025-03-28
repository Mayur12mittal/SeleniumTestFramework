package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentReport {
    ExtentSparkReporter sparkReporter;
    ExtentReports reports;

    public void setupReport(){
        sparkReporter = new ExtentSparkReporter("target/Report/extentreport.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        reports.setSystemInfo("OS","Windows");
        reports.setSystemInfo("IDE","IntelliJ");
        reports.setSystemInfo("Device","Desktop");
        reports.setSystemInfo("User","Mayur Mittal");

        sparkReporter.config().setDocumentTitle("Extent Listener Report");
        sparkReporter.config().setReportName("CURA Healthcare Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
    }

    public void flushReport(){
        reports.flush();
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path= System.getProperty("user.dir")+"/target/Screenshots/"+screenshotName+".png";
            System.out.println("Path for screenshot is : "+path);
            FileUtils.copyFile(src, new File(path));
            return path;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
