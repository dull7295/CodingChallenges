import java.util.List;

/**
 * Created by dullam on 4/7/18.
 */
public class EqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum += i;
        if(sum%2 != 0) return false;
        return canPartitionHelper(nums, nums.length, sum/2) >= 2;
    }
    public int canPartitionHelper(int[] nums, int len, int sum) {
        if(sum == 0 || (len == 1 && sum-nums[0] == 0)) return 1;
        if( sum < 0  || (len == 1 && sum-nums[0] != 0)) return 0;
        return canPartitionHelper(nums, len-1, sum) + canPartitionHelper(nums, len-1, sum-nums[len-1]);
    }

    public  static void main(String[] args) {
        EqualSubsetSum obj = new EqualSubsetSum();
        System.out.println(" Subsets  " + obj.canPartition(new int[]{1,5,11,5}));
    }

}