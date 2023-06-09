/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: 530cc974-87cb-4c65-a49d-53a7d7210e91
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
							/* expectedReturnValue = */ 0
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
pGigAAA==
END_CODEGEN_DATA
*/
