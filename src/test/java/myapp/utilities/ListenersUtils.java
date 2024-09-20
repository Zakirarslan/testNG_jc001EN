package myapp.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenersUtils implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
        System.out.println("onStart: executes only ONCE BEFORE ALL test cases. @Test: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
       // ITestListener.super.onFinish(context);
        System.out.println("onFinish: executes only ONCE AFTER ALL test cases. @Test: " + context.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
       // ITestListener.super.onTestFailure(result);
        System.out.println("onTestFailure: executes ONLY for FAILED test case. @Test: " + result.getName());

        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // ITestListener.super.onTestSuccess(result);
        System.out.println("onTestSuccess: executes for EACH successful test cases. @Test: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        System.out.println("onTestSkipped: executes for EACH SKIPPED test cases. @Test: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        System.out.println("onTestStart: executes for BEFORE EACH test cases. @Test: " + result.getName());
    }

//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//      //  ITestListener.super.onTestFailedWithTimeout(result);
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//       // ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }
}
