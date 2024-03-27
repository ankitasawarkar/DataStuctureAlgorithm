package Hackethon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
    // Write your code here
    int bribes = 0;

    for (int i = 0; i < q.size(); i++) {
        /* It calculates the original position by subtracting 1 from the person's 
        sticker value since the positions are 1-indexed. */
        int originalPosition = q.get(i) - 1;

        /* If a person's original position is more than 2 places ahead of their current position, 
        it means they received more than two bribes, and "Too chaotic" is printed. */
        if (originalPosition - i > 2) {
            System.out.println("Too chaotic");
            return;
        }

        /* For each person, it checks the positions of the people in front of them (up to their original position - 1) 
        and increments the bribes count for each person in front who has a higher sticker value. */
        for (int j = Math.max(0, originalPosition - 1); j < i; j++) {
            if (q.get(j) > q.get(i)) {
                bribes++;
            }
        }
    }

    System.out.println(bribes);        
        
    }
  

    public static void main(String[] args) {
        //List<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 3, 4));
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4));
        minimumBribes(arr);
     
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Size of the queue
            List<Integer> q = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                q.add(scanner.nextInt()); // Elements of the queue
            }
            
            minimumBribes(q);
        }

        scanner.close();
    }
}

