/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: 05418ee3-529f-45ba-a1f6-fb04adc769ea
*/
package util.chaining;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.chaining.Chain.multiplyPositiveByTen;

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
public class ChainTest {
	
//region Scenarios
	//A new scenario
	@ParameterizedTest(name = "{1} [{index}] {2}")
	@MethodSource({"Scenario1Source"})
	public void Scenario1Test(Scenario1TestData data, String TestName, String TestDescription) {
		ActualResultStorage.setStorage(); //saves the results of the called Methods
		
		assertion(data, data.S1M1.methodName, null, data.S1M1.expectedResult, data.S1M1.call());
		
		assertion(data, data.S1M2.methodName, null, data.S1M2.expectedResult, data.S1M2.call());
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
						/* Integer input = */ 3,
						/* referencingMethodName = */ "",
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXPECTED_VALUE,
							/* expectedReturnValue = */ 30
						)
					),
					/* S1M2 = */ new S1M2Parameters<>(
						/* Integer input = */ 0,
						/* referencingMethodName = */ "S1M1",
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXPECTED_VALUE,
							/* expectedReturnValue = */ 300
						)
					)
				),
				/* testCaseName = */ "p1",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* Integer input = */ 0,
						/* referencingMethodName = */ "",
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ Exception.class
						)
					),
					/* S1M2 = */ new S1M2Parameters<>(
						/* Integer input = */ 0,
						/* referencingMethodName = */ "S1M1",
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ Exception.class
						)
					)
				),
				/* testCaseName = */ "n1",
				/* testCaseDescription = */ "M1:input: invalid"
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
	    public final S1M2Parameters<Scenario1TestData> S1M2;
	    
	    public Scenario1TestData(S1M1Parameters<Scenario1TestData> S1M1, S1M2Parameters<Scenario1TestData> S1M2) {
	    	this.S1M1 = S1M1;
	    	this.S1M2 = S1M2;
	    }
	}

	static class S1M1Parameters<TestData> {
		public final String methodName = "S1M1";
	    public final ObjectWrapper<Integer> input;
	    public final Result<TestData, Object, Integer> expectedResult;
		public S1M1Parameters(Integer input, String referencingMethodName, Result<TestData, Object, Integer> expectedResult) {
			this.input = new ObjectWrapper<>(input, referencingMethodName);
	   		this.expectedResult = expectedResult;
	    }
	    
	    public ExceptionFunction<Object, Integer> call() {
	    	return i ->
	    	 multiplyPositiveByTen(input.get());
		}
	}
		
	static class S1M2Parameters<TestData> {
		public final String methodName = "S1M2";
	    public final ObjectWrapper<Integer> input;
	    public final Result<TestData, Object, Integer> expectedResult;
		public S1M2Parameters(Integer input, String referencingMethodName, Result<TestData, Object, Integer> expectedResult) {
			this.input = new ObjectWrapper<>(input, referencingMethodName);
	   		this.expectedResult = expectedResult;
	    }
	    
	    public ExceptionFunction<Object, Integer> call() {
	    	return i ->
	    	 multiplyPositiveByTen(input.get());
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
bKAAA
END_CODEGEN_DATA
*/