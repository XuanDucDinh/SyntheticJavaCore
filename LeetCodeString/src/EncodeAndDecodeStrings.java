import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {
    final char DELIMITER = '#';

    /*
    * Description
    Design an algorithm to encode a list of strings to a string.
    *  The encoded string is then sent over the network and is decoded back to the original list of strings.

    Please implement encode and decode

    Example
    Example1

    Input: ["lint","code","love","you"]
    Output: ["lint","code","love","you"]
    Explanation:
    One possible encode method is: "lint:;code:;love:;you"
    Example2

    Input: ["we", "say", ":", "yes"]
    Output: ["we", "say", ":", "yes"]
    Explanation:
    One possible encode method is: "we:;say:;:::;yes"*/
    //Encode a list of String to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodeContext = new StringBuilder();
        for (String str : strs) {
            encodeContext.append(str.length());
            encodeContext.append(DELIMITER);
            encodeContext.append(str);
        }
        return encodeContext.toString();
    }

    //Decode a single string to a list of string
    public List<String> decode(String str) {
        List<String> res = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // find the number of character
            StringBuilder sb = new StringBuilder();
            while (chars[i] != DELIMITER) {
                sb.append(chars[i++]);
            }
            i++;
            int numberOfChars = Integer.valueOf(sb.toString());
            int end = i + numberOfChars;
            // Iteration to enter character to string and add string to list.
            sb = new StringBuilder();
            while (i < end) {
                sb.append(chars[i++]);
            }
            i--;
            res.add(sb.toString());
        }
        return res;

    }

}
