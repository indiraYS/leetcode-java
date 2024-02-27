package com.company;

import com.company.easy.LuckyNumbersInMatrix;
import com.company.hakerrank.SubarrayDivision;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // System.out.println(702/26);
        // 702/26 = 27 | ZZ
        // System.out.println((new ExcelSheetColumnTitle()).convertToTitle(52));
        // int[] arr = new int[]{2,5,1,3,4,4,3,5,1,1,2,1,4,1,3,3,4,2,1};

        System.out.println((new LuckyNumbersInMatrix()).luckyNumbers(
                new int[][]{
                        new int[] {3,7,8},
                        new int[] {9,11,13},
                        new int[] {15,16,17}
                }
        ));

        // 15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2
        // 1,3,4,8,7,9,3,5,1
        // long end = System.currentTimeMillis();
        // System.out.println((end-start));
    }

    public static void main__(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        // (new InterleavingString()).isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("ohomm"));
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("bbb"));
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("abcabcbb"));
        long end = System.currentTimeMillis();
        System.out.println( "time: "+(end-start));
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
