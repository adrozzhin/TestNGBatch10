package class01;

/*
TC 1: HRMS Application Login:
Open chrome browser
Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
Enter valid username and password
Click on login button
Then verify Syntax Logo is displayed
Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HW2 {

    public static WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 0, enabled = true)
    public void login() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Test(priority = 1, enabled = true)
    public void verifyLogo() {
        WebElement logo = driver.findElement(By.xpath
                ("//img[@src = '/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/themes/default/images/syntax.png']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is NOT displayed");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
