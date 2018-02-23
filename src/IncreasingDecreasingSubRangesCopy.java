/**
 * Created by dullam on 8/19/17.
 */
import java.util.Random;

public class IncreasingDecreasingSubRangesCopy {

    public static void getIncreasingSubArrays(int[] a, int k) {
        if(a.length < k) {
            System.out.println("Sorry Bad Input");
            return;
        }
        int n=a.length, incCount=1,currentIncreasingRanges=0;
        int  decCount=1,currentDecreasingRanges=0;
        int[] incPathArray = new int[n];
        int[] decPathArray = new int[n];



        for(int i=0;i<n;i++)  {
            incPathArray[i] = 0;
            decPathArray[i] = 0;
        }

        for(int i=0;i<k-1;i++) {
            if(a[i] < a[i+1]) {
                incCount++;
                int temp=incCount,j=i;
                while(temp > 1) {
                    incPathArray[j] = incPathArray[j]+1;
                    temp--;
                    j--;
                }

                currentDecreasingRanges += decCount*(decCount-1)/2;
                decCount=1;


            } else {
                decCount++;
                int temp=decCount,j=i;
                while(temp > 1) {
                    decPathArray[j] = decPathArray[j]+1;
                    temp--;
                    j--;
                }

                currentIncreasingRanges += incCount*(incCount-1)/2;
                incCount=1;
            }
        }
        if(incCount > 1) {
            currentIncreasingRanges += incCount*(incCount-1)/2;
        }
        if(decCount > 1) {
            currentDecreasingRanges += decCount*(decCount-1)/2;
        }

        System.out.println(" 1st window " + (currentIncreasingRanges-currentDecreasingRanges));

        for(int i=k-1;i<=n-k+1;i++) {
            int leavingEffectInc= incPathArray[i-k+1],addingEffectInc=0;
            int leavingEffectDec= decPathArray[i-k+1],addingEffectDec=0;

            /* ae */
            if(a[i] < a[i+1] && incCount == k) {
                incCount = k;
                int temp = incCount,j=i;
                while(temp > 1 ) {
                    incPathArray[j] = incPathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if (a[i] < a[i+1]) {
                incCount++;
                int temp = incCount,j=i;
                while(temp > 1 ) {
                    incPathArray[j] = incPathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if(a[i] >= a[i+1] ) {
                incCount=1;
            }


            if(a[i] > a[i+1] && decCount == k) {
                decCount = k;
                int temp = decCount,j=i;
                while(temp > 1 ) {
                    decPathArray[j] = decPathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if (a[i] > a[i+1]) {
                decCount++;
                int temp = decCount,j=i;
                while(temp > 1 ) {
                    decPathArray[j] = decPathArray[j]+1;
                    temp--;
                    j--;
                }
            } else if(a[i] <= a[i+1] ) {
                decCount=1;
            }

            addingEffectInc = incCount - 1;
            addingEffectDec = decCount - 1;

            currentIncreasingRanges = currentIncreasingRanges-leavingEffectInc+addingEffectInc;
            currentDecreasingRanges = currentDecreasingRanges-leavingEffectDec+addingEffectDec;

            System.out.println( " window " + (currentIncreasingRanges-currentDecreasingRanges));
        }
    }
    public static void main(String[] args) {
        int[] a = {188930 ,194123, 201345, 154243, 154243};

        int[] aR = new int[200000];
        int  p=0;
        for(int l=0;l<200000;l++) {
//            Random rand = new Random();
//            p = rand.nextInt(50) + 1;
            aR[l] = l;
        }



        getIncreasingSubArrays(aR,3000);
    }
}
