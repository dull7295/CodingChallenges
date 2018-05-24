package LongestSubstring;

/**
 * Created by dullam on 7/21/17.Quiet Revolution   b
* "cv xzt01-0Zaq1`  q   `   `123
 */
public class LongestIncreasingSequence {

    public void findLIS(int[] a){
        int n =a.length;
        int[] lis = new int[n];
        for(int i=0; i< n; i++) {
            lis[i] = 1;
        }

        for(int i = 1;i<n;i++) {
            int max=0;
            int profit=0;
            for(int j=0;j<i-1;j++) {
                if(a[j] < a[i]) {
                    profit = a[i]-a[j];
                    if (profit > max) {
                        max=profit;
                    }
                    lis[i] = profit;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println("At element  " + a[i] + " we have lis  " + lis[i]);

        }

    }


    public static void main(String[] args) {
        LongestIncreasingSequence lis = new LongestIncreasingSequence();
        lis.findLIS(new int[]{5,1,8,13,16,2,7,18,2,23});
    }
}
