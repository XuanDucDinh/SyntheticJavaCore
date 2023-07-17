import com.sun.istack.internal.NotNull;

public class LongestCommonPrefix {
    /*    Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".

        Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
        Constraints:
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lowercase English letters
        */

    public static String longestCommonPrefix(@NotNull String[] strs) {
        String commons = "";
        if (strs.length >= 1 || strs.length <= 200) {
            commons = strs[0];
            for (int i = 1; i < strs.length ; i ++) {
                while (strs[i].indexOf(commons) != 0) {
                    commons = commons.substring(0, commons.length() -1);
                }
            }
        }
        return commons;

    }

    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        System.out.println("Output : " + longestCommonPrefix(strs));

    }
    /*things have learned */
}
