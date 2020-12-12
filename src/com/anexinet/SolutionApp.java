package com.anexinet;

import com.anexinet.util.MatrixToTestcase;

public class SolutionApp
{

    public static void main(String[] args) throws Exception
    {
        /**
         * 1.- Write a function that adds two numbers without using any arithmetic operators.
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 1 - Alternative addition");
            
            Solution s = new Addition();
            s.solve("testcases/Addition.test");
        } catch(Exception e){
            System.out.println("Problem 1 FAILED!." + e.getMessage());
            throw e;
        }
        
        /**
         * 2.- Given 2 strings of unknown characters (but it cannot be repeated) create a function that returns an 
         * array of the characters that are repeated in both strings inthe most efficient way.
         * 
         * Assumption: No repeated characters in the same string. Find the repeated characters in one another.
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 2 - Set intersection");
            
            Solution s = new CharSet();
            s.solve("testcases/CharSet.test");
        } catch(Exception e){
            System.out.println("Problem 2 FAILED!." + e.getMessage());
            throw e;
        }

        /**
         * 3.- Write a function that takes a string containing a number in base X along with an integer of the base X. 
         * The function must return the integer value of that string/base pair.
         * 
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 3 - BaseX to Base10 convertion");
            
            Solution s = new BaseXConvert();
            s.solve("testcases/BaseXConvert.test");
        } catch(Exception e){
            System.out.println("Problem 3 FAILED!." + e.getMessage());
            throw e;
        }
        
        /**
         * 4. Write a function such that if an element in an MxN matrix is 0 , its entire row and column are set to 
         * 0 and then printed out. 
         * 
         * Assumption: There is one and ONLY ONE Zero in the input Matrix
         * 
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 4 - Matrix zero-ed");
            
            Solution s = new MatrixZero();
            s.solve("testcases/MatrixZeroed.test");
        } catch(Exception e){
            System.out.println("Problem 4 FAILED!." + e.getMessage());
            throw e;
        }
        
        /**
         * 5. Write a function that convert the given number into a Roman Numeral - The function needs to receive a Number and Return a String (The Number can be 
         * between 1 and 3999)
         * 
         * Min Value : 1
         * Max Value : 3999
         * 
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 5 - Roman Numbers");
            
            Solution s = new ArabicToRoman();
            s.solve("testcases/RomanToArabic.test");
        } catch(Exception e){
            System.out.println("Problem 5 FAILED!." + e.getMessage());
            throw e;
        }
        
        /**
         * 6.- Write a function to print all permutations of a string. Max string length can be 50 characters.
         * 
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 6 - Permutations");
            
            Solution s = new Permutations();
            s.solve("testcases/Permutations.test");
        } catch(Exception e){
            System.out.println("Problem 6 FAILED!." + e.getMessage());
            throw e;
        }
        
        
        /**
         * 7.- Write a function that receives a sentence, and return the longest word, if two or more words has 
         * the same lenght, they are returned as an array, but can't return duplicated words.
         * 
         * 
         */
        try {
            System.out.println("------------------------------------");
            System.out.println("Problem 7 - Largest word or words in sentence");
            
            Solution s = new LargestWord();
            s.solve("testcases/Sentences.test");            
        } catch(Exception e){
            System.out.println("Problem 7 FAILED!." + e.getMessage());
            throw e;
        }
        
        
    }

}
