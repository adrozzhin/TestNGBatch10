package class03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Listener is starting test with the name: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Listener has passed the test and we are capturing the final screenshot");
    }

    public void onTestFailureButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Result");
    }

    public void onTestSkipped (ITestResult result) {
        System.out.println("Listener skipped test case is: " + result.getName());
    }

    public  void onTestFailure(ITestResult result) {
        System.out.println("Listener failed test case is: " + result.getName());
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
