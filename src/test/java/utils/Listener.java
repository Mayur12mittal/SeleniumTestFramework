package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener extends ExtentReport implements ITestListener {
    public static ExtentTest test;

    @Override
    public void onFinish(ITestContext arg0) {
        flushReport();
        System.out.println("Test Execution Completed Successfully");
    }

    @Override
    public void onStart(ITestContext arg0) {
        setupReport();
        System.out.println("Test Execution Started...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " Failed...");
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Failed test case: "+result.getName(), ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " Skipped...");
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Skipped test case: "+result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " Passed...");
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Passed test case: "+result.getName(), ExtentColor.GREEN));
    }

}
