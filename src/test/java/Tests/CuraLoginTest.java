package Tests;

import Config.BaseSetup;
import Pages.CuraHomePage;
import Pages.CuraLoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utils.Log;

public class CuraLoginTest extends BaseSetup{

    CuraHomePage curaHomePage;
    CuraLoginPage curaLoginPage;
//    ExtentTest test;
//    ExtentReports reports;

    @Test()
    public void loginTestBySideBar() throws InterruptedException {
        Log.info("Starting the 1st testcase: loginTestBySideBar");
//        test = reports.createTest("Login Test By Sidebar Navigation");
//        test.info("First Test Starts....");
        curaHomePage = new CuraHomePage(getDriver());
        curaLoginPage = new CuraLoginPage(getDriver());

        Thread.sleep(1000);
//        test.info("Navigating to Login Page");
        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);
        curaHomePage.clickOnLoginBtn();
        Thread.sleep(1000);

//        test.info("Adding Credentials");
        curaLoginPage.enterUserName("John Doe");
        curaLoginPage.enterPassword("ThisIsNotAPassword");
//        test.info("Click Login Btn");
        curaLoginPage.clickOnLogin();
        Thread.sleep(1000);

        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);
//        test.info("Verifying Login is successful or not");
        curaHomePage.clickOnLogoutBtn();
        Thread.sleep(1000);
//        test.info("Login Successful");
        Log.info("Testcase Successfully Executed");
//        test.pass("Test case of Login Passed");
    }

    @Test
    public void sampleTestMethod1(){
        System.out.println("Sample Test Method 1");
        Assert.assertTrue(true);
    }

    @Test
    public void sampleTestMethod2(){
        System.out.println("Sample Test Method 2");
        Assert.assertTrue(false);
    }

    @Test
    public void sampleTestMethod3(){
        System.out.println("Sample Test Method 3");
        throw new SkipException("Test Case Skipped");
    }
}
