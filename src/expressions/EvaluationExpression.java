package expressions;

/**
 * Created by dullam on 3/30/18.
 */
import java.util.Random;
import java.util.Stack;
public class EvaluationExpression {
    static Random rand = new Random();

    public static int processExpression(String str) {
        Stack<Integer> expStack = new Stack<Integer>();
        Stack<String> opStack = new Stack<String>();
        String[] arr = str.split(" ");
        int res = 0, left =0, right =0;
        for(int i=0; i< arr.length; i++)
            if(arr[i].equals("+") || arr[i].equals("-"))
                opStack.push(arr[i]);
            else
                expStack.push(getVal(arr[i]));

        while(!expStack.empty()) {
            left = expStack.pop();
            if(!opStack.empty() && opStack.pop().equals("-"))
                left= -left;
            if(!expStack.empty()) expStack.push(expStack.pop() + left);
        }
        return left;
    }

    private static Integer getVal(String str) {
        String[] a = str.split("d");
        return Integer.parseInt(a[0]) * rand.nextInt(Integer.parseInt(a[1]));
    }

    public static void main(String[] args) {
        String str = "1d2 + 20d7 - 13d20";
        System.out.print("--- ---   " + processExpression(str));
    }

}
