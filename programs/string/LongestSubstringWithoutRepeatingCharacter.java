package string;

import java.util.HashMap;
import java.util.Map;

/*
        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        Complexity Analysis

        Bruteforce - Time complexity : O(n^3)O(n
                    Space complexity : O(min(m, n))O(min(m,n)). Same as the previous approach.
                                        We need O(k)O(k) space for the sliding window,
                                        where kk is the size of the Set. The size of
                                        the Set is upper bounded by the size of the string nn
                                         and the size of the charset/alphabet mm
         Sliding window (with array or hashmap)- O(n)
                    Space complexity : same as above





 */

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring_bruteforce(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private static boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }


    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            chars[c]++;
            while (chars[c] > 1) {
                chars[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;

        }
        return result;

    }

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {

            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            map.put(s.charAt(right), right + 1);
            result = Math.max(result, right - left + 1);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }
}
