package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixZero implements Solution
{
    private void displayMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("------------");
    }
    
    /**
     * Compare Matrix
     * @param m1
     * @param m2
     * @return boolean to indicate if they are equals or not
     */
    private boolean equals(int[][] m1, int[][] m2) {
        for(int i = 0; i < m1.length; i++) {
            if(!Arrays.equals(m1[i], m2[i])) {
                return false;
            }
        }        
        return true;
    }
    
    /**
     * Finds the row and column to be zeroed
     * 
     * @param matrix to look the zero valie
     * @return the matrix changed
     */
    private int[][] zeroed(int[][] matrix) {
        int m = 0, n = 0;
        ROWS: for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {  // Match the Zero in the Matrix
                    m = i;
                    n = j;
                    break ROWS;
                }
            }
        }
        
        //Make the change in the Row and Col found
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == m || j == n) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        return matrix;
    }
    
    
    @Override
    public void solve(String testCase) throws Exception
    {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { 
                int testcasesCount = s.nextInt(); //How many Testcase are in the file
                int count = 0;
                while(count++ < testcasesCount) {
                    int m = s.nextInt();  // Get rows
                    int n = s.nextInt();  // Get cols
                    
                    //Read Matrix
                    int[][] matrix = new int[m][n]; 
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < n; j++) {
                            matrix[i][j] = s.nextInt();
                        }                    
                    }
                    //Read the expected value to assert
                    s.nextLine();                                
                    int[][] expected = new int[m][n]; 
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < n; j++) {
                            expected[i][j] = s.nextInt();
                        }                    
                    }
                    
                    //Generate the Zeroed matrix
                    int[][] value = this.zeroed(matrix);
                    
                    //Compare to expected value
                    if(!this.equals(value, expected)) {
                        System.out.println("Expected: ");
                        this.displayMatrix(expected);
                        System.out.println("Value generated: ");
                        this.displayMatrix(value);
                        throw new AssertionError("TestCase not passed. Expected value");
                    }
                    System.out.println("Value generated: ");
                    this.displayMatrix(value);
                    s.nextLine();                                
                }                
            } while(s.hasNextLine());
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage());
            throw e;
        }

    }

}
