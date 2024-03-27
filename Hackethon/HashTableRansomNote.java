package Hackethon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTableRansomNote {
/*
* Complete the 'checkMagazine' function below.
*
* The function accepts following parameters:
*  1. STRING_ARRAY magazine
*  2. STRING_ARRAY note
*/
    // Solution 1:
    public static void checkMagazine1(List<String> magazine, List<String> note) {
        Map<String, Integer> dicty = new HashMap<>();
        
        // Count occurrences in the magazine
        for (String word : magazine) {
            dicty.put(word, dicty.getOrDefault(word, 0) + 1);
        }
        
        // Check and decrement occurrences in the ransom note
        for (String word : note) {
            if (dicty.getOrDefault(word, 0) == 0) {
                System.out.println("No");
                return;
            }
            dicty.put(word, dicty.get(word) - 1);
        }
        
        System.out.println("Yes");
    }

    // Solution 2: all test cases not pass.
    public static void checkMagazine2(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineCount = new HashMap<>();
        
        // Count occurrences in the magazine
        magazine.stream().forEach(word -> magazineCount
                        .put(word, magazineCount.getOrDefault(word, 0) + 1));

        // Count occurrences in the ransom note
        Map<String, Integer> ransomCount = new HashMap<>();
        note.stream().forEach(word -> ransomCount.put(word, ransomCount.getOrDefault(word, 0) + 1));

        // Check if magazineCount contains all required words with enough occurrences
        boolean result = ransomCount.entrySet().stream()
                .allMatch(entry -> magazineCount.getOrDefault(entry.getKey(), 0) == entry.getValue());

        System.out.println(result ? "Yes" : "No");
    }
    
    public static void main(String[] args) {
        /* List<String> l1 = Arrays.asList("two times three is not four".split(" "));
        List<String> l2 = Arrays.asList("two times two is four".split(" ")); */
        List<String> l1 = Arrays.asList("give me one grand today night".split(" "));
        List<String> l2 = Arrays.asList("give one grand today".split(" "));
        checkMagazine2(l1,l2);
    }
    }
