package class1copied;

import org.testng.annotations.*;

public class PreConditionAndPostCondition {


    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method and will execute before every test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method and will execute after every test");
    }


    @Test
    public void firstMethod(){
        System.out.println("This is my first method");
    }

    @Test
    public void secondMethod(){
        System.out.println("This is my second method");
    }

    @Test
    public void thirdMethod(){
        System.out.println("This is my third method");
    }
}
