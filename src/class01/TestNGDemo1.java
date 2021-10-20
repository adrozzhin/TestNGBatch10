package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am before method and will execute before every test");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("I am after method and will execute after each method");
    }

    @Test()
    public void testMethod() {
        System.out.println("This is my first method");
    }
    @Test()
    public void anotherMethod() {
        System.out.println("Another method in a class");
    }
}
