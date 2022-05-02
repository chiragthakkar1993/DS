package array.windowtechnique;


/*
        given an array of positive integers and a positive integer sum
        this function should return the minimal length of a contiguous sub-array of which
        the sum is greater than or equal to the sum passed to the function.
         If there isn't one return 0

        input: arry = [2,3,1,2,4,3], sum = 7
        o/p: 2

        explanation: here the sub-array with minimal length would be [4,3]. So length 2 is the output

        input: arry = [3,1,7,11,2,9,8,21,62,33,19], sum = 52
        o/p: 1

        explanation: here the sub-array with minimal length would be [62]. So length 1 is the output

 */
public class MinSubArrayLength {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,3,1,2,4,3},7));
        System.out.println(solution(new int[] {2,1,6,5,4},9));
        System.out.println(solution(new int[] {3,1,7,11,2,9,8,21,62,33,19},52));
        System.out.println(solution(new int[] {1,4,16,22,5,7,8,9,10},39));
        System.out.println(solution(new int[] {1,4,16,22,5,7,8,9,10},55));
        System.out.println(solution(new int[] {4,3,3,8,1,2,3},11));
        System.out.println(solution(new int[] {1,4,16,22,5,7,8,9,10},95));

    }

    private static int solution(int[] arry, int sum) {
        int minLen = 0;
        int tmpSum = 0;

        for (int i = 0 ; i < arry.length ; i++) {
            tmpSum += arry[i];
            if(tmpSum >= sum)
            {
                minLen = i + 1 ;
                break;
            }

        }
        for(int i = 0; i < arry.length && minLen > 1; i++){

            tmpSum = tmpSum - arry[i];
            if( tmpSum >= sum) {
                minLen--;
            }
            else if ((minLen + i) < arry.length){
                tmpSum +=  arry[minLen + i];
            }

        }
        return  minLen;
    }
}
