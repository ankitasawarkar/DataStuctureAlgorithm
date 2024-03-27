package Hackethon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Complete the 'hourglassSum' function below.
*
* The function is expected to return an INTEGER.
* The function accepts 2D_INTEGER_ARRAY arr as parameter.
*/

public class TwoDArray {
    
    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        int sum = Integer.MIN_VALUE;
        int size = 3;
        for(int i = 0; i<= arr.size() - size; i++){
            for(int j = 0; j<= arr.get(0).size()-size; j++){
                List<Integer> curr = new ArrayList<>();
                curr.add(arr.get(i).get(j));
                curr.add(arr.get(i).get(j+1));
                curr.add(arr.get(i).get(j+2));
                curr.add(arr.get(i+1).get(j+1));
                curr.add(arr.get(i+2).get(j));
                curr.add(arr.get(i+2).get(j+1));
                curr.add(arr.get(i+2).get(j+2));
                
                sum = Math.max(sum, curr.stream().mapToInt(Integer::intValue).sum());
            }
        }    
   
        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        );
       System.out.println(hourglassSum(arr));
    }
}
