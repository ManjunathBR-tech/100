import java.util.*;

public class AllocateMinimumPages {

    // Function to find minimum pages
    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        // Edge case: more students than books
        if (k > n) return -1;

        int low = 0, high = 0;

        // Initialize search space
        for (int pages : arr) {
            low = Math.max(low, pages); // max element
            high += pages;              // sum of array
        }

        int result = -1;

        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1; // increase limit
            }
        }

        return result;
    }

    // Helper function to check feasibility
    private static boolean isPossible(int[] arr, int k, int maxPages) {
        int students = 1;
        int currentPages = 0;

        for (int pages : arr) {

            if (pages > maxPages) return false;

            if (currentPages + pages > maxPages) {
                students++;
                currentPages = pages;

                if (students > k) return false;
            } else {
                currentPages += pages;
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;

        int[] arr2 = {15, 17, 20};
        int k2 = 5;

        System.out.println("Output 1: " + findPages(arr1, k1)); // Expected: 113
        System.out.println("Output 2: " + findPages(arr2, k2)); // Expected: -1
    }
}