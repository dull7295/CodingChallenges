/**
 * Created by dullam on 1/12/18.
 */
public class BubbleSort
{
    private void bubble_it(int[] a) {
        for(int i=0; i < a.length-1; i++) {
           for(int j=0;j< a.length-i-1;j++) {
                 if(a[j] > a[j+1]) {
                     int temp = a[j];
                     a[j] =a[j+1];
                     a[j+1] = temp;
                 }
           }

        }

        for(int i=0;i<a.length;i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {8,1,4,3,5};
        BubbleSort bs = new BubbleSort();
        bs.bubble_it(a);
    }
}
