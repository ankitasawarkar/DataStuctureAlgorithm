package Hackethon;

import java.util.List;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
        int jump = 0, count = 0;
        while(count < c.size()-1){
            jump ++;
            if(count+2 < c.size() && c.get(count+2) == 0){
                count +=2;
            } else {
                count++;
            }
        }
        return jump;
    }

}

public class JumpingOnTheCloud {
    
}
