package com.anexinet.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MatrixToTestcase
{
    private static final String BR = "\n";
    private static final String SPACE = " ";
    
    public static int generateRandomInt(int max) {
        return 1 + Math.round((float)((max - 1) * Math.random() * 100) / 100);
    }
    
    public static void generateMatrix(String testCase) throws Exception {
        String line = "";
        Path testPath = Path.of(testCase);
        
        //Count of test cases in file --- 10
        int count = 10;
        line = Integer.toString(count) + BR;
        Files.writeString(testPath, line, StandardOpenOption.CREATE);
        int i = 0;
        while(i++ < count) {
            int m = MatrixToTestcase.generateRandomInt(20);
            int n = MatrixToTestcase.generateRandomInt(20);
            line = String.format("%d %d %s", m, n, BR);
            Files.writeString(testPath, line, StandardOpenOption.APPEND);
            int j = 0;
            line = "";
            while(j++ < (m * n)) {
                line += MatrixToTestcase.generateRandomInt(100) + SPACE;
            }
            line += BR;
            Files.writeString(testPath, line, StandardOpenOption.APPEND);
            Files.writeString(testPath, line, StandardOpenOption.APPEND);
        }
    }
}
