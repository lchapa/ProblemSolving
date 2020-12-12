# Anexinet Technical Test

Project created to solve 7 problems for [Anexinet](https://anexinet.com/) Technical Challenge.

## Problems:

1. Write a function that adds two numbers without using any arithmetic operators.

2. Given 2 strings of unknown characters (but it cannot be repeated) create a function that returns an array of the characters that are repeated in both strings in
the most efficient way.

3. Write a function that takes a string containing a number in base X along with an integer of the base X. The function must return the integer value of that
string/base pair. E.g.,
Pay close attention to string validation against base.

4. Write a function such that if an element in an MxN matrix is 0 , its entire row and column are set to 0 and then printed out.

5. Write a function that convert the given number into a Roman Numeral - The function needs to receive a Number and Return a String (The Number can be
between 1 and 3999)
Example:
getRomanNumeral(512);
Prints: DXII

6. Write a function to print all permutations of a string. Max string length can be 50 characters.

7. Write a function that receives a sentence, and return the longest word, if two or more words has the same lenght, they are returned as an array, but can't return
duplicated words.

## Usage

1.- As you can see the following class has a main method, from here each problem Solution, as described above, are executed taking into account the TestCases (testcases/*.test)

```java
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

        ...

    }

}
```

2.- Please, be aware of the following: each testcase file should end with an empty line, to make the Scanner work properly. (Fixing this little bug in the next release).

Thanks and enjoy.