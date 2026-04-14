public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println("First Position: " + result[0]);
        System.out.println("Last Position: " + result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstPosition = findBoundary(nums, target, true);
        int lastPosition = findBoundary(nums, target, false);

        return new int[]{firstPosition, lastPosition};
    }

    private static int findBoundary(int[] nums, int target, boolean findFirst) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == target) {
                resultIndex = middle;

                if (findFirst) {
                    end = middle - 1;   // move LEFT
                } else {
                    start = middle + 1; // move RIGHT
                }

            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return resultIndex;
    }
}