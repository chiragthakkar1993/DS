package string;

/*
        Write a function that reverses a string. The input string is given as an array of characters s.

        You must do this by modifying the input array in-place with O(1) extra memory.



        Example 1:

        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
        Example 2:

        Input: s = ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]

 */

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        int n = s.length - 1;

        int count = 0;
        for (int i = 0; count <= n; i++) {
            char curChar = s[i];
            int curIndex = i;
            do {
                int nextIndex = n - curIndex;
                char nextChar = s[nextIndex];

                s[nextIndex] = curChar;
                curIndex = nextIndex;
                curChar = nextChar;
                count++;
            }while(i != curIndex);

        }
    }
    public static void reverseString2(char[] s) {
       int left = 0;
       int right = s.length-1;
       while(left<right){
           s[left] ^= s[right];
           s[right] ^= s[left];
           s[left++] ^= s[right--];
        }
    }

    public static void main(String[] args) {
        char arry1[] = {'h','e','l','l','o'};
        reverseString2(arry1);
        for (char ch:
             arry1) {
            System.out.print(ch+" ");
        }

    }
}
