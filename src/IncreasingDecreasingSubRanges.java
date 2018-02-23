/**
 * Created by dullam on 8/19/17.
 */
public class IncreasingDecreasingSubRanges {

    public static void getIncreasingSubArrays(int[] a, int k) {
        if(a.length < k) {
            System.out.println("Sorry Bad Input");
            return;
        }
        int n=a.length, count=1,currentNumberOfSequences=0;
        int[] pathArray = new int[n];
        for(int i=0;i<n;i++) pathArray[i]=0;
        for(int i=0;i<k-1;i++) {
            if(a[i] < a[i+1]) {
                count++;
                int temp=count,j=i;
                while(temp > 1) {
                    pathArray[j] = pathArray[j]+1;
                    temp--;
                    j--;
                }
            } else {
                currentNumberOfSequences += count*(count-1)/2;
                count=1;
            }
        }
        if(count > 1) {
            currentNumberOfSequences += count*(count-1)/2;
        }

        System.out.println(" 1st window " + currentNumberOfSequences);

        for(int i=k-1;i<=n-k+1;i++) {
            int le= pathArray[i-k+1],ae=0;
            /* ae */
            if(a[i] < a[i+1] && count == k) {
                count = k;
                int temp = count,j=i;
                while(temp > 1 ) {
                    pathArray[j] = pathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if (a[i] < a[i+1]) {
                count++;
                int temp = count,j=i;
                while(temp > 1 ) {
                    pathArray[j] = pathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if(a[i] >= a[i+1]) {
                count=1;
            }
            ae = count -1;

            currentNumberOfSequences = currentNumberOfSequences-le+ae;
            System.out.println( " window " + currentNumberOfSequences);
        }



    }
    public static void main(String[] args) {
        int[] a = { 2,3,4,5,6,1,2,3,4,5,2};
        getIncreasingSubArrays(a,4);
    }
}
