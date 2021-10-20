package class2copied;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion2 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void  openBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(groups = {"smoke"})
    public void validLogin(){

        String titleExpected = "Human Resource Management System";
        String titleActual = driver.getTitle();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(titleActual, titleExpected);
        WebElement userName  = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        String text = welcomeAttribute.getText();
        soft.assertFalse(welcomeAttribute.isDisplayed());
        String expectedText = "Welcome Admin123";
        soft.assertEquals(text, expectedText);
        System.out.println("My statement after all the assertion");
        soft.assertAll();
    }

    @Test(groups = {"regression"})
    public void inValidLogin() {
        String titleExpected = "Human Resource Management System";
        String titleActual = driver.getTitle();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
