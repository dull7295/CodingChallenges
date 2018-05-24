package Sorting; /**
 * Created by dullam on 7/14/17.
 */


import java.util.Scanner;
public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Scanner sc = new Scanner(System.in);
        int[] numbers = {34,2,35,67,12345,89,3,5,92};
        //int[] numbers = {10,19,14};

        System.out.println("Before Sort");
        for(int i:numbers) System.out.print(" " + i);
        System.out.println("\n**************");
        quickSort(numbers,0,numbers.length-1);
        System.out.println("After Sort");
        for(int i:numbers) System.out.print(" " + i);
        System.out.println("\n**************");

    }
    public static void quickSort(int[] numbers,int low,int high) {
        int p;
        if(low < high) {
                p = partition(numbers, low,high);
                quickSort(numbers, low,p-1);
                quickSort(numbers, p+1,high);
            }
    }
    private static int partition(int[] numbers, int low, int high) {
        // TODO Auto-generated method stub
        int pivot = numbers[low];
        int i = low+1,j=high;
        int temp;
        do {
            for(;i<=high && numbers[i]>= pivot;) i++;
            for(;j>=low && numbers[j]< pivot; ) j--;
            if(i < j ) {
                temp = numbers[i];
                numbers[i] =numbers[j];
                numbers[j] = temp;
            }
        } while(i<j);
        temp= numbers[low];
        numbers[low]=numbers[j];
        numbers[j]=temp;
        return j;
    }
}