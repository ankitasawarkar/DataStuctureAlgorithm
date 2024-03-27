package Hackethon;

import java.util.Scanner;

/**
 * LuckyPrisoner
 */
public class LuckyPrisoner {

    // Solution 1:-
    // Time Complexity = O(n)
    public static int findLastSurvivor(int n){
       // Creating an array to represent the prisoners
       boolean[] prisoners = new boolean[n];
       // Initially, all prisoners are alive
       for (int i = 0; i < n; i++) {
           prisoners[i] = true;
       }

       int remainingPrisoners = n; // Number of prisoners remaining
       int currentIndex = 0; // Index of the current prisoner

       while (remainingPrisoners > 1) {
           // Execute every second prisoner
           currentIndex = (currentIndex + 1) % n;

           // If the current prisoner is alive, eliminate them
           if (prisoners[currentIndex]) {
               prisoners[currentIndex] = false;
               remainingPrisoners--;
           }
       }

       // Find the index of the last surviving prisoner
       for (int i = 0; i < n; i++) {
           if (prisoners[i]) {
               return i + 1; // Adding 1 to convert from 0-based index to 1-based index
           }
       }

       return -1; // This should not happen if the input is valid
    }

    // Solution 2:-
    // Time complexity O(log n)
    public static int findLastSurvivor_Recursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * (findLastSurvivor_Recursive(n / 2) - 1) + 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int lastSurvivor = findLastSurvivor(n);
            System.out.println(lastSurvivor);
        }

        scanner.close();
    }
}