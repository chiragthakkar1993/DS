package string;

import java.util.*;

/*
        Given an array of strings, group all anagrams together

        using hash map

              Time Complexity: O(N K log K), where N is the length of strs, and K is the maximum length of a string in strs.
              The outer loop has complexity O(N) as we iterate through each string.
              Then, we sort each string in O((K log K) time.

              Space Complexity: O(NK), the total information content stored in ans.

         using groupby frequency string

                Time Complexity: O(NK)
                Space Complexity: O(NK)

 */
public class GroupByAnagram {

    public static List<List<String>> groupAnagramsCategorizeByFrequency(String[] strs) {

        // Check for empty inputs
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        for (String str : strs) {

            String frequencyString = getFrequencyString(str);

            // If the frequency string is present, add the string to the list
            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            }
            else {
                // else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }
        System.out.println(frequencyStringsMap);
        return new ArrayList<>(frequencyStringsMap.values());
    }

    private static String getFrequencyString(String str) {

        // Frequency buckets
        int[] freq = new int[26];
        char aChar = 'a';
        Arrays.fill(freq,0);

        // Iterate over each character

        for (char c : str.toCharArray()) {
            freq[c - aChar]++;
        }

        // Start creating the frequency string
        StringBuilder frequencyString = new StringBuilder("");

        for(int i =0 ;i< 26;i++){
            if(freq[i]>0) {
                frequencyString.appendCodePoint(aChar + i);
                frequencyString.append(freq[i]);
            }
        }
        return frequencyString.toString();
    }

    public static Map<String, List<String>> groupByAnagrams(String[] arry){
        Map<String, List<String>> anagramGrouping = new HashMap<>();

        for (String str:arry) {
            String sortedStr = str.chars().sorted().collect(
                    StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append
            ).toString();

            if (anagramGrouping.get(sortedStr) != null)
                anagramGrouping.get(sortedStr).add(str);
            else {
                List<String> words = new ArrayList<>();
                words.add(str);
                anagramGrouping.put(sortedStr, words);
            }
        }

        return anagramGrouping;
    }

    public static void main(String[] args) {
        System.out.println(groupByAnagrams(List.of("cat", "dog", "tac", "god", "act").stream().toArray(String[]::new)));
        System.out.println(groupAnagramsCategorizeByFrequency(List.of("catt", "dog", "ttac", "god", "act").stream().toArray(String[]::new)));
    }

}
