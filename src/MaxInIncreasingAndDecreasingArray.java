/**
 * Created by dullam on 3/8/18.
 */


class MaxInIncreasingAndDecreasingArray {
    private static int index = -1;
    public static void main (String[] args) {
        int[] a = new int[]{1,2,3,5,3,2,1};
//     int[] a = new int[]{1,20,5,4,3,2,1};
        findPeak(a,0,a.length);
        System.out.println("index of max element is at " + index);
    }


    private static int findPeak(int a[], int low, int high) {
        if(low == high) {
            index = low;
            return a[low];
        }

        if(high == low+1 && a[low] >= a[high]) {
            index = low;
            return a[low];
        }

        if(high == low+1 && a[low] < a[high]) {
            index = high;
            return a[high];
        }

        int mid = (low + high)/2;

        if(a[mid] > a[mid+1] && a[mid] > a[mid-1]) {
            index = mid;
            return a[mid];
        }



        if(a[mid] > a[mid+1] && a[mid] < a[mid-1])
            return findPeak(a, low, mid-1);
        else
            return findPeak(a, mid+1, high);


    }
}



/*


1,5, 3,2,1,0
input: [1, 2, 3, 4, 5, 4, 3, 2, 1]
Find the index of the peak. (in this case,4)
1.) There is one and only one peak.
2.) Negative values are allowed
3.) No plateau meaning the following array will never be given [1,2,3,3,3,2,1,1,1]

*/