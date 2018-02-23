import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * Created by dullam on 7/18/17.
 */
public class BinaryDigits {

    public void printBinaryDigits(int[] a) {
        Stack<Integer> binaryStack = new Stack<>();
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();
        int n = 1 << a.length;
        for(int i=0;i<n;i++){
            int index=0;
            int k=i;
            ArrayList subset = new ArrayList<Integer>();
            while( k > 0 ) {
                if((k & 1) > 0) { /* Checking if last digit is 1 or not */
                    binaryStack.push(1);
                    subset.add(a[index]);
                }
                index++;
                k= k>>1; /* Right shift to 1*/
            }
            subSets.add(subset);
        }
        for(ArrayList<Integer> list:subSets) {
            System.out.print(""+list);
        }
    }

    public static void main(String[] args) {
        new BinaryDigits().printBinaryDigits(new int[] {1,2,3});
        System.out.println("\n");

    }
}
