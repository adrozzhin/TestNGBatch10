package class01;

/*
HRMS Application Negative Login:
Open chrome browser
Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW3 {

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
    public void incompletelogin() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Test(priority = 1, enabled = true)
    public void verifyErrorMessage() {
        WebElement errormsg = driver.findElement(By.xpath("//span[@id = 'spanMessage']"));
        String expectedMessageText = "Password cannot be empty";
        String actualMessageText = errormsg.getText();
        Assert.assertEquals(actualMessageText, expectedMessageText, "Error message text is incorrect");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
