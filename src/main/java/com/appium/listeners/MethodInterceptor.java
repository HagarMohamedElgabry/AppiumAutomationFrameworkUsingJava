/*
 * IMethodInterceptor is used to alter/modify the list of test methods to be executed by TestNG. .
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.listeners;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class MethodInterceptor implements IMethodInterceptor {

	/*
	 *  Using intercept method we can reorder the list of test methods and return List of IMethodInstance which TestNG runs.
	 *  TestNG will now run these test methods in the same order which is found in the returned list.
	 */

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		System.out.println("----------------METHOD INTERCEPTOR--------------------------");
		System.out.println("methods: " + methods);
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		String testCategory = System.getProperty("testCategory");
		System.out.println("testCategory: " + testCategory);
		for (IMethodInstance method : methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			Set<String> groups = new HashSet<String>();
			for (String group : testMethod.groups()) {
				groups.add(group);
			}
			if (groups.contains(testCategory)) {
				result.add(method);
			}
		}
		if (testCategory == null) {
			System.out.println("Either You are not running the test execution from Maven"
					+ " command line or you are not giving the property -D=testCategory");
			return methods;
		} else {
			return result;
		}

	}
}
