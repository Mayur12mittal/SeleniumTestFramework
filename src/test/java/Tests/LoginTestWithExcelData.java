package Tests;

import Config.BaseSetup;
import Pages.CuraHomePage;
import Pages.CuraLoginPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;
import utils.Log;

import java.io.IOException;

public class LoginTestWithExcelData extends BaseSetup{

    CuraHomePage curaHomePage;
    CuraLoginPage curaLoginPage;

    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {

        String filePath = "src/test/java/TestData/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=1; i<rowCount; i++) {

            data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
            data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "LoginData")
    public void loginTestBySideBar(String username, String password) throws InterruptedException {
        Log.info("Starting the 1st testcase: loginTestBySideBar");
        curaHomePage = new CuraHomePage(getDriver());
        curaLoginPage = new CuraLoginPage(getDriver());

        Thread.sleep(1000);
        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);
        curaHomePage.clickOnLoginBtn();
        Thread.sleep(1000);

        curaLoginPage.enterUserName(username);
        curaLoginPage.enterPassword(password);

        curaLoginPage.clickOnLogin();
        Thread.sleep(1000);

        curaHomePage.clickOnHamburgerIcon();
        Thread.sleep(1000);

        curaHomePage.clickOnLogoutBtn();
        Thread.sleep(1000);

        Log.info("Testcase Successfully Executed");

    }
}
