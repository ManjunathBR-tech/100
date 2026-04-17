public class RangeSumQueryImmutable {

    // NumArray class as required by the problem
    static class NumArray {

        private int[] prefix;

        // Constructor
        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];

            // Build prefix sum array
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        // Function to get sum from left to right
        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    // Main method to test the code
    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray obj = new NumArray(nums);

        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}