/**
 * Created by dullam on 3/12/18.
 */
public class DutchFlag {
    static void sort012(int[] a, int size) {
        /*
        * 0   ... low-1    0 * low ... mid-1    1
        * mid ... high-1   * * high ... N       2
        * */

        int low=0,mid=0,high = size-1, temp =0;
        while(mid <= high) {
            switch(a[mid]) {
                case 0:
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
            }
        }
    }
    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }
}
