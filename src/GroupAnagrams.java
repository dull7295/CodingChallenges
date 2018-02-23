/**
 * Created by dullam on 7/28/17.
 */
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;
public class GroupAnagrams {
    public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
          return compare(o1,o2);
        }
    }
    public String[] groupAnagrams(String[] strs) {
        HashMap<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();
        int size=0;
        for (String str : strs) {
            char[] s1Array = str.toLowerCase().toCharArray();
            Arrays.sort(s1Array);
            String ns = new String(s1Array);
//            System.out.println("**** "+ ns);
            if (map.containsKey(ns)) {
                map.get(ns).add(str);
                if(map.get(ns).size() == 2) size++;
            } else {
                TreeSet<String> al = new TreeSet<String>(Collections.reverseOrder());
                al.add(str);
                map.put(ns, al);
            }
        }
        size = 2*size;
        String[] result = new String[size];
        int k =0;
        for(String s: map.keySet()) {
            if (map.containsKey(s) && map.get(s).size() >= 2) {
                TreeSet<String> ts = map.get(s);
                String val = " ";
                for(String ss: ts) {
                    val = val + ss + " ";
                }
                result[k] = val;k=k+1;
                result[k] = "\n";k=k+1;
            }
        }
        for(String str: result)
        System.out.println("" +str);
        return result;
    }

    public static void main(String[] args){


        new GroupAnagrams().groupAnagrams(new String[]{"hghj","jhgh","llllll","poiuytr","abcd","dcab","madam","cdba","adama","mnbv","vbnm"});
    }
}