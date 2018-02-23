import java.nio.charset.Charset;
import java.util.*;


/**
 * Created by dullam on 7/7/17.
 */
public class PracticeAbstractAndInterfaces extends SampleAbstract1 implements SampleInterface1, SampleInterface2 {

    public void methodFromSA1HaveToBeImplemented() {
        System.out.println("method From Sample Abstract2");
    }

    public void methodFromSI1HaveToBeImplemented() {

    }

    public void methodFromSA2HaveToBeImplemented(){

    }

    public void methodFromSampleAbstract2() {
        System.out.println("method From Sample Abstract 2 , but again implemented in Practice Main Class");
    }

    public void methodSI3() {

    }

    public static void main(String[] args) {

        PracticeAbstractAndInterfaces practiceAbstractAndInterfacesObj = new PracticeAbstractAndInterfaces();
        practiceAbstractAndInterfacesObj.methodFromSA1HaveToBeImplemented();
        practiceAbstractAndInterfacesObj.methodFromSampleAbstract2();

        //String str = "Hello World , How are you!";
        while(true) {
            System.out.println("Enter string to check if it has all unique letters are not...");

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            System.out.println("Given String is " + str + " legnth is " + str.length());

            ArrayList<Character> charsList = new ArrayList<Character>();

            for (char c : str.toCharArray()) {
                charsList.add(c);
            }

            HashSet<Character> treeSet = new HashSet<>(charsList);

            System.out.println(treeSet);

            if(treeSet.size() == charsList.size()) {
                System.out.println(str + " is having unique chars ");

            } else {
                System.out.println(str + " is not having unique chars ");

            }


        }

    }

}
