package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        ConfigReader.readProperties("C:\\Users\\drozz\\IdeaProjects\\TestNGBatch10\\src\\config\\config.properties");
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("browser not found");
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
            driver.get(ConfigReader.getPropertyValue("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }

}
