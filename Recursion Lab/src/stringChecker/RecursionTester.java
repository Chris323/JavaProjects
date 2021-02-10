package stringChecker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursionTester {

	   @Test
	    public void testStringCount() {
	        RecursionMethods newTest = new RecursionMethods();
	        final String stringInput = "helloworld";
	        final int answer = 10;
	        assertEquals(newTest.charCount(stringInput), answer, 0.0001);        
	    }
	   
	   @Test
	    public void testStringCount2() {
	        RecursionMethods newTest = new RecursionMethods();
	        final String stringInput = "";
	        final int answer = 0;
	        assertEquals(newTest.charCount(stringInput), answer, 0.0001);        
	    }
	   
//	   @Test
//	    public void testReversedString() {
//	        RecursionMethods newTest = new RecursionMethods();
//	        final String stringInput = "";
//	        final String answer = "";
//	        assertEquals(newTest.charCount(stringInput), answer, 0.0001);        
//	    }
//	   
//	   @Test
//	    public void testReversedString2() {
//	        RecursionMethods newTest = new RecursionMethods();
//	        final String stringInput = "hello";
//	        final String answer = "olleh";
//	        assertEquals(newTest.charCount(stringInput), answer, 0.0001);        
//	    }
}
