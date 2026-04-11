
public class RotateArray {

    // Main function to test the solution
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        obj.rotate(nums1, k1);
        printArray(nums1);  // Expected: [5,6,7,1,2,3,4]

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        obj.rotate(nums2, k2);
        printArray(nums2);  // Expected: [3,99,-1,-100]
    }

    // Helper function to print array
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Solution class (as required in coding platforms)
class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n; // handle large k

        // Step 1: Reverse whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

