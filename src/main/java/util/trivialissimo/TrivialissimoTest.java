/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: 4d7abe2a-a030-4272-9e28-62b33a7ac9ab
*/
package util.trivialissimo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
public class TrivialissimoTest {
	
//region Scenarios
	//A new scenario
	@ParameterizedTest(name = "{1} [{index}] {2}")
	@MethodSource({"Scenario1Source"})
	public void Scenario1Test(Scenario1TestData data, String TestName, String TestDescription) {
		ActualResultStorage.setStorage(); //saves the results of the called Methods
		
		assertion(data, data.S1M1.methodName, null, data.S1M1.expectedResult, data.S1M1.call());
	}
//endregion

//region Data

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	//A new scenario
	private static Stream<Arguments> Scenario1Source() {
		return Stream.of(
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* String value = */ "10",
						/* referencingMethodName = */ ""
						,
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXPECTED_VALUE,
							/* expectedReturnValue = */ 10
						)
					)
				),
				/* testCaseName = */ "p1",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* String value = */ "0",
						/* referencingMethodName = */ ""
						,
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ Exception.class
						)
					)
				),
				/* testCaseName = */ "n1",
				/* testCaseDescription = */ "M1:value: boundaries"
			),
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* String value = */ "ten",
						/* referencingMethodName = */ ""
						,
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ Exception.class
						)
					)
				),
				/* testCaseName = */ "n2",
				/* testCaseDescription = */ "M1:value: invalid"
			),
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* String value = */ "10.1",
						/* referencingMethodName = */ ""
						,
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ Exception.class
						)
					)
				),
				/* testCaseName = */ "n3",
				/* testCaseDescription = */ "M1:value: invalid"
			)
		);
	}
//endregion

//region Types

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	static class Scenario1TestData {
	    public final S1M1Parameters<Scenario1TestData> S1M1;
	    
	    public Scenario1TestData(S1M1Parameters<Scenario1TestData> S1M1) {
	    	this.S1M1 = S1M1;
	    }
	}

	static class S1M1Parameters<TestData> {
		public final String methodName = "S1M1";
	    public final ObjectWrapper<String> value;
	    public final Result<TestData, Object, Integer> expectedResult;
		public S1M1Parameters(String value, String referencingMethodName, Result<TestData, Object, Integer> expectedResult) {
			this.value = new ObjectWrapper<>(value, referencingMethodName);
	   		this.expectedResult = expectedResult;
	    }
	    
	    public ExceptionFunction<Object, Integer> call() {
	    	return i ->
	    	 util.trivialissimo.Trivialissimo.parsePositiveIntString(value.get());
		}
	}
//endregion

//region Utility Classes

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	public static class ObjectWrapper<T> {
		public T object;
		public String referencingMethodName;
		
		public ObjectWrapper(T object, String referencingMethodName) {
			this.object = object;
			this.referencingMethodName = referencingMethodName;
		}
		
		public T get() {
			return ActualResultStorage.getOrDefault(referencingMethodName, object);
		}
	}
	
	public static class ActualResultStorage {
		private static Map<String, Object> actualResultMap = new HashMap<>();
		
		public static void setStorage() {
			actualResultMap = new HashMap<>();
		}
		
		public static <T> void put(String key, T value) {
			actualResultMap.put(key, value);
		}
		
		@SuppressWarnings("unchecked")
		public static <T> T getOrDefault(String key, T defaultValue) {
			return (T) actualResultMap.getOrDefault(key, defaultValue);
		}
	}
	
	static class Result<TestData, TInstance, TReturn> {
		public final AssertType assertType;
		public final TReturn expectedReturnValue;
		public final Class<? extends Throwable> expectedException;
		public final BiConsumer<TInstance, TReturn> customAction;
		public final List<SideEffect<TestData>> sideEffects;
		
		public Result(AssertType assertType) {
			this(assertType, (TReturn) null, null);
		}
	
		public Result(AssertType assertType, List<SideEffect<TestData>> sideEffects) {
			this(assertType, (TReturn) null, sideEffects);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue) {
			this(assertType, expectedReturnValue, null);
		}
	
		public Result(AssertType assertType, Class<? extends Throwable> expectedException) {
			this(assertType, expectedException, null);
		}
	
		public Result(AssertType assertType, BiConsumer<TInstance, TReturn> customAction) {
			this(assertType, customAction, null);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue, List<SideEffect<TestData>> sideEffects) {
			this(assertType, expectedReturnValue, null, null, sideEffects);
		}
	
		public Result(AssertType assertType, Class<? extends Throwable> expectedException, List<SideEffect<TestData>> sideEffects) {
			this(assertType, null, expectedException, null, sideEffects);
		}
	
		public Result(AssertType assertType, BiConsumer<TInstance, TReturn> customAction, List<SideEffect<TestData>> sideEffects) {
			this(assertType, null, null, customAction, sideEffects);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue, Class<? extends Throwable> expectedException,
			BiConsumer<TInstance, TReturn> customAction, List<SideEffect<TestData>> sideEffects) {
			this.assertType = assertType;
			this.expectedReturnValue = expectedReturnValue;
			this.expectedException = expectedException;
			this.customAction = customAction;
			this.sideEffects = sideEffects;
		}
	}
	
	static class SideEffect<TestData> {
	    public final Object expectedValue;
	    public final Function<TestData, Object> actualValueAccessor;
	    
		public SideEffect(Object expectedValue, Function<TestData, Object> actualValueAccessor) {
			this.expectedValue = expectedValue;
			this.actualValueAccessor = actualValueAccessor;
		}
	}
	
	public enum AssertType {
	    EXCEPTION, EXPECTED_VALUE, CUSTOM_ASSERTION
	}
	
	static class VoidR {
	}
	
	private static <I> ExceptionFunction<I, VoidR> asFunc(ExceptionConsumer<I> action) {
		return i -> {
			action.accept(i);
			return null;
		};
	}
	
	@FunctionalInterface
	public interface ExceptionFunction<I, R> {
		R apply(I i) throws Exception;
	}
	
	@FunctionalInterface
	public interface ExceptionConsumer<I> {
		void accept(I i) throws Exception;
	}
	
	private <TestData, I, R> void assertion(TestData data, String methodName, I instance, Result<TestData, I, R> expectedResult, ExceptionFunction<I, R> toApply) {
		if (expectedResult == null) {
			ActualResultStorage.put(methodName, assertDoesNotThrow(() -> toApply.apply(instance)));
			return;
		}
		R actualResult = null;
		if (expectedResult.assertType.equals(AssertType.EXCEPTION)) {
			assertThrows(expectedResult.expectedException, () -> toApply.apply(instance));
		} else {
			actualResult = assertDoesNotThrow(() -> toApply.apply(instance));
			if (expectedResult.assertType.equals(AssertType.EXPECTED_VALUE) &&
					!(expectedResult.expectedReturnValue instanceof VoidR)) {
				assertEquals(expectedResult.expectedReturnValue, actualResult);
			} else if (expectedResult.assertType.equals(AssertType.CUSTOM_ASSERTION)) {
				expectedResult.customAction.accept(instance, actualResult);
			}
			if (expectedResult.sideEffects != null) {
				for (var sideEffect : expectedResult.sideEffects) {
					var sideEffectResult = sideEffect.actualValueAccessor.apply(data);
					assertEquals(sideEffect.expectedValue, sideEffectResult);
				}
			}
		}
		ActualResultStorage.put(methodName, actualResult);
	}
//endregion
}

/*
WARNING: Modification of this comment will make it impossible to merge user-defined changes

BEGIN_CODEGEN_DATA
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
XrZK6Lr16ieY/Plf18mRBFkmAAA=
END_CODEGEN_DATA
*/
