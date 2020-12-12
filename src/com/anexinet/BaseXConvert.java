package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BaseXConvert implements Solution
{
    
    @Override
    public void solve(String testCase) throws Exception
    {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { //read operands 
                int base = s.nextInt();
                long expectedValue =  s.nextInt();
                String number = s.nextLine();
                try {
                    number = number.trim();
                    long value = Converter.getConverter(base).valueOf(number);
                    System.out.printf("%s in Base %d = %d\n", number, base, value);
                    
                    if(expectedValue != value) {
                        throw new AssertionError("TestCase not passed. Expected value: " + expectedValue);
                    }
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

/**
 * Collection of BaseX supported, value and RegEx for validation
 * 
 * @author luis.chapa
 *
 */
enum BASE{
    BIN(2, "[01]+"),OCT(8, "[01234567]+"),HEX(16, "[0-9abcdef]+");
    int base;
    String regEx;
    BASE(int base, String regEx) {
        this.base = base;
        this.regEx = regEx;
    }
    public int getBase() {
        return base;
    }

    public String getRegEx() {
        return regEx;
    }
}

/**
 * Interface to make the strategy plan
 * 
 * @author luis.chapa
 *
 */
interface Converter{
    /**
     * Funtion to be implemented accordingly to the BASE in the number
     * 
     * @param number The number to be converted to BASE10
     * @return the Long value of the BASEX number
     */
    long valueOf(String number);
    
    /**
     * Factory of strategies
     * 
     * @param baseX The base in which is going to be obtained the value from
     * @return the specific Converter to that BASEX
     */
    public static Converter getConverter(int baseX) {
        Converter c = null;

        if(BASE.BIN.getBase() == baseX) {
            c = number -> {
                int base = BASE.BIN.getBase();
                if(!number.matches(BASE.BIN.getRegEx())) {
                    throw new IllegalArgumentException(String.format("Invalid digit in number Base(%d): %s", base, number));
                }
                int index = number.length();
                int pos = 0;
                long sum = 0;
                while(index > 0) {
                    char digitChar = number.charAt(--index);
                    int digit = Integer.valueOf(Integer.valueOf(Character.valueOf(digitChar).toString()));;
                    sum += digit * Math.pow(base, pos++);
                }
                return sum;                
            };
        } else if(BASE.OCT.getBase() == baseX) {
            c = number -> {
                int base = BASE.OCT.getBase();
                if(!number.matches(BASE.OCT.getRegEx())) {
                    throw new IllegalArgumentException(String.format("Invalid digit in number Base(%d): %s", base, number));
                }
                int index = number.length();
                int pos = 0;
                long sum = 0;
                while(index > 0) {
                    char digitChar = number.charAt(--index);
                    int digit = Integer.valueOf(Integer.valueOf(Character.valueOf(digitChar).toString()));
                    sum += digit * Math.pow(base, pos++);
                }
                return sum;                
                
            };
        } else if(BASE.HEX.getBase() == baseX) {
            c = number -> {
                int base = BASE.HEX.getBase();
                if(!number.matches(BASE.HEX.getRegEx())) {
                    throw new IllegalArgumentException(String.format("Invalid digit in number Base(%d): %s", base, number));
                }
                int index = number.length();
                int pos = 0;
                long sum = 0;
                while(index > 0) {
                    char digitChar = number.charAt(--index);
                    int digit = 0;
                    if (Character.isDigit(digitChar)) {
                        digit = Integer.valueOf(Integer.valueOf(Character.valueOf(digitChar).toString()));
                    } else {
                        switch(digitChar) {
                            case 'a': digit = 10; break;
                            case 'b': digit = 11; break;
                            case 'c': digit = 12; break;
                            case 'd': digit = 13; break;
                            case 'e': digit = 14; break;
                            case 'f': digit = 15; break;
                        }
                    }
                    sum += digit * Math.pow(base, pos++);
                }
                return sum;                
                
            };
        } else {
            throw new IllegalArgumentException(String.format("Invalid BaseX(%d): %s", baseX));
        }
        return c;
    }
}
