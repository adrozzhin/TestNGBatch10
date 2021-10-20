package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo extends CommonMethods {
    //WebDriver driver;

    @org.testng.annotations.DataProvider
    public Object[][] loginData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "Admin";
        data[0][1] = "Hum@nhrm123";
        data[1][0] = "Michael12345";
        data[1][1] = "Hum@nhrm123";
        data[2][0] = "Admin";
        data[2][1] = "Hum@nhrm123";
        return data;
    }



    @Test(dataProvider = "loginData")
    public void validLogin() {
        driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
