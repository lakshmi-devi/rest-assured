package tests.e2e.apiInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;

import tests.e2e.helper.DataSourceHelper;

public class ManufactonListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);

		if (testMethod != null && (testMethod.getName().contains("createPrefab") || 
				testMethod.getName().contains("createCoordination") || 
				testMethod.getName().contains("createDetailing") || 
				testMethod.getName().contains("createManufacturing") || 
				testMethod.getName().contains("createOrderingCard") ||
				testMethod.getName().contains("createRequestingMaterial"))) {
			annotation.setInvocationCount(DataSourceHelper.invocationCount);
		}
	}
}
