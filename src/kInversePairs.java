/**
 * Created by dullam on 3/7/18.
 */
public class kInversePairs {
    public int kInversePairs(int n, int k) {
        /**/
        int count = 0;
        if(n == 0) return 0;
        if(k == 0 ) return 1;
        for(int i=0; i< Math.min(n-1,k); i++) {
            count = count + kInversePairs(n-1,k-i);
        }
        return count;
    }

    public static void main(String[] args) {
        kInversePairs kInversePairs = new kInversePairs();
        System.out.print(kInversePairs.kInversePairs(8,2));
    }
}
