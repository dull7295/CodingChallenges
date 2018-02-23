/**
 * Created by dullam on 7/24/17.
 */

public class ReverseLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insert(int num) {

        if (this.head == null) {
            this.head = new Node(num);
        } else {
            Node node = head, prev = null;
            while (node != null) {
                prev = node;
                node = node.next;
            }
            prev.next = new Node(num);

        }
    }

    public void insertAtBegining(int num) {
        if (head == null) {
            head = new Node(num);
        } else {
            Node new_node = new Node(num);
            new_node.next = head;
            this.head = new_node;
        }

    }

    public void reverseLinkedList() {
        if (this.head == null || head.next == null) {
            // System.out.println("linked list is :" + head.data);
        } else {
            Node prev = null, current = head, temp;
            while (current != null) {
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            head = prev;
        }
    }

    public void printlist() {
        Node next = head;
        while (next != null) {
            System.out.println("list is : -->" + next.data);
            next = next.next;
        }
    }

    public void loopList() {
        Node node = head, prev = null;
        while (node != null) {
            prev = node;
            node = node.next;
        }
        prev.next = head;
    }

    public boolean checkLoops() {
        Node rabbit, turtle, node = head;
        rabbit=node;
        turtle=node;
        while (turtle != null && rabbit != null && rabbit.next != null) {
            rabbit = node.next.next;
            turtle = node.next;
            if (rabbit == turtle) {
                return true;
            }
        }
        return false;
    }

//    int detectAndRemoveLoop(Node node) {
//        Node slow = node, fast = node;
//        while (slow != null && fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            // If slow and fast meet at same point then loop is present
//            if (slow == fast) {
//                //removeLoop(slow, node);
//                return 1;
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] list = { 3, 23, 1, 5 };
        ReverseLinkedList rlist = new ReverseLinkedList();
        for (int i = 0; i < list.length; i++) {
            rlist.insert(list[i]);
        }

        rlist.reverseLinkedList();
        rlist.printlist();
        rlist.loopList();
        boolean b = rlist.checkLoops();
        System.out.println("Given linked list has loops :" + b);
    }

}