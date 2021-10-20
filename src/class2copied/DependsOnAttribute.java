package class2copied;

import org.testng.annotations.Test;

public class DependsOnAttribute {


    @Test
    public void login(){
        System.out.println("this is my login page");
    }

    @Test(dependsOnMethods = "login")
    public void verifyDashboardPage(){
        System.out.println("this is my dashboard page");
    }

    @Test(dependsOnMethods = {"login", "verifyDashboardPage"})
    public void verifyLogout(){
        System.out.println("This is my logout page");
    }
}
