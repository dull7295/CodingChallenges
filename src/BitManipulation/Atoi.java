package BitManipulation;

/**
 * Created by dullam on 4/3/18.
 */
public class Atoi {

    public static int myAtoi(String str) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;

        int result = 0, i = 0, sign = 1;
        if(str == null || str.isEmpty()) return 0;
        str = str.trim();
        if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        for(;i < str.length(); i++) {
            int ascii = str.charAt(i) - '0';
            if(ascii < 0 || ascii > 9)
                continue;
            if(result > MAX/10)
            {
                if(sign == 1)
                    return MAX;
                else
                    return MIN;
            }

            if(sign == 1 && result == MAX/10 &&  ascii > 7) {
                return MAX;
            } else if(sign == -1 && result == MAX/10 && ascii > 8)
            {
                return MIN;
            }

            result = result*10 + ascii;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println("ATOI for   " + myAtoi("2147483647"));
        }

}