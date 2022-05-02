package array.windowtechnique;/*

Given an array of size N and K, find out maximum sum of the contiguous sub-array of size K
input - [1,4,3,8,2,9,4], k =3
output -  19

explanation -  here the sub array [8,2,9] gives the maximum sum of 19 among all other possible sub-arrays.


 */

public class SubArraySizeKWithMaximunSumWindowTechnique {

    public int findMaxSum(int []arry, int k){
        int sum = 0;
        int n =  arry.length;
        for(int i = 0 ; i < k ; i++){
            sum = sum + arry[i];
        }
        int currentSum = sum;
        int maxSum = sum;
        for(int i = 1 ; i <= n - k ; i++){
            currentSum =  currentSum - arry[i-1];
            currentSum = currentSum + arry[(k+i)-1];
            maxSum = Math.max(maxSum , currentSum);
        }
        return  maxSum;

    }


    public static void main(String[] args) {
        System.out.println(new SubArraySizeKWithMaximunSumWindowTechnique()
                .findMaxSum(new int[]{1,4,3,8,2,9,4},3));
    }
}
