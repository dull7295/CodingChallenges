/**
 * Created by dullam on 4/28/18.
 */
public class FindPallindromes {

    public static int findPalls(String str) {
        int ans =0, left =0, right = 0, N = str.length();
        for(int center = 0; center < 2*N -1; center++ ) {
            left = center/2;
            right = left + center % 2;
           while(left >=0 && right < N && str.charAt(left) == str.charAt(right)) {
                ans++;
                System.out.print("  " + str.substring(left,right+1));
                left--;
                right++;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        System.out.println(" Number of pallindromes in the string " + FindPallindromes.findPalls("MADAM"));
    }
}
