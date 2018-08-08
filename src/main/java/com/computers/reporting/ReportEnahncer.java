package com.computers.reporting;

import com.computers.support.annotations.TestCase;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportEnahncer implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

        TestCase testCase = iInvokedMethod.getTestMethod()
                .getConstructorOrMethod().getMethod()
                .getAnnotation(TestCase.class);
        if (testCase != null) {
            Reporter.log(testCase.testID());
            Reporter.log(testCase.testDesciption());
            Reporter.log(testCase.testPriority());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
