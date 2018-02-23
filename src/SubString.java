/**
 * Created by dullam on 7/16/17.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class SubString {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        recursiveSubstring("123",set);
        System.out.println("Size" + set.size());
        for(String s: set) {
            System.out.println(s);
        }
    }

    public static void sub(String s) {
        String sub;
        for (int c = 0; c < s.length(); c++) {
            for (int i = 1; i <= s.length() - c; i++) {
                sub = s.substring(c, c + i);
                System.out.println(sub);
            }
        }
    }

    public static void recursiveSubstring(String numbers, TreeSet<String> set) {
        if (numbers.length() == 1) {
            set.add(numbers);
            return;
        } else {
            set.add(numbers);
            recursiveSubstring(numbers.substring(0, numbers.length() - 1), set);
            recursiveSubstring(numbers.substring(1, numbers.length()),set);
        }
    }

}