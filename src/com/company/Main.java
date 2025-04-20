package com.company;

import com.company.concurrency.ZeroEvenOdd;
import com.company.hard.OddEvenJump;
import java.util.List;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        OddEvenJump j = new OddEvenJump();
        // System.out.println(j.oddEvenJumps(new int[] {10, 13, 12, 13, 11, 15}));
        System.out.println(j.oddEvenJumps(new int[] {31,28,8,41,20,28,41,26,46,30,41,34,2,29,24,39,28,11,22,21,33,15,14,35,49,23,15,46,19,28,13,19,38}));
        // 31,28,8,41,20,28,41,26,46,30,41,34, 2,29,24,39,28,11,22,21,33,15,14,35,49,23,15,46,19,28,13,19,38
        // 20, 29, 17, 10, 19, 29, 10, 29, 27, 20, 27, 23, 17, 20, 29, 27, 29, 30, 25, 25, 23, 26, 26, 32, -1, 29, 31, -1, 31, 32, 31, 32, 32
        // System.out.println(j.oddEvenJumps(new int[] {10, 13, 12, 14, 13}));
        long end = System.currentTimeMillis();

        Map<Integer, List<Integer>> mp;
        mp.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
        System.out.println("time:" + (end - start));
    }

    public static void main__(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        // (new InterleavingString()).isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("ohomm"));
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("bbb"));
        System.out.println((new LongestSubstring()).lengthOfLongestSubstring("abcabcbb"));
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    /***
     * String fileString = readFile("/Users/indira/work/leetcode/src/atmostkrepeating.txt", StandardCharsets.UTF_8);
     *         System.out.println(new MaximumSubArrayAtMostKRepeating().maxSubarrayLength(
     *                 Arrays.stream(fileString.split(",")).mapToInt(Integer::parseInt).toArray()
     *                 , 1456));
     * @param path
     * @param encoding
     * @return
     * @throws IOException
     */
    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
