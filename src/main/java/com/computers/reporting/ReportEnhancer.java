package com.computers.reporting;

import com.computers.support.annotations.TestCase;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportEnhancer implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

        TestCase testCase = iInvokedMethod.getTestMethod()
                .getConstructorOrMethod().getMethod()
                .getAnnotation(TestCase.class);
        if (testCase != null) {
            Reporter.log("<h2> Test ID :"+testCase.id()+"</h2>");
            Reporter.log("<h2> Description: "+testCase.desciption()+"</h2>");
            Reporter.log("<h2> Priority: "+testCase.priority().toString()+"</h2>");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
