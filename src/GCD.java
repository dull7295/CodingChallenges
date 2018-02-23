/**
 * Created by dullam on 7/16/17.
 */
public class GCD {

    public static void greatesCommonDivisor(int number1, int number2) {
        if (number2 == 0 || number1 == 0) {
            System.out.println("GCD is non-zero number");
        } else {
            for (int i = 1; i <= number1 && i <= number2; i++) {
                if (number1%i == 0 && number2%i == 0) {
                    System.out.println(i);
                }
            }
        }
    }

    public  static void Solution() {

        String str1 = "abcdfghtacdbah";
        String needle = "abcd";

        for(int i=0 ; i< str1.length()-needle.length(); i++) {

            String str = str1.substring(i,needle.length());
            System.out.println("" +str);

        }
    }

    public static void main(String[] args) {

        char[] arr = new char[26];
        String str="hello";
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
//        arr[0]=2;
//        arr[1]=6;        System.out.println("" +ns);
        System.out.println("" +arr);

        for(int i :arr){
            System.out.println("" +i);

        }

        String ns = new String(arr);
        System.out.println("" +ns);



        // TODO Auto-generated method stub
        //greatesCommonDivisor(24, 6);

        //Solution();

    }

}