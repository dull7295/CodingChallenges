/**
 * Created by dullam on 4/13/18.
 */
import java.util.*;
import java.util.LinkedList;

public class PallindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res =  new ArrayList<List<String>>();
        helper(s,s.length(),0,new ArrayList<String>(), (ArrayList<List<String>>) res);
        for(List<String> lis : res) {
            System.out.println(lis);
        }
        return res;
    }

    public void helper(String s , int len , int j, List<String> lis, ArrayList<List<String>> res) {
        if(j == len)  {
            res.add(new ArrayList<String>(lis));
        } else {
            for(int i=j; i < len; i++) {
                String str = s.substring(j,i+1);
                if(isPallindrome(str)) {
                    lis.add(str);
                    helper(s, len,i+1,lis, res);
                    lis.remove(lis.size()-1);
                }
            }
        }

    }
    private boolean isPallindrome(String s) {
        if(s.equals(new StringBuilder(s).reverse().toString())) return true;
        return false;
    }

    public static void main(String[] args) {
        PallindromePartition pallindromePartition = new PallindromePartition();
        pallindromePartition.partition("abaa");
    }

}
