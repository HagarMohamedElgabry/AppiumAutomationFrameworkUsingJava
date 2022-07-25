
/*
  * IAnnotationTransformer transforms the TestNG annotations at run time.
  * A scenario may appear in which the user seeks to override the content of the annotation based on a condition.
  * In such a case it is not necessary to make changes in the source code.
  * Simply use IAnnotationTransformer to override the content of the annotations.
  * IAnnotationTransformer has only one method named transform() that accepts four parameters:
  *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.listeners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	// transform method will be invoked by TestNG to give you a chance to modify a TestNG annotation read from your test classes.
	//  Note that only one of the three parameters testClass, testConstructor and testMethod will be non-null.
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryFailedTests.class);

	}
}
