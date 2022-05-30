package string;/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false

complexity O(n)

*/

class ValidPalindrome1 {
    private boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;   
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        int count = 0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return (checkPalindrome(s,i+1,j) || checkPalindrome(s,i,j-1));
                
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome1().validPalindrome("abcdcbaf"));
    }
}
