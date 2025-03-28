package Pages;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Listener;
import utils.Log;

public class CuraHomePage {
    WebDriver driver = null;
//    private static Logger logger = LogManager.getLogger(CuraHomePage.class);

    public CuraHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text() = 'Make Appointment']")
    public WebElement makeAppointmentBtn;

    @FindBy(xpath = "//a[@id='menu-toggle']")
    public WebElement hamburgerIcon;

    @FindBy(xpath = "//ul//li//a[text()= 'Login']")
    public WebElement loginBtnOnHamburger;

    @FindBy(xpath = "//ul//li//a[text()= 'Logout']")
    public WebElement logoutBtnOnHamburger;

//    By hamburgerIcon = By.xpath("//a[@id='menu-toggle']");
//    By loginBtnOnHamburger = By.xpath("//ul//li//a[text()= 'Login']");



    //Method Implementations

    public void clickOnMakeAppointmentBtn(){
        makeAppointmentBtn.click();
    }

    public void clickOnHamburgerIcon(){
 //       logger.info("Clicking on hamburger icon");
        Log.info("Clicking on hamburger icon");
        hamburgerIcon.click();
    }

    public void clickOnLoginBtn(){
 //       logger.info("Clicking on Login CTA");
        Log.info("Clicking on Login CTA");
        loginBtnOnHamburger.click();
    }

    public void clickOnLogoutBtn(){
 //       logger.info("Clicking on Logout CTA");
        Log.info("Clicking on Logout CTA");
        logoutBtnOnHamburger.click();
    }

}
