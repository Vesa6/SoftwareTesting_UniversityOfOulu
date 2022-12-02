import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String longString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i2 = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String i1 = "-123456789912345678891234567789123456678912345567891234456789123345678912234567891";
//Incorrect rows
String i3 = "417369824632158957958724316825437169791586432346912758289643571573291684164875293";
//Incorrect columns
String i4 = "417369825632158947859724316825437169791586432346912758289643571573291684164875293";
String iShort = "123";
String i0 = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
String numberFormatException = "417369825632158947958724316825437169791586#323!69127(8289643571573291684164875293";
String Sunicode = "417369🏳0🌈️632158947958724316825437169791586432346912758289643571573291684164875293";
String Sunicode2 = "4173698256321589479587243168254371697915864323469127582896435715732916841ヽ༼ຈل͜ຈ༽ﾉ ヽ༼ຈل͜ຈ༽ﾉ";
String seventeen = "41736982563215894";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString_R2() {
		int a = v.verify(i2);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testIncorrectString_R1( ) {
		int a = v.verify(i1);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testIncorrectString_R3() {
		int a = v.verify(i3);
		assertEquals("incorrect string", a, -3);
	}
	
	@Test
	public void testIncorrectString_R4() {
		int a = v.verify(i4);
		assertEquals("incorrect string", a, -4);
	}
	
	@Test
	public void testShortString() {
		int a = v.verify(iShort);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testFormatException() {
		//This causes an exception.
		int a = v.verify(numberFormatException);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testMain() {
		SudokuVerifier.main(null);
	}
	
	@Test
	public void testZero() {
		int a = v.verify(i0);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testSpecialUnicode() {
		int a = v.verify(Sunicode);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testSpecialUnicode2() {
		int a = v.verify(Sunicode2);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void tooLongString() {
		int a = v.verify(longString);
		assertEquals("incorrect string", a, -1);
	}
	
	
}
