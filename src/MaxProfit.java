/**
 * Created by dullam on 7/21/17.Quiet Revolution   b
* "cv xzt01-0Zaq1`  q   `   `123
 */
public class MaxProfit {

    public void findLIS(int[] a){
        int n =a.length;
        int[] mp = new int[n];
        for(int i=0; i< n; i++) {
            mp[i] = 0;
        }

        for(int i = 1;i<n;i++) {
            int max=0;
            int profit=0;
            for(int j=0;j<i-1;j++) {
                profit = a[i]-a[j];
                if (profit > max) {
                    max=profit;
                }
                mp[i] = max;
            }
        }

        for(int i=0;i<n;i++){
            System.out.println("At element  " + a[i] + " we have lis  " + mp[i]);

        }

    }


    public static void main(String[] args) {
        MaxProfit lis = new MaxProfit();
        lis.findLIS(new int[]{10, 7, 5, 8, 11, 9,21});
    }
}
