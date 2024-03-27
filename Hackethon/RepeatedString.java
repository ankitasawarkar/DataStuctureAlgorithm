package Hackethon;

import java.io.*;

/*
* Complete the 'repeatedString' function below.
* https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
* The function is expected to return a LONG_INTEGER.
* The function accepts following parameters:
*  1. STRING s
*  2. LONG_INTEGER n
*/    

public class RepeatedString {

    public static long repeatedString(String s, long n) {
        // Write your code here
        if (s.length() == 1) {
            // If the string has only one character, and it is 'a', return n
            return s.equals("a") ? n : 0;
        } else {
            long result = 0;
    
            // Calculate the number of 'a' in the original string
            long countInOriginal = s.chars().filter(ch -> ch == 'a').count();
    
            // Calculate the number of complete repetitions
            long repetitions = n / s.length();
    
            // Calculate the remaining characters
            long remainingChars = n % s.length();
    
            // Calculate the number of 'a' in the remaining part
            long countInRemainder = s.substring(0, (int) remainingChars).chars().filter(ch -> ch == 'a').count();
    
            // Calculate the final result
            result = (repetitions * countInOriginal) + countInRemainder;
    
            return result;
        }
        }

    public static void main(String[] args) throws IOException {
       /*  Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close(); */
        long result = repeatedString("aba", 10);
        System.out.println(result);
        
    }
}
