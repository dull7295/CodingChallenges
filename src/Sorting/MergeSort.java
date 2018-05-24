package Sorting;

/**
 * Created by dullam on 7/15/17.
 */
public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Scanner sc = new Scanner(System.in);
        int[] numbers = {14,33,27,10,35,19,42,44};
        System.out.println("Before Sort");
        for(int i:numbers) System.out.print(" " + i);
        System.out.println("\n **************     **************");
        MergeSort obj = new MergeSort();
        obj.mergeSort(numbers,0,numbers.length-1);
        System.out.println("-------- After Merge Sort ------------");
        for(int i:numbers) System.out.print(" " + i);
        System.out.println("\n************         **************");

        System.out.println("\n************         **************" + (9&1));

    }


    public void mergeSort(int[] a, int low,int high){
        if(low<high) {
            int mid = (low+high)/2;
            mergeSort(a,low, mid);
            mergeSort(a,mid+1, high);
            merge(a,low,mid,high);
        }
    }

    public void merge(int[] a, int low, int mid, int high) {

        int i=low, j=mid+1;
        int[] c= new int[high+1];
        int p=0;
        while(i<=mid&&j<=high) {
            if(a[i] > a[j]) {
                c[p++] = a[i++];
            }else {
                c[p++] = a[j++];
            }
        }
        while(i<=mid){
            c[p++]=a[i++];
        }
        while(j<=high){
            c[p++]=a[j++];
        }
        p=0;
        for(int k=low;k<=high;k++){
            a[k]=c[p++];
        }

    }

}
