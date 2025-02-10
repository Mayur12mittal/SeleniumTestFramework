package Tests;

import Config.BaseSetup;
import Pages.CuraHomePage;
import Pages.CuraLoginPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class CuraLoginTest extends BaseSetup{

    CuraHomePage curaHomePage;
    CuraLoginPage curaLoginPage;

    @Test()
    public void loginTestBySideBar() throws InterruptedException {
        curaHomePage = new CuraHomePage(getDriver());
        curaLoginPage = new CuraLoginPage(getDriver());

        Thread.sleep(1000);
        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);
        curaHomePage.clickOnLoginBtn();
        Thread.sleep(1000);

        curaLoginPage.enterUserName("John Doe");
        curaLoginPage.enterPassword("ThisIsNotAPassword");
        curaLoginPage.clickOnLogin();
        Thread.sleep(1000);

        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);
        curaHomePage.clickOnLogoutBtn();
        Thread.sleep(1000);
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
