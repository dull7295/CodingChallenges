/**
 * Created by dullam on 2/10/18.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class AllSubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int max = 1 << nums.length;
        int k =0, pos=0;
        for(int i=0; i < max ; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            k =i;
            pos=0;
            while(k > 0) {
                if( (k & 1) > 0) subset.add(nums[pos]);
                k = k >> 1;
                pos++;
            }
            res.add(subset);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        if( s == null || (s != null && s.length() ==0) ) return 0;

        int[] LS = new int[s.length()];
        boolean[] arr = new boolean[256];
        Arrays.fill(arr, false);
        int max =1;
        LS[0] = 1;
        arr[s.charAt(0)] = true;
        for(int i=1; i < s.length(); i++) {
            if(!arr[s.charAt(i)]) {
                arr[s.charAt(i)] = true;
                LS[i] = LS[i-1] + 1;
            } else {
                Arrays.fill(arr, false);
                LS[i] = 1;
                arr[s.charAt(i)] = true;
            }
            if(LS[i] > max) max = LS[i];
        }

        for(int i:  LS) System.out.println(" " + LS[i]);
        return max;

    }

    public  static void main(String[] args) {
        AllSubSets obj = new AllSubSets();
        obj.lengthOfLongestSubstring("dvdf");
    }

}
