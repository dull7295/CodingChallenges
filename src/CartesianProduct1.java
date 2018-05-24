/**
 * Created by dullam on 5/1/18.
 */
public class CartesianProduct1 {
    private boolean gameOf24(int length, int target, int... arr) {
        if(arr.length == 1)
            if(arr[0] == target)
                return true;
            else
                return false;
        boolean[] b = new boolean[3*length*(length-1)];
        int temp = 0;
        for(int i=0; i < length-1; i++) {
            for(int j=i+1; j < length-1; j++) {
               //b[temp++] = gameOf24(length-1,target, arr[i] + arr[j],);
              // b[temp++] =

            }
        }

        return false;
    }


    public static void main(String[] args) {
        /*  A B  C   1 2 3*/

        // A1 A2 A3 B1 B2 B3 C1 C2 C3


    }
}
