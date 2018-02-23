import  java.util.*;
import java.util.LinkedList;

/**
 * Created by dullam on 7/23/17.
 */
public class PriorityQueueDriver {


    public static void main(String[] args) {

    int[] a = {2,10,8,3,7,19,25};
        PriorityQueueDriver pqd = new PriorityQueueDriver();
        Queue priorityQueue  = new PriorityQueue<Integer>(10,new PQDComaparator());

        priorityQueue.add(a[0]);
        System.out.println(" " + priorityQueue + " head peeking" + priorityQueue.peek());
        priorityQueue.add(a[1]);
        System.out.println(" " + priorityQueue);

        priorityQueue.add(a[2]);
        System.out.println(" " + priorityQueue);

        priorityQueue.add(a[3]);
        System.out.println(" " + priorityQueue);
        System.out.println(" " + priorityQueue + " head removing" + priorityQueue.remove());


        priorityQueue.add(a[4]);
        System.out.println(" " + priorityQueue);

        priorityQueue.add(a[5]);
        System.out.println(" " + priorityQueue);
        System.out.println(" " + priorityQueue + " polling " + priorityQueue.poll());

        priorityQueue.add(a[5]);


        priorityQueue.add(a[5]);
        priorityQueue.add(a[5]);

        System.out.println(" " + priorityQueue + " head " + priorityQueue.poll());


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(" " + queue + " head " + queue.poll() + " *****   " +         queue.element());
        queue.element();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.addFirst(0);
        System.out.println(" " + ll + "ll head " + ll.remove());

        System.out.println(" " + ll + " head " + ll.remove());
        System.out.println(" " + ll + " head " + ll.peek());
        System.out.println(" " + ll + " head " + ll.poll());

        Integer ii= 109819;
        int iii=-19;
        System.out.println(" hhhh " + Integer.toBinaryString(iii));

    }

    private static class PQDComaparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
}
