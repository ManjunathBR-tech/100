import java.util.*;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int st = 0, end = nums.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            // LEFT SORTED → go RIGHT
            if (nums[mid] > nums[end]) {
                st = mid + 1;
            } 
            // RIGHT SORTED → go LEFT
            else {
                end = mid;
            }
        }

        return nums[st];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find minimum
        int min = findMin(nums);

        // Output result
        System.out.println("Minimum element is: " + min);

        sc.close();
    }
}