import java.util.*;

public class SqrtX {

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;

            int left = 1, right = x;
            int ans = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if ((long) mid * mid == x) {
                    return mid;
                } else if ((long) mid * mid < x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.mySqrt(x);

        System.out.println("Square root (floor value): " + result);

        sc.close();
    }
}