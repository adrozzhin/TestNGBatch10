package class1copied;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableAndDisableAttribute {

    WebDriver driver;

    @BeforeMethod
    public void  openBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void validateDashboardPage(){
        System.out.println("verifying the dashboard page");
    }

    @Test(enabled = false)
    public void validateLogo(){
        System.out.println("verifying the logo");
    }

    @Test(enabled = true, priority = 2)
    public void validateLogout(){
        System.out.println("verifying the logout");
    }

    @Test(priority = 1, enabled = true)
    public void validLogin(){
        WebElement userName  = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test case is valid and passed");
        }else{
            System.out.println("Test case is invalid and failed");
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
