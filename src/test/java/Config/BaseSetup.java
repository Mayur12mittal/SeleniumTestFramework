package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetup {
    public static WebDriver driver;

    @BeforeClass
    public void setupTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

    }

    public WebDriver getDriver(){
        return driver;
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
