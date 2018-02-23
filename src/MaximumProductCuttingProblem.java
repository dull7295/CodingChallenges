/**
 * Created by dullam on 7/25/17.
 */
import java.lang.Math;
public class MaximumProductCuttingProblem {

    public int rodcut(int n) {
        if(n<=1) return n;
        int max=n;
        for(int i=1;i<=n;i++)
            max = Math.max(n, rodcut(i*(n-i)));
        return max;
    }

    public int rodcutDP(int n){
        int[] T = new int[n+1];
        T[0]=1;
        for(int i=1;i<=n;i++) {
            int max=i;
            for(int j=1;j<=i;j++) {
                if(Math.max(max,j*T[i-j]) > max){
                 max = Math.max(max,j*T[i-j]);
                }
            }
            T[i]=max;
        }
        for(int i:T)
        {
            System.out.println(""+i);
        }
      return T[n];
    }

    public static void main(String[] args) {
     //System.out.println("Rod cut of size by 5 when max profit " + new MaximumProductCuttingProblem().rodcut(4));
        System.out.println("Rod cut of size by 5 when max profit dp " + new MaximumProductCuttingProblem().rodcutDP(15));

    }
}
