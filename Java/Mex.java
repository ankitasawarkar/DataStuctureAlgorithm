import java.util.*;
class Mex {
 
    // Function to return maximum
    // MEX of all K length subarray
    static void maxMEX(int arr[], int N, int k)
    {
        // Stores element from
        // 1 to N + 1 is nor
        // present in subarray
       
        // We need a Tree Set since
        // we want to store the
        // elements in ascending
        // order
        TreeSet<Integer> s = new TreeSet<>(); 
 
        // Store number 1 to
        // N + 1 in set s
          for(int l=1;l<=N+1;l++)    
          s.add(l);
          // i and j point to the start of the array
          // i.e index 0
          int i=0;
          int j=0;
           
          int mex = 0;
          // mex variable which stores the mex for 
          // generated subArrays
          int maxMex = Integer.MIN_VALUE;
          //maxMex contains the maximum mex value for all subArrays
           
          while(j < N)
        {
          if(s.contains(arr[j]))
             s.remove(arr[j]);
          int windowSize = j-i+1;
          // window size at any instant is given by j-i+1;
          if(windowSize < k)
             j++;
             // here, windowSize < k , i.e we haven't reached the first
             // window of size k yet.. so we increment j;
          else if(windowSize == k)
          {
            //here , windowSize equals k, we are to get an answer everytime 
            // we reached the windowSize of k , first element of the set has
            // mex for this subArray;
            mex = s.pollFirst();
            // set.pollFirst() function removes the firstElement in the treeset;
            maxMex = Math.max(maxMex,mex);
             
            // before sliding the window , we need to undo the calculations
            // done at the starting point , i.e i;
            s.add(arr[i]);
            i++;
            j++;
            // sliding the window by 1 each in i and j , so as to maintain 
            // the windowSize k;
          }
        }
        System.out.println(maxMex);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        /* // Given array
        int arr[] = { 1,2,2 };
 
        // Given length of subarray
        int K = 3;
 
        // Size of the array
        int N = arr.length;
 
        // Function Call
        maxMEX(arr, N, K); */

        // Sample Case 0
        List<Integer> arr1 = List.of(1, 2, 2);
        System.out.println(getMaximumMex(arr1)); // Output: 3

        // Sample Case 1
        List<Integer> arr2 = List.of(0, 0);
        System.out.println(getMaximumMex(arr2)); // Output: 1
    } 

    static int getMaximumMex(List<Integer> arr) {
        // Sort the list in non-decreasing order
        Collections.sort(arr);

        int n = arr.size();

        // Iterate through the sorted list and try to reduce each element
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > i) {
                return i; // If cannot reduce to index, return the current index
            }
        }

        // If all elements can be reduced to their indices, return n as the maximum MEX
        return n;
    }

}