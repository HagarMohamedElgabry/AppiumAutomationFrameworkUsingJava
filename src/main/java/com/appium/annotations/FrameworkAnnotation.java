/**
 *
 * Framework annotation are indicate a default value expression for the field or parameter to initialize the property with like
 * . @CategoryType. annotation tells Spring to inject object into another when it loads your application context and you can also use. @Value.
 * This is an Custom Annotation
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.appium.enums.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {
	public CategoryType[] category();  // public String[] category();
	public SeverityLevel[] severity(); // public String[] severity();

}
