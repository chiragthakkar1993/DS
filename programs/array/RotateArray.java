package array;


import java.util.Arrays;

/*
            Given an array, rotate the array to the right by k steps, where k is non-negative.



            Example 1:

            Input: nums = [1,2,3,4,5,6,7], k = 3
            Output: [5,6,7,1,2,3,4]
            Explanation:
            rotate 1 steps to the right: [7,1,2,3,4,5,6]
            rotate 2 steps to the right: [6,7,1,2,3,4,5]
            rotate 3 steps to the right: [5,6,7,1,2,3,4]
            Example 2:

            Input: nums = [-1,-100,3,99], k = 2
            Output: [3,99,-1,-100]
            Explanation:
            rotate 1 steps to the right: [99,-1,-100,3]
            rotate 2 steps to the right: [3,99,-1,-100]


            Constraints:

            1 <= nums.length <= 105
            -231 <= nums[i] <= 231 - 1
            0 <= k <= 105


            Follow up:

            Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
            Could you do it in-place with O(1) extra space?


 */
public class RotateArray {

    public static void rotate_bruteForce(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; count < n; i++) {
            int curPos = i;
            int curVal = nums[i];
            do {
                int newPos = (curPos + k) % n;
                int tmp = nums[newPos];
                nums[newPos] = curVal;
                curVal = tmp;
                curPos = newPos;
                count++;
            } while (i != curPos);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(val -> System.out.print(val + " "));

        System.out.println();

        int nums2[] = {1,-100,3,99};
        rotate_bruteForce(nums2, 2);

        Arrays.stream(nums2).forEach(val -> System.out.print(val+" "));

    }
}
