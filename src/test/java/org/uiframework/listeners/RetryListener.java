package org.uiframework.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    //ITestAnnotation = "controls @Test behavior dynamically"
    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {

        // Attach RetryAnalyzer to every test
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}