package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
}
