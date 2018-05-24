/**
 * Created by dullam on 4/10/18.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int j = partition(nums, start, end);
        if(j == k-1) return nums[j];
        else if(j < k-1)
            return quickSelect(nums, j+1, end,k);
        else
            return quickSelect(nums, start, j-1,k);
    }

    public  int partition(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int i, j;
        i = low + 1;
        j = high;
        int temp;
        while (i <= j) {
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
            if (i <= j) {
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

    public static void main(String[] args) {
        FindKthLargest fkl = new FindKthLargest();
        System.out.println(" Kth Largest is " + fkl.findKthLargest(new int[]{2,1 },1));
        System.out.println(" Kth Largest is " + fkl.findKthLargest(new int[]{1},1));

    }
}
