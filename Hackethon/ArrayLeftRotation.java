package Hackethon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Sample Input
5 4
1 2 3 4 5
Sample Output
5 1 2 3 4 */
public class ArrayLeftRotation {
        public static List<Integer> rotLeft(List<Integer> a, int d) {
            List<Integer> rotation = new ArrayList<>();
            for(int i = d; i<a.size(); i++){
                rotation.add(a.get(i));
            }
            for(int i = 0; i< d; i++){
                rotation.add(a.get(i));
            }
            return rotation;
        }

        public static void main(String[] args) {
            List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            System.out.println(rotLeft(arr, 4));
        }
}
