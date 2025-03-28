package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class CuraLoginPage {

    WebDriver driver = null;

    public CuraLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txt-username")
    public WebElement userNameInputField;

    @FindBy(id = "txt-password")
    public WebElement passwordInputField;

    @FindBy(id = "btn-login")
    public WebElement loginBtnOnLoginPage;

    //Method Implementations

    public void enterUserName(String id){
        Log.info("Entering Username");
        userNameInputField.sendKeys(id);
    }

    public void enterPassword(String pass){
        Log.info("Entering Password");
        passwordInputField.sendKeys(pass);
    }

    public void clickOnLogin(){
        Log.info("Click on Login Button");
        loginBtnOnLoginPage.click();
    }
}
