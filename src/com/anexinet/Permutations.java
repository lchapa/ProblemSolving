package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Permutations implements Solution
{
    /**
     * Swaps values in the same array of chars
     * 
     * @param s Char array where the swap is going to be done.
     * @param l Left index
     * @param r Rigth index
     */
    private void swap(char[] s, int l, int r) {
        char t = s[l];
        s[l] = s[r]; 
        s[r] = t;
    }
    
    /**
     * Recursive funtion that takes the char array and reduces the permutation operation down untill there is only ONE
     * character to permutate, so it returns and permutates against the rest of the array
     * 
     * @param s array being permutated along recuersive calls
     * @param l Left index, each call it is incremented in order to reduce the array bieng permutated untill 
     *          the simplest one, 1 element permutation.  
     * @param r Rigth index
     * @param permutations List in which each permutations is hold
     */
    private void permute(char[] s, int l, int r, List<String> permutations) {
        
        if(l == r) {
            permutations.add(String.valueOf(s));
        } else {
            for(int i = l; i <= r; i++) {
                //One way permutation
                swap(s,l,i);
                //Reduce to one element lest problem and call again
                permute(s, l + 1, r, permutations);
                //Way back permutation
                swap(s,l,i);
            }
        }
    }

    @Override
    public void solve(String testCase) throws Exception
    {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { //read strings 
                String permute = s.nextLine();
                List<String> permutations = new ArrayList<>();
                this.permute(permute.toCharArray(), 0, permute.length() - 1, permutations);
                System.out.println("Next String: " + permutations);
                
                //Calculate the all posible permutation and checks against the size of generated permutations
                if(Permutations.factorial(permute.length()) != permutations.size()) {
                    throw new AssertionError("Permutations incorrect for " + permute);
                }
                
            } while(s.hasNextLine());
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Calculates factorial
     * 
     * @param n elements
     * @return factorial of the n's elements
     */
    private static long factorial(int n) {
        long result = 1;
        for(int i = (int)result; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
