package Hackethon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayManipulation {
    
    /*
     * Complete the 'arrayManipulation' function below.
     * https://www.hackerrank.com/challenges/crush/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n = 10
     *  2. 2D_INTEGER_ARRAY queries = [[1,5,3],[4,8,7],[6,9,1]]
     *  
     *  a b k
        1 5 3
        4 8 7
        6 9 1
     */

    public static long arrayManipulation1(int n, List<List<Integer>> queries) {
    // Write your code here
        Map<Integer, Long> map = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toMap(key -> key, value -> 0L, (a, b) -> a, LinkedHashMap::new));


        for (List<Integer> query : queries) {
            int start = query.get(0);
            int end = query.get(1);
            long valueToAdd = query.get(2).longValue();

            for(int k = start; k<=end && end <=n; k++){
                map.put(k, map.get(k) + valueToAdd);
            }
            
        }

        long maxValue = Collections.max(map.values());

        return maxValue;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long max = 0;
        long x = 0;

        List<Long> a = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            a.add(0L);
        }

        for (List<Integer> query : queries) {
            int p = query.get(0) - 1; // Adjusting for 0-based indexing
            int q = query.get(1) - 1; // Adjusting for 0-based indexing
            int sum = query.get(2);

            a.set(p, a.get(p) + sum);
            if ((q + 1) < n) {
                a.set(q + 1, a.get(q + 1) - sum);
            }
        }

        for (int i = 0; i < n; i++) {
            x += a.get(i);
            if (max < x) {
                max = x;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        /* List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 2, 100));
        queries.add(Arrays.asList(2, 5, 100));
        queries.add(Arrays.asList(3, 4, 100));

        int n = 5;
        System.out.println(arrayManipulation(n, queries)); */

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 5, 3));
        queries.add(List.of(4, 8, 7));
        queries.add(List.of(6, 9, 1));

        int n = 10;
        long result = arrayManipulation(n, queries);

        System.out.println("Maximum value after array manipulation: " + result);  
       
    }

}

