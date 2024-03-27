package Hackethon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * arr = [1,4,16,64]  r = 4
 * Theare are [1,4,16] and []4, 16, 64] at indices (0,1,2) & (1,2,3)
 * o/p = 2 
 * 
 * n=4 r=2
 * [1 2 2 4]
 * o/p= 2
 * (0,1,3) & (0,2,3)
 *
 * 6 3
 * 1 3 9 9 27 81
 * o/p = 6
 * (0,1,2) (0,1,3) (1,2,4) (1,3,4) (2,4,5) (3,4,5)
 * 
 * 5 5
 * 1 5 5 25 125
 * o/p = 4
 * (0,1,3) (0,2,3) (1,3,4) (2,3,4)
 * 
 */
public class CountTriplets {
    // Complete the countTriplets function below.
    static long solution(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) { //[1 2 2 4]
            long a = arr.get(i); // 0:1, 1:2, 2:2, 3:4
            long key = a / r; // 1/2=0, 2/2=1, 2/2=1, 4/2=2
            
            if (counter.containsKey(key) && a % r == 0) {// 2:1->1
                count += counter.get(key); // key=1->1, 
            }
            
            if (potential.containsKey(key) && a % r == 0) { // 1:1->1 ,2:2->1
                long c = potential.get(key); // 1, 
                counter.put(a, counter.getOrDefault(a, 0L) + c); //1:2-> 1, 
            }
            
            // Every number can be the start of a triplet.
            potential.put(a, potential.getOrDefault(a, 0L) + 1); // 0:1->1, 1:2->1, 2:2->2 
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 9, 9, 27, 81};

        List<Long> longList = Arrays.stream(array)
                .asLongStream() // Convert to LongStream
                .boxed()        // Box each long to Long
                .collect(Collectors.toList());
        System.out.println(solution(longList, 3));
    }
}
