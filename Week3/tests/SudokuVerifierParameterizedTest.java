import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(Parameterized.class)
public class SudokuVerifierParameterizedTest {
	//Voluntary - implement tests as Parameterized tests:
	
	//text tutorial: https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
	//video tutorial: https://www.youtube.com/watch?v=ryBetrexwt4
	
	
	//implement and document tests to test Sudokuverifier with boundary values. Use templates from Task 1 to derive and document test cases.
	
	// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	private SudokuVerifier verifier = new SudokuVerifier();
	private String testString;
	private int expectedResult;
	
	
	//collection of test data with inputs (testString) and expected results
	@Parameters
	   public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][] {
	         { "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0},
	         { "123456789912345678891234567789123456678912345567891234456789123345678912234567891", -2},
	         { "-123456789912345678891234567789123456678912345567891234456789123345678912234567891", -1},
	         { "417369824632158957958724316825437169791586432346912758289643571573291684164875293", -3},
	         { "417369825632158947859724316825437169791586432346912758289643571573291684164875293", -4},
	         { "123", -1},
	         {"017369825632158947958724316825437169791586432346912758289643571573291684164875293", -1},
	         {"417369825632158947958724316825437169791586#323!69127(8289643571573291684164875293", 1},
	         {"417369🏳0🌈️632158947958724316825437169791586432346912758289643571573291684164875293", -1},
	         {"4173698256321589479587243168254371697915864323469127582896435715732916841ヽ༼ຈل͜ຈ༽ﾉ ヽ༼ຈل͜ຈ༽ﾉ", -1}
	      });
	   }
	
	//test class constructor
	public SudokuVerifierParameterizedTest(String testString, int expectedResult) {
	      this.testString = testString;
	      this.expectedResult = expectedResult;
	   }
	
	
	@Test
	public void returnCorrect() {
		int returnNumber = verifier.verify(testString);
		assertEquals(returnNumber, expectedResult);
	}

}
