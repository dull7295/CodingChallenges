/**
 * Created by dullam on 8/2/17.
 */
public class QuickSelection {


    public static void main(String[] args) {
        int[] numbers = { 26, 19, 14, 10, 31 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
        int k=5;
        int l = quickSelectIndex(numbers, 0, numbers.length - 1,k-1);
        System.out.println("\n");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }

        System.out.println(" ");

        System.out.println(numbers[l]);
    }

    public static int quickSelectIndex(int[] numberToSort, int low, int high,int k) {
        int p = partition(numberToSort, low, high);
        if (k == p) {
            return p;
        }
        if (k < p) {
            return quickSelectIndex(numberToSort, low, p - 1,k);
        } else {
            return quickSelectIndex(numberToSort, p + 1, high,k);
        }

    }

    public static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int i, j;
        i = low + 1;
        j = high;
        int temp;
        while (i < j) {
            while (i <= high)
                if (numbers[i] <= pivot) {
                    i++;
                } else {
                    break;
                }
            while (j >= low) {
                if (numbers[j] > pivot) {
                    j--;
                } else {
                    break;
                }
            }
            if (i < j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        temp = numbers[low];
        numbers[low] = numbers[j];
        numbers[j] = temp;

        return j;
    }
}