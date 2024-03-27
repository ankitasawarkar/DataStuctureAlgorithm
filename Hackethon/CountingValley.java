package Hackethon;

import java.io.*;
import java.util.*;

class Solution {

    /*
     * Complete the 'countingValleys' function below.
     * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        int level = 0;
        int valleys = 0;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                level++;
            } else {
                level--;
            }

            if (step == 'U' && level == 0) {
                valleys++;
            }
        }

        return valleys;
    }

}

public class CountingValley {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String path = sc.next();

        int result = Solution.countingValleys(n, path);
        System.out.print(result);
        sc.close();
    }
}
/*
 * Sample Input- 
8
UDDDUDUU

Sample Output- 1
Explanation - 
If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:

_/\      _
   \    /
    \/\/
The hiker enters and leaves one valley.
 * 
 */
