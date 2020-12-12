package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


/**
 * Problem 1: Write a function that adds two numbers without using any arithmetic operators.
 * Solution: Each integer number is going to be decomposed accordingly to position and the BASE = 10
 * then added 1 by 1. As it the addition was made by hand.
 * 
 * @author luis.chapa
 *
 */
public class Addition implements Solution
{
    private static final byte BASE = 10;
    
    /**
     * Recursive function that takes operands to be decomposed and added each position at a time.
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @param p Position - starting Zero (Units) then One (Tens) then Two (Hundreds) and so on.
     * @param sum Accumulated sum.
     * @return sum for previous call.
     */
    private int decompose(int x, int y, int p, int sum) {
        if(x / (int)Math.pow(BASE, p) > 0 ||
                y / (int)Math.pow(BASE, p) > 0) {     
            int resX = x % (int)Math.pow(BASE, p + 1);
            int resY = y % (int)Math.pow(BASE, p + 1);
            
            // add both modulus for position p + next call
            return sum = resX + resY + this.decompose(x - resX, y - resY, p + 1, sum);
        }
        // No more positions to the left for both operands, then return recursion.
        return 0;
    }
    
    @Override
    public void solve(String testCase) throws Exception {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { //read operands line by line in the file
                int x = s.nextInt();
                int y = s.nextInt();
                
                int sum = 0;
                sum = this.decompose(x, y, 0, sum); //Calculates with alternative algorithm
                System.out.printf("%d + %d = %d \n", x, y, sum);
                
                if(sum != (x + y)) { //Verifies against normal operator (+)
                    throw new AssertionError("TestCase not passed. Expected value: " + (x + y));
                }
                s.nextLine();
            } while(s.hasNextLine());
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage()); 
            throw e;
        }
    } 
}
