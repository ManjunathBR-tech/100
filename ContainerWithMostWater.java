import java.util.*;

public class ContainerWithMostWater {

    // Function to calculate max water
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter heights:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        // Output
        int result = maxArea(height);
        System.out.println("Maximum water stored: " + result);

        sc.close();
    }
}