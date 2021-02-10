package converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EnglishToMetricConverterTester {

    @Test
    public void testFreezingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double freezingF = 32.0;
        final double freezingC = 0.0;
        assertEquals(e.convertTemperature(freezingF), freezingC, 0.0001);        
    }

    @Test
    public void testBoilingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double boilingF = 212.0;
        final double boilingC = 100.0;
        assertEquals(e.convertTemperature(boilingF), boilingC, 0.0001);        
    }
    
    @Test
    public void test40CTo40F() {
        EnglishToMetricConverter newTemp = new EnglishToMetricConverter();
        final double TempC = -40;
        final double TempF = -40;
        assertEquals(newTemp.convertTemperature(TempF), TempC, 0.0001);        
    }
    
    @Test
    public void testMilesToKM() {
        EnglishToMetricConverter newDistance = new EnglishToMetricConverter();
        final double miles = 1.0;
        final double Km = 1.609;
        assertEquals(newDistance.convertDistance(miles), Km, 0.0001);        
    }
    
    @Test
    public void test2MilesToKM() {
        EnglishToMetricConverter newDistance = new EnglishToMetricConverter();
        final double miles = 2.0;
        final double Km = 3.218;
        assertEquals(newDistance.convertDistance(miles), Km, 0.0001);        
    }
    
    @Test
    public void testPoundsToKG() {
        EnglishToMetricConverter newWeight = new EnglishToMetricConverter();
        final double pounds= 2.2;
        final double Kg = 1.0;
        assertEquals(newWeight.convertWeight(pounds), Kg, 0.0001);        
    }
    
    @Test
    public void testNewPoundsToKG() {
        EnglishToMetricConverter newWeight = new EnglishToMetricConverter();
        final double pounds= 4.4;
        final double Kg = 2.0;
        assertEquals(newWeight.convertWeight(pounds), Kg, 0.0001);        
    }
    
    
    /* add another test to verify that your converter shows the value -40 C for the input -40 F*/

    /* add at least two tests to verify that miles to KM conversion is correct.  Test several values, but one of them should
      test with the input value 1 mile. */
    
    /* add at least two tests to verify that pounds to KG conversion is correct.  test several values, but one of them should     use the    input value 2.2 pounds. */
    

 

}
