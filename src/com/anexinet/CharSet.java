package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Problem 2: Given 2 strings of unknown characters (but it cannot be repeated) create a function that returns an array of the 
 * characters that are repeated in both strings in the most efficient way.
 * 
 * Assumption: No repeated characters in the same string. Find the repeated characters in one another.
 * 
 * @author luis.chapa
 *
 */
public class CharSet implements Solution
{
    private static final String ERROR_REPEATED_CHARS = "string has repeated chars against itself";
    
    /**
     * Calculates the intersection of characters of the Strings
     * 
     * @param s1 First String
     * @param s2 Second String
     * @return char array with intersection characters
     * @throws IllegalArgumentException
     */
    private char[] getIntersection(String s1, String s2) throws IllegalArgumentException {
        Set<Character> set1 = s1.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
        if(set1.size() != s1.length()) { //Verifies no repeated chars in First String
            throw new IllegalArgumentException("First " + ERROR_REPEATED_CHARS); 
        }
        
        Set<Character> set2 = s2.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
        if(set2.size() != s2.length()) { //Verifies no repeated chars in Second String
            throw new IllegalArgumentException("Second " + ERROR_REPEATED_CHARS); 
        }
        
        //Get the intersection
        Set<Character> intersectSet = new HashSet(set1);
        intersectSet.retainAll(set2);
        
        //Transforms from Set to char array.
        char[] intersection = intersectSet.stream().map(c -> c.toString()).collect(Collectors.joining()).toCharArray();
        return intersection;
        
    }
    
    @Override
    public void solve(String testCase) throws Exception {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            
            do {
                String s1 = s.nextLine();
                String s2 = s.nextLine();
                try {
                    char[] result = this.getIntersection(s1, s2);
                    System.out.printf("%s %s intersection %s\n", s1, s2, Arrays.toString(result));
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while(s.hasNext());
            
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage());
            throw e;
        } 
    }

}
