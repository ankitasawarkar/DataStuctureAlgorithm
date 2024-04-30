public class Array_53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int current_sum = 0;// max_sum;
        for (int i = 0; i < nums.length; i++) {
            current_sum = Math.max(nums[i] + current_sum, nums[i]);
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }
}
