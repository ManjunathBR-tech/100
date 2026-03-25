import java.util.*;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int z = 0;

        for (int nz = 0; nz < nums.length; nz++) {
            if (nums[nz] != 0) {
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
                z++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}