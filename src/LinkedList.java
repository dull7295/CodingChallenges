/**
 * Created by dullam on 7/17/17.
 */
public class LinkedList<I extends Number> {

    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }


    /* Linked List Properties */
    int size=0;
    Node head;

    public int getSize(Node node) {
        if(node.next == null) return 0;
        else return 1+ getSize(node.next);
    }

    public Node getHead() {
        if(this.head == null) return null;
        else return head;
    }

    public void insertAtTheEnd(int data) {
        Node head = this.getHead();
        Node newNode = new Node(data);

        if (head == null) {
            this.head = newNode;
            return;
        } else{
            Node next,prev=null;
            next=head;
            while(next != null) {
                prev = next;
                next = next.next;
            }
            prev.next=newNode;
        }
    }

    public void insertAtTheBeginning(int data) {
        Node head = this.getHead();
        Node newNode = new Node(data);

        if (head == null) {
            this.head = newNode;
            return;
        } else{
           newNode.next=head;
           this.head = newNode;
        }
    }


    public void printLinkedList() {
        Node next= this.head;
        while(next != null) {
            System.out.print(" ----->  " + next.data);
            next = next.next;
        }
    }

}
