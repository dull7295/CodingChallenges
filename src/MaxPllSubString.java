/**
 * Created by dullam on 3/11/18.
 */
public class MaxPllSubString {
    public static String longestPalindrome(String s) {
        boolean[][] LPS = new boolean[s.length()][s.length()];
        String res = "";
        for(int i = s.length()-1; i >= 0  ; i--) {
            for(int j=0; j < s.length(); j++) {
                if(i>=j)
                    LPS[i][j] = true;
                else if(i == s.length()-1)
                    LPS[i][j] = true;
                else if(s.charAt(i) == s.charAt(j) && LPS[i+1][j-1]) {
                    LPS[i][j] = true;
                    if(j-i+1 > res.length()) res = s.substring(i,j+1);
                }
                else
                    LPS[i][j] = false;
            }
        }

        return res;
    }

    public static void main (String[] args)
    {

            System.out.print("  "+ longestPalindrome("madampyuiippmadampp"));
    }
}
