/**
 * Created by dullam on 8/4/17.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ListofArraysSort {
    public static void main(String[] args) {
        new ListofArraysSort().ArraysSort();

    }

    private class Node {
        int data;
        int listNumber;
        int index;

        Node(int data, int listnumber, int index) {

            this.data = data;
            this.listNumber = listnumber;
            this.index=index;
        }
    }





    private  void ArraysSort() {
        Queue<Node> queue;
        queue = new PriorityQueue<Node>(10,new MyComparator());


        int[] firstArray = { 6, 10, 25, 37 };
        int[] secondArray = { 28, 45, 57, 64, 105 };
        int[] thirdArray = { 33, 105, 110, 112 };
        int[] fourthArray = { 1, 2, 8, 68, 89, 70 };

        ArrayList<int[]> listofArrays = new ArrayList<int[]>();

        listofArrays.add(firstArray);
        listofArrays.add(secondArray);
        listofArrays.add(thirdArray);
        listofArrays.add(fourthArray);

        for(int i=0;i<listofArrays.size();i++) {
            int[] a = listofArrays.get(i);
            queue.add(new Node(a[0],i,0));
        }


        while (!queue.isEmpty()){
            //find the element to which array it belongs and add the second element by peeking the root of queue
            Node peekedValue=queue.poll();
            int peekedIndex=peekedValue.index;
            int listnumber = peekedValue.listNumber;
            int[] a = listofArrays.get(listnumber);

            if(peekedIndex+1 < a.length) {
                Node newNode = new Node(a[peekedIndex + 1], listnumber, peekedIndex + 1);
                queue.add(newNode);
            }
            System.out.println(" " + peekedValue.data);
        }

    }

    public  class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1,Node n2) {
            return n1.data-n2.data;
        }
    }

}