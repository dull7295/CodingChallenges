import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * Created by dullam on 7/19/17.
 */
public class PermutationsOfString {

    public void permutations(char[] str, int index) {
        if(index > str.length) {
            System.out.println(" " + new String(str).toString());
            return;
        }
        char c = str[index-1];
        char temp;
        char[] str2 = str.clone();
        for(int i=index-1;i<str2.length;i++) {
         str2[index-1] = str2[i] ;
         str2[i] =c;
         permutations(str2,index+1);
            str2=str.clone();
        }

    }


    public void permutationsSB(StringBuffer str, int index) {
        if(index > str.length()) {
            System.out.println(" " + new String(str).toString());
            return;
        }
        char temp;
        StringBuffer sb = new StringBuffer(str);
        char c = sb.charAt(index-1);
        for(int i=index-1;i<sb.length();i++) {
            sb.setCharAt(index-1,sb.charAt(i));
            sb.setCharAt(i,c);
            permutationsSB(sb,index+1);
            sb=new StringBuffer(str);
        }
    }


    public static void main(String[] args) {
        PermutationsOfString obj = new PermutationsOfString();
        //obj.permutations("ABC".toCharArray(),1);
        obj.permutationsSB(new StringBuffer("ABC"),1);
    }
}
