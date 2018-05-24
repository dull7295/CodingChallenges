import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * Created by dullam on 7/7/17.
 */
public class Anagram {

    public void Solution() {

        String str1 = "abcdfghtacdbah";
        String needle = "abcd";

        for(int i=0 ; i< str1.length(); i++) {

            String str = str1.substring(i,needle.length());
            System.out.println("" +str);

        }
    }

    public static void main(String[] args) {
        while(true) {

            int max = Integer.MAX_VALUE;
            int y = max+100;

            System.out.println(" the value of max is " + max);
            System.out.println(" the value of may is " + y);

            System.out.println(" the value of min is " + Integer.MIN_VALUE);

            System.out.println("Enter strings to check if they are anagrams");

            Scanner sc = new Scanner(System.in);
            String str1=  sc.nextLine();
            String str2 = sc.nextLine();


            HashMap<Character,  Integer> map1 = new HashMap<>();
            HashMap<Character,  Integer> map2 = new HashMap<>();
            boolean areTheyanagrams =true;

            for (char c : str1.toCharArray()) {
                if (c != ' ') {
                    if(!map1.containsKey(c))
                        map1.put(Character.toLowerCase(c),1);
                    else
                        map1.put(c, map1.get(c)+1);
                }
            }

            for (char c : str2.toCharArray()) {
                if (c != ' ') {
                    if(!map2.containsKey(c))
                        map2.put(Character.toLowerCase(c),1);
                    else
                        map2.put(c, map2.get(c)+1);
                }
            }
            Set<Map.Entry<Character, Integer>> entrySet = map1.entrySet();

            for(Map.Entry e: entrySet) {
               System.out.println("key-- > " + e.getKey() + "  value -- > " + e.getValue());

            };
            int i =0;
            for ( i=0;i< 3; ++i) {
                System.out.println(++i);
            }
            System.out.println("after loop pre increment " + i);

            for (i=0;i< 3; i++) {
                System.out.println(i++);
            }
            System.out.println("after loop post increment" + i);


            String str = new String("Murali Krishna Dulla");
            char[] cArray = str.toCharArray();
            System.out.println(cArray[0]);
            System.out.println(cArray[1]);
            System.out.println('a');

            int x = 'a';

            System.out.println(x);


            for(Character c : map1.keySet()) {
               if( map2.containsKey(c) )
               {
                  if(map1.get(c) != map2.get(c)) {
                      areTheyanagrams = false;
                      break;
                  }
               } else {
                   areTheyanagrams = false;
                   break;
               }
            }

            if(areTheyanagrams) {
                System.out.println(str1 + " is an anagram of " + str2);

            } else {
                System.out.println(str1 + " is not an anagram of " + str2);

            }
        }

    }

}
