package com.anexinet;


/**
 * Interface to be implemented for each single and specific problem asked to solve.
 * 
 * @author luis.chapa
 *
 */
public interface Solution
{   
    /**
     * Method for solveing the problem 
     *  
     * @param testCase String Path to the TestCases file to run the solution of the problem
     * @throws Exception Something goes wrong in the execution
     */
    void solve(String testCase) throws Exception;
}
