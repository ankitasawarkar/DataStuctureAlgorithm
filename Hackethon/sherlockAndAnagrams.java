package Hackethon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * sherlockAndAnagrams
 */
public class sherlockAndAnagrams {

    // Solution 1: not fullfill all cases
    public static int Solution(String s) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        int sum = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 2)
                .mapToInt(Map.Entry::getValue)
                .sum();

        return sum;

    }

    // Solution 2:
    public static int countAnagramPairs(String s) {
        int count = 0;
        int length = s.length();

        // Map to store frequency of sorted substrings
        Map<String, Integer> substringFrequency = new HashMap<>();

        // Iterate through all substrings
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= length - i; j++) {
                // Get the substring and sort the characters
                String substring = s.substring(j, j + i);
                char[] charArray = substring.toCharArray();
                java.util.Arrays.sort(charArray);
                String sortedSubstring = new String(charArray);

                // Increment count for this sorted substring in the map
                substringFrequency.put(sortedSubstring, substringFrequency.getOrDefault(sortedSubstring, 0) + 1);
            }
        }

        // Count the pairs of anagrams
        for (int frequency : substringFrequency.values()) {
            count += frequency * (frequency - 1) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution("abba"));
        System.out.println(Solution("ifailuhkqq")); // fail
        System.out.println(countAnagramPairs("ifailuhkqq"));
        System.out.println(countAnagramPairs("kkkk"));
    }

}