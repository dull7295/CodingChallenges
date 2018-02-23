import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by dullam on 7/17/17.
 */
/*Dynamic Programming*/
public class LongestCommonSubstring {
    private class LCSUtility {
        int lengthOfLCS;
        ArrayList<String> lcsList;
        LCSUtility() {
            lcsList = new ArrayList<>();
            lengthOfLCS=0;
        }
    }
    public int findLCSInRecursiveWay(CharSequence str1, CharSequence str2) {

        System.out.println(" " +str1+ " " + str2 );

        if(str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        if( str1.charAt(0) != '\u0000' && str1.charAt(0) == str2.charAt(0)) {
            System.out.println(" Calling " +str1.subSequence(1,str1.length()) + " " + str2.subSequence(1,str2.length()) );

            return 1 + findLCSInRecursiveWay(str1.subSequence(1,str1.length()),str2.subSequence(1,str2.length()));
        } else {
            return findLCSInRecursiveWay(str1.subSequence(1,str1.length()),str2.subSequence(1,str2.length()));
        }
    }


    public LCSUtility findLongestCommonSubstring(String str1,String str2) {
      int[] lcs = new int[str1.length()];
      LCSUtility lcsUtility= new LCSUtility();
      /* Filling out the 1-D array with 1 if that character from "first string is existed in "second string" otherwise 0"*/
      for(int i=0;i<str1.length();i++){
          if(str2.contains(str1.substring(i,i))) {
              lcs[i] =1;
          } else {
              lcs[i] =0;
          }
        }
        /* Finding the sub strings of "first string" are part of "second string" and storing results into 1-D array*/
        for(int i=1;i<str1.length();i++){
            String sub = str1.substring(i-1,i+1);
            if(str2.contains(sub)) {
                lcs[i] = 1+lcs[i-1];
            }
        }
        /* Finding Max of the LCSs*/
        for(int i=0;i<lcs.length;i++){
            System.out.print(" " + lcs[i]);
            if(lcs[i]>lcsUtility.lengthOfLCS) {
                lcsUtility.lengthOfLCS=lcs[i];
            }
        }
        /* Adding out all lcs to the utility object's list*/
        for(int i=0;i<lcs.length;i++) {
            if(lcs[i] == lcsUtility.lengthOfLCS) {
                lcsUtility.lcsList.add(str1.substring(i-lcsUtility.lengthOfLCS+1,i+1));
            }
        }
        return lcsUtility;
    }


    public LCSUtility findLongestCommonSubstringDP(String str1,String str2) {
        int m=str1.length(),n=str2.length();
        int[][] lcs = new int[m+1][n+1];

        LCSUtility lcsUtility= new LCSUtility();
        int max =0;

      /* Filling out the 1-D array with 1 if that character from "first string is existed in "second string" otherwise 0"*/

      for(int i=0;i<=m;i++) {
           for(int j=0;j<=n;j++) {
               if(i==0 || j==0) {
                   lcs[i][j]= 0;
               }
               else if(str1.charAt(i-1) ==str2.charAt(j-1)) {
                   lcs[i][j] = 1 + lcs[i-1][j-1];
               }
               else {
                   lcs[i][j]=0;
               }
           }
       }

        /* Finding Max of the LCSs*/
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++)
            if(lcs[i][j]>max) {
                max= lcs[i][j];
            }
        }
        lcsUtility.lengthOfLCS=max;

        return lcsUtility;
    }

    public static void main(String[] args){
        LCSUtility lcsUtility = new LongestCommonSubstring().findLongestCommonSubstring("abc", "abbc");
        System.out.print(" ******* Longest Common Sub of Given Strings are  \n" +lcsUtility.lengthOfLCS);
//        for(String s: lcsUtility.lcsList) {
//            System.out.print(" " +s);
//        }

        //System.out.print(" ******* Longest Common Sub of Given Strings are  " + new LongestCommonSubstring().findLCSInRecursiveWay("abc","adbc"));

    }
}
