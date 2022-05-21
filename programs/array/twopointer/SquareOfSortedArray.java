package array.twopointer;

import java.util.Arrays;

/*

    Given an integer array nums sorted in non-decreasing order,
    return an array of the squares of each number sorted in non-decreasing order.



    Example 1:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
    Example 2:

    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]


 */
public class SquareOfSortedArray {
    public static int[] solution(int arry[]){
        int start = 0;
        int end = arry.length - 1;
        int result[] = new int[arry.length];
        for(int i=arry.length-1; i >= 0; i--){
            if(Math.abs(arry[start]) > Math.abs(arry[end])){
                result[i] = arry[start] * arry[start];
                start++;
            }
            else{
                result[i] = arry[end] * arry[end];
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-4,-1,0,3,10};
        Arrays.stream(solution(nums)).forEach(System.out::println);
        int nums2[] = {-7,-3,2,3,11};
        Arrays.stream(solution(nums2)).forEach(System.out::println);
    }
}
