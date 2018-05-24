package LongestSubstring;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by dullam on 4/1/18.
 */
public class LongestSubstringWithAtmost2DistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, end = 0, len = s.length(), counter = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(end < len) {
            char c = s.charAt(end);
            if(!map.containsKey(c) || map.get(c) == 0) {
                map.put(c,1);
                counter++;
            } else
                map.put(c,map.get(c)+1);

            while(counter > 2) {
                max = Math.max(max,end-start);
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0) counter--;
                start++;
            }
            end++;
        }
        return Math.max(max, end-start);
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end =0, len = s.length(), counter = 0, minLength = len+1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray())
        {
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        while(end < len) {
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c) >= 0)
                    counter++;
            }
            while(counter == 0) {
                minLength = Math.min(minLength, end-start+1);
                if(map.containsKey(c)) {
                    map.put(c,map.get(c)+1);
                    if(map.get(c) > 0 ) counter--;
                }
                start++;
            }
            end++;
        }

        return minLength;
    }


    public static void main(String[] args) {
       String st1 = "abcdefffgggh";
       System.out.println("Longest Substring for " + st1 + " is " + lengthOfLongestSubstringTwoDistinct(st1));


        System.out.println("Longest Substring for " + st1 + " is " + lengthOfLongestSubstring(st1));

    }
}
