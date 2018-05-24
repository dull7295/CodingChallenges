/**
 * Created by dullam on 4/7/18.
 */
import java.util.*;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subsets(nums, nums.length, res);
        res.add(new ArrayList<Integer>());
        return res;
    }

    public void subsets(int[] nums, int len, List<List<Integer>> res) {
        if(len > 0)  {
            List<List<Integer>> ss = new ArrayList<List<Integer>>();
            subsets(nums, len-1, ss);
            List<Integer> aList;
            for(List<Integer> li: ss) {
                aList = new ArrayList<Integer>(li);
                aList.add(nums[len-1]);
                res.add(li);
                res.add(aList);
            }
            aList = new ArrayList<Integer>();
            aList.add(nums[len-1]);
            res.add(aList);
        }
    }

    public  static void main(String[] args) {
        SubSets obj = new SubSets();
        List<List<Integer>> res = obj.subsets(new int[]{1,2,3,4});
        for(List<Integer> l: res) {
            System.out.println(" " + l);
        }
    }
}