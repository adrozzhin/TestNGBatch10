package class02HW;

/*
TC 1: HRMS Add Employee:
Open chrome browser
Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Add a picture to the profile
Verify Employee has been added successfully
Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HW {

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
        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @Test(priority = 1, enabled = true)
    public void addEmployeeCall() {
        WebElement pimButton = driver.findElement(By.xpath("//a[@id = 'menu_pim_viewPimModule']"));
        pimButton.click();
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();
        WebElement addHeader = driver.findElement(By.xpath("//h1[text() = 'Add Employee']"));
        Assert.assertTrue(addHeader.isDisplayed());
    }

    @Test(priority = 2, enabled = true)
        public void addEmployeePage() {
        WebElement fullName = driver.findElement(By.xpath("//label[text() = 'Full Name']"));
        WebElement empID = driver.findElement(By.xpath("//label[text() = 'Employee Id']"));
        WebElement photo = driver.findElement(By.xpath("//label[text() = 'Photograph']"));
        Assert.assertTrue(fullName.isDisplayed());
        Assert.assertTrue(empID.isDisplayed());
        Assert.assertTrue(photo.isDisplayed());
    }
    @Test(priority = 3, enabled = true)
    public void addEmployeeAction() {
        String firstName = "John";
        String lastName = "Whoisit";
        String picturePath = "C:\\Users\\drozz\\Pictures\\picture234345464564565.jpg";
        WebElement firstNameTB = driver.findElement(By.id("firstName"));
        firstNameTB.sendKeys(firstName);
        WebElement lastNameTB = driver.findElement(By.id("lastName"));
        lastNameTB.sendKeys(lastName);
        WebElement photoDownloadButton = driver.findElement(By.id("photofile"));
        photoDownloadButton.sendKeys(picturePath);
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
        WebElement firstNameCreated = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement lastNameCreated = driver.findElement(By.id("personal_txtEmpLastName"));
        Assert.assertEquals(firstNameCreated.getAttribute("value"), firstName, "First names are NOT equal");
        Assert.assertEquals(lastNameCreated.getAttribute("value"), lastName, "Last names are NOT equal");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
