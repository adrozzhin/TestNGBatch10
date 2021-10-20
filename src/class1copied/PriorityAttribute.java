package class1copied;

import org.testng.annotations.Test;

public class PriorityAttribute {

    @Test(groups = "smoke")
    public void loginMethod(){
        System.out.println("I am login method");
    }

    @Test(groups = "smoke")
    public void launchBrowserMethod(){
        System.out.println("I am launch browser");
    }

    @Test(groups = "smoke")
    public void navigateUrl(){
        System.out.println("I am navigate url");
    }

    @Test(groups = "smoke")
    public void closeBrowser(){
        System.out.println("I am close browser method");
    }
}
