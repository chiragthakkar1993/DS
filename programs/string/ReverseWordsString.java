package string;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



    Example 1:

    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Example 2:

    Input: s = "God Ding"
    Output: "doG gniD"
 */
public class ReverseWordsString {
    public static String solution(String s) {
        String words[] = s.split("\\s");
        for (int i = 0; i < words.length; i++) {
           words[i] = reverseWord(words[i]);
        }
        return Arrays.stream(words).collect(Collectors.joining(" "));
    }

    private static String reverseWord(String word) {
        int left = 0;
        int right = word.length() - 1;
        char[] chars = word.toCharArray();
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left++] ^= chars[right--];
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution("Let's take LeetCode contest"));
    }
}
