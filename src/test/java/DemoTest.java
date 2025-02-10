import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
        System.out.println("Trying to run my first demo test of selenium");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Mayur Mittal");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
    }
}
