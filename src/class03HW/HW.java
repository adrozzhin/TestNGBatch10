package class03HW;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HW extends CommonMethods {

    /**
     * TC 1: HRMS Add Employee:
     * Open chrome browser
     * Go to HRMS
     * Login into the application
     * Add 5 different Employees and create login credentials by providing:
     * First Name
     * Last Name
     * Username
     * Password
     * Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
     * Close the browser
     * Specify group for this test case, add it into specific suite and execute from xml file.
     */

    @DataProvider
    public Object[][] addEmployeeData() {
        Object[][] data = {{"Bob", "Dylan", "Bobby867878567", "bobPass$83475984375389#$^&#$*"},
                {"Mike", "Doe", "Mikky9899766", "bobPass$83475984375389#$^&#$*"},
                {"Josh", "Pinewood", "woodymoody45432424567", "bobPass$83475984375389#$^&#$*"},
                {"Ellen", "Brown", "Pony79880978675", "bobPass$83475984375389#$^&#$*"},
                {"George", "Craft", "GeorgeIsMyName567879765", "bobPass$83475984375389#$^&#$*"}};

        return data;
    }

    @Test(dataProvider = "addEmployeeData", groups = "smoke")
    public void addEmployeesTest(Object firstName, Object lastName, Object userName, Object password) throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();
        WebElement addButton = driver.findElement(By.id("btnAdd"));
        addButton.click();

        String firstNameString = firstName.toString();
        String lastNameString = lastName.toString();
        WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
        firstNameTextBox.sendKeys(firstNameString);
        WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        lastNameTextBox.sendKeys(lastNameString);
        WebElement createLoginDetailsCheckBox = driver.findElement(By.cssSelector("input#chkLogin"));
        createLoginDetailsCheckBox.click();
        WebElement userNameCheckBox = driver.findElement(By.cssSelector("input#user_name"));
        userNameCheckBox.sendKeys(userName.toString());
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#user_password"));
        passwordTextBox.sendKeys(password.toString());
        WebElement confirmPasswordTextBox = driver.findElement(By.cssSelector("input#re_password"));
        confirmPasswordTextBox.sendKeys(password.toString());
        WebElement saveButton = driver.findElement(By.cssSelector("input#btnSave"));
        saveButton.click();
        Thread.sleep(3000);
        WebElement createdName = driver.findElement(By.xpath("//div[@id ='profile-pic']/h1"));
        String createdNameText = createdName.getText();

        Assert.assertEquals(createdNameText, firstNameString + " " + lastNameString, "Employee was not created");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE); // the screenshot is taken on this step

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/HWClass03/employee" + firstNameString + lastNameString + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
