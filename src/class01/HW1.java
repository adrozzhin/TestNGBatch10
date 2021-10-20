package class01;

/*
Executing different test based TestNG annotations
Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation
Observe the results!
 */

import org.testng.annotations.*;

public class HW1 {

    @BeforeClass
    public void beforeClassAnnotation() {
        System.out.println("It will be executed before class");
    }

    @AfterClass
    public void afterClassAnnotation() {
        System.out.println("It will be executed after class");
    }

    @BeforeMethod
    public void beforeMethodAnnotation() {
        System.out.println("It will be executed before each method");
    }

    @AfterMethod
    public void afterMethodAnnotation() {
        System.out.println("It will be executed after each method");
    }

    @Test
    public void test1() {
        System.out.println("This is a first test");
    }

    @Test
    public void test2() {
        System.out.println("This is a second test");
    }

}
