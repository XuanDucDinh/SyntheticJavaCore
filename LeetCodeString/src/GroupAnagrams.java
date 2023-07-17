import java.util.*;

public class GroupAnagrams {
        /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example 2:

    Input: strs = [""]
    Output: [[""]]
    Example 3:

    Input: strs = ["a"]
    Output: [["a"]]

    Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
    */

    public static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            // generateKey
            String key = generateKey(str);
            if(maps.containsKey(key)){
                maps.get(key).add(str);
            } else {
                List<String> anagrams = new LinkedList<>();
                anagrams.add(str);
                maps.put(key, anagrams);
            }

        }
        return new ArrayList<>(maps.values());


    }

    public static String generateKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(strs));
    }

}
