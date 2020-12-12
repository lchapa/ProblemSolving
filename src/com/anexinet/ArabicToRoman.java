package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ArabicToRoman implements Solution
{
    private static final int MAX = 3999;
    private static final int BASE = 10;
    private static final String THOUSANDS = "M";
    private static final String FIVEHUNDREDS = "D";
    private static final String HUNDREDS = "C";
    private static final String FIFTIES = "L";
    private static final String TENS = "X";
    private static final String FIVES = "V";
    private static final String UNITS = "I";
    
    
    /**
     * Generates string for Thousands Roman reprentation (M,MM,MMM)
     * 
     * @param thousands how many elements to be calculated
     * @return String representation to be added to main value
     */
    private String getThousands(int thousands) {
        return THOUSANDS.repeat(thousands);
    }

    /**
     * Generates string for Hundreds Roman reprentation (C,CC,CCC, ... CM)
     * 
     * @param hundreds how many elements to be calculated
     * @return String representation to be added to main value
     */
    private String getHundreds(int hundreds) {
        String value = "";
        if(hundreds >= 1 && hundreds <= 3) {
            value = HUNDREDS.repeat(hundreds);
        } else if(hundreds == 4) {
            value = HUNDREDS + FIVEHUNDREDS;
        } else if(hundreds == 5) {
            value = FIVEHUNDREDS;
        } else if(hundreds >= 6 && hundreds <= 8) {
            value = FIVEHUNDREDS + HUNDREDS.repeat(hundreds - 5);
        } else if(hundreds == 9) {
            value = HUNDREDS + THOUSANDS;
        }
        return value;
    }

    /**
     * Generates string for Tens Roman reprentation (X,XX, .. XC)
     * 
     * @param tens how many elements to be calculated
     * @return String representation to be added to main value
     */
    private String getTens(int tens) {
        String value = "";
        if(tens >= 1 && tens <= 3) {
            value = TENS.repeat(tens);
        } else if(tens == 4) {
            value = TENS + FIFTIES;
        } else if(tens == 5) {
            value = FIFTIES;
        } else if(tens >= 6 && tens <= 8) {
            value = FIFTIES + TENS.repeat(tens - 5);
        } else if(tens == 9) {
            value = TENS + HUNDREDS;
        }
        return value;
    }
    
    /**
     * Generates string for Units Roman reprentation (I,II, .. IV)
     * 
     * @param units how many elements to be calculated
     * @return String representation to be added to main value
     */
    private String getUnits(int units) {
        String value = "";
        if(units >= 1 && units <= 3) {
            value = UNITS.repeat(units);
        } else if(units == 4) {
            value = UNITS + FIVES;
        } else if(units == 5) {
            value = FIVES;
        } else if(units >= 6 && units <= 8) {
            value = FIVES + UNITS.repeat(units - 5);
        } else if(units == 9) {
            value = UNITS + TENS;
        }
        return value;
    }

    /**
     * Get a roman number equivalent to integer number
     * 
     * @param number to be transformed
     * @return String value of the Roman representation
     */
    private String getRomanNumeral(int number)
    {
        if(number > MAX || number < 1) {
            throw new IllegalArgumentException("Number out of range: " + number);
        }
        String value = "";
        
        //Iterates over each position Units, Tens, Hundreds, Thousands with 10^ith pow
        int i = 3;        
        while(i >= 1) {
            int position = (int)Math.pow(BASE, i);
            int res = number / position;
            switch(i) {
                case 3: value += this.getThousands(res); break;
                case 2: value += this.getHundreds(res); break;
                case 1: 
                    value += this.getTens(res);
                    number -= res * 10;
                    value += this.getUnits(number);        
            }
            number -= res * position;
            i--;
        }
        return value;
    }

    
    @Override
    public void solve(String testCase) throws Exception
    {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { //read inst values and expected strings 
                int number = s.nextInt();
                String expected = s.nextLine();
                expected = expected.trim();
                try {
                    String value = this.getRomanNumeral(number);
                    
                    //If the gnerated string representation does not match expected value in the testcase
                    if(expected.compareTo(value) != 0) {
                        throw new AssertionError("TestCase not passed. Expected: " + expected + " actual: " + value);
                    }
                    System.out.printf("Number [%d] = [%s]\n", number, value);
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while(s.hasNextLine());
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage());
            throw e;
        }

    }
}
