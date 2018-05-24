package Sorting;

/**
 * Created by dullam on 3/22/18.
 */
public class InsertionSort {

    public static void insertionSort(int[] a) {
        int temp;
        int key;
        for(int i=1; i< a.length; i++) {
            key = a[i];
            int j = i-1;
            while(j>=0 && a[j] > key) {
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                j--;
            }
        }

        for(int i: a) {
            System.out.print(" " +i);
        }
    }


    public static void insertionSortNegPos(int[] a) {
        int temp;
        int key;
        for(int i=1; i< a.length; i++) {
            int j = i-1;
            while(a[j] > 0 && j>=0 && a[j+1] < 0) {
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                j--;
            }
        }

        for(int i: a) {
            System.out.print(" " +i);
        }
    }
    public static void main (String[] args)
    {
        int arr[] = { 34,2,35,67,1,89,3,5,92 };
        //insertionSort(arr);

        int arr1[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        insertionSortNegPos(arr1);
    }

}
