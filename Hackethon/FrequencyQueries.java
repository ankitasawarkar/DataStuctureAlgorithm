package Hackethon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
    // Complete the freqQuery function below.

    // Solution 1: some cases are fail
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new LinkedList<>();
        List<Integer> finalres = new LinkedList<>();
        Map<Integer, Long> frequencyMap = new HashMap<>();

        for (List<Integer> query1 : queries) {
            if (query1.get(0) == 1) {
                result.add(query1.get(1));
                // Update frequencyMap
                frequencyMap.put(query1.get(1), frequencyMap.getOrDefault(query1.get(1), 0L) + 1);
            }
            if (query1.get(0) == 2) {
                if (result.remove(query1.get(1))) {
                    // Update frequencyMap
                    frequencyMap.put(query1.get(1), frequencyMap.getOrDefault(query1.get(1), 0L) - 1);
                }
            }
            if (query1.get(0) == 3) {
                // Check if any element has frequency greater than or equal to query1.get(1)
                boolean exists = frequencyMap.values().stream().anyMatch(count -> count >= query1.get(1));
                finalres.add(exists ? 1 : 0);
            }
        }
        return finalres;
    }

    // Solution 2:
    static List<Integer> freqQuery1(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> numbersCountMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> frequencyCountMap = new HashMap<Integer, Integer>();

        for (List<Integer> query : queries) {
            Integer operation = query.get(0);
            Integer data = query.get(1);
            switch (operation) {
                case 1:
                    Integer previousCount = numbersCountMap.getOrDefault(data, 0);
                    Integer newCount = previousCount + 1;
                    numbersCountMap.put(data, newCount);
                    if (frequencyCountMap.getOrDefault(previousCount, 0) > 0) {
                        frequencyCountMap.put(previousCount, frequencyCountMap.getOrDefault(previousCount, 0) - 1);
                    }
                    frequencyCountMap.put(newCount, frequencyCountMap.getOrDefault(newCount, 0) + 1);
                    break;
                case 2:
                    previousCount = numbersCountMap.getOrDefault(data, 0);
                    newCount = previousCount - 1;
                    if (numbersCountMap.getOrDefault(data, 0) > 0) {
                        numbersCountMap.put(data, newCount);
                    }
                    if (frequencyCountMap.getOrDefault(previousCount, 0) > 0) {
                        frequencyCountMap.put(previousCount, frequencyCountMap.getOrDefault(previousCount, 0) - 1);
                    }
                    frequencyCountMap.put(newCount, frequencyCountMap.getOrDefault(newCount, 0) + 1);

                    break;
                case 3:
                    if (frequencyCountMap.getOrDefault(data, 0) > 0) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = Arrays.asList(

                Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(3, 2),
                Arrays.asList(1, 10),
                Arrays.asList(1, 10),
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 2));

        List<Integer> result = freqQuery(queries);
        System.out.println(result);
        List<Integer> result1 = freqQuery1(queries);
        System.out.println(result1);
    }
}
