/**
 * Created by dullam on 7/23/17.
 */
public class LinkedListTest {
    public static  void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8};

        LinkedList<Number> linearLinkedList = new LinkedList<Number>();

        for(int i :a) {
            /**/
            linearLinkedList.insertAtTheEnd(i);
        }

        linearLinkedList.printLinkedList();

        LinkedList<Number> linearLinkedList2 = new LinkedList<Number>();

        for(int i :a) {
            /**/
            linearLinkedList2.insertAtTheBeginning(i);
        }

        linearLinkedList2.printLinkedList();



    }

}
