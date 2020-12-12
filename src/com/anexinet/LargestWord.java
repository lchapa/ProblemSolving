package com.anexinet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LargestWord implements Solution
{

    @Override
    public void solve(String testCase) throws Exception
    {
        //Open Test cases
        try(Scanner s = new Scanner(Path.of(testCase))){
            do { //read testcases
                String sentence = s.nextLine();
                //Split the sentence in wowrds.
                List<String> strings = List.of(sentence.split("\\s"));
                //Group by length of each string and then Collect as Set to avoid repeted strings
                Map<Integer, Set<String>> longest = 
                        strings.stream()
                        .collect(Collectors.groupingBy(str -> str.length(), Collectors.toSet()));
                //Get the max length found in sentence
                Integer max = longest.keySet().stream().max(Integer::compareTo).orElse(0);
                //Show Result
                System.out.println(longest.get(max));
                
                if(max.compareTo(Integer.valueOf(0)) <= 0) {
                    throw new AssertionError("TestCase not passed. Expected value: Max Value greater than Zero");                    
                }
                
            } while(s.hasNextLine());
        } catch(IOException e) {
            System.out.println("Could not completed all TestCases: " + e.getMessage());
            throw e;
        }

    }

}
