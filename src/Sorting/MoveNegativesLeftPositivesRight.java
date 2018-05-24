package Sorting;

/**
 * Created by dullam on 3/9/18.
 *
 *
 * By preserving order of the original array
 * O(nlogn) TimeComplexity
 *
 */
public class MoveNegativesLeftPositivesRight {

    public static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid+1, k = 0;
        int[] temp = new int[high+1];

        while(i <= mid && a[i] < 0 )
                temp[k++] = a[i++];

        while(j <= high && a[j] < 0 )
            temp[k++] = a[j++];

        while(i <= mid)
            temp[k++] = a[i++];

        while(j <= high)
            temp[k++] = a[j++];

        k = 0;
        for(int l = low; l <= high; l++) {
           a[l] = temp[k++];
        }

    }
    public static void rearrangePosNeg(int[] a, int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;
            rearrangePosNeg(a, low, mid);
            rearrangePosNeg(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    public static void main (String[] args)
    {
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int arr_size = arr.length;
        rearrangePosNeg(arr, 0, arr_size - 1);
        for(int i:arr)
            System.out.print("  "+i);
    }
}
