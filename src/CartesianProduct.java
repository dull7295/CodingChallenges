/**
 * Created by dullam on 3/12/18.
 */
public class CartesianProduct {
    public static void printCombos(String[] ... lists) {
        if (lists.length == 0)
            throw new IllegalArgumentException("No lists given");
        for (String[] list : lists)
            if (list.length == 0)
                throw new IllegalArgumentException("List is empty");

        int[] idx = new int[lists.length];
        for (;;) {
            // Print combo
            for (int i = 0; i < lists.length; i++) {
                if (i != 0)
                    System.out.print(' ');
                System.out.print(lists[i][idx[i]]);
            }
            System.out.println();

            // Advance to next combination
            for (int i = lists.length - 1; ++idx[i] == lists[i].length; ) {
                idx[i] = 0;
                if (--i < 0)
                    return; // We're done
            }
        }
    }

    public static void main(String[] args) {
        String[][] data = { { "x", "z" }, { "a", "b", "c" }, { "o", "p" } };
        printCombos(data);
    }
}
