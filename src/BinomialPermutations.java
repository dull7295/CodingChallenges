import java.util.HashSet;
import java.util.Random;
/**
 * Created by dullam on 2/22/18.
 */
public class BinomialPermutations {

    public static void getBinPermutations(int n) {
        int s = 1 << n;
        StringBuffer sb = new StringBuffer();
        HashSet<String> res = new HashSet<>();
        for(int i=0; i < s; i++) {
            int k=i;
            for(int j=0; j< n ;j++) {
                /*Right Shift*/
                if((k & 1) == 0)
                    sb.append("A");
                 else
                     sb.append("B");
                 k = k >> 1;
            }
            res.add(sb.toString());
            sb = new StringBuffer();

        }
        for(String st: res) {
            System.out.print("  " +st);
        }

    }

    public static void main(String[] args) {
        //BinomialPermutations.getBinPermutations(6);
        getDiceResult("12d34");
    }

    public static int getDiceResult(String str) {
        int result = 0;
        int left = 0;
        int right = 0;
        int i =0;
        while(i < str.length() && str.charAt(i) != 'd') {
            //if(str.charAt(i) <= 9 && str.charAt(i) >=1) {
            Character c = str.charAt(i);
            left = left * 10 + Character.getNumericValue(c);
            i++;
            //}

        }

        while(i < str.length()) {
            Character c = str.charAt(i);
            right = right * 10 + Character.getNumericValue(c);
        }

        Random  r = new Random();
        result = r.nextInt(right);
        result = left*result;
        System.out.print("   hey " +result);
        return result;
    }
}
