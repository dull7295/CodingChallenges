import java.util.ArrayList;

/**
 * Created by dullam on 7/17/17.
 */
/*Dynamic Programming*/
public class LongestCommonSubsequence {
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


    public LCSUtility findLongestCommonSubsequenceDP(String str1,String str2) {
        int m =str1.length(),n=str2.length();
      int[][] lcs = new int[m+1][n+1];
      LCSUtility lcsUtility= new LCSUtility();
      /* Filling out the 2-D array with 1 if that character from "first string is existed in "second string" otherwise 0"*/
      for(int i=0;i<=m;i++) {
          for (int j = 0; j <=n; j++) {
            if(i==0 || j==0) {
                lcs[i][j]=0;
            }
            else if(str1.charAt(i-1)==str2.charAt(j-1)) {
                lcs[i][j] = 1+ lcs[i-1][j-1];
            }
            else {
               lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
            }
          }
      }
      lcsUtility.lengthOfLCS = lcs[m][n];
      return lcsUtility;
    }


    public static void main(String[] args){
        LCSUtility lcsUtility = new LongestCommonSubsequence().findLongestCommonSubsequenceDP("tutorialhorizon", "dynamictutorialProgramming hellow");
        System.out.print(" ******* Longest Common Subsequence of Given Strings are  \n" + lcsUtility.lengthOfLCS);
//        for(String s: lcsUtility.lcsList) {
//            System.out.print(" " +s);
//        }

        //System.out.print(" ******* Longest Common Sub of Given Strings are  " + new LongestCommonSubsequence().findLCSInRecursiveWay("abc","adbc"));

    }
}
