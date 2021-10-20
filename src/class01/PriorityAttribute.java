package class01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityAttribute {

    @Test (priority = 3)
    public void loginMethod() {
        System.out.println("I am login method");
    }

    @Test (priority = 1)
    public void launchBrowser() {
        System.out.println("I am launch browser");
    }

    @Test (priority = 2)
    public void navigateURL() {
        System.out.println("I am navigate URL");
    }
    @Test (priority = 4)
    public void closeBrowser() {
        System.out.println("I am close the browser");
    }
}
