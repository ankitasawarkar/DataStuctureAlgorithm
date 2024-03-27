package Hackethon;


public class MinimumSwap {
    // https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swipe = 0, i = 0;
        while(i<arr.length){
            if(arr[i] != i+1){
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
                swipe++;
            }else
                i++;
        }
        return swipe;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        System.out.println(minimumSwaps(arr));
        

    }
    
}
