import java.util.Stack;

/**
 * Created by dullam on 7/13/17.
 */
public class HeapTreeUsingArray {
    /* Each of Node in Tree represented and it is pointing back to their respective parents*/
    private int[] heap =  new int[100];
    public boolean isEmpty() {
        return heap[0]==0;
    }
    public int getSize(){
        return this.heap[0];
    }
    public int getLastIndex() {return this.heap[heap[0]];}

    private void insertIntoHeapTree(int data) {
        /* find number of nodes in the heap */

        if(getLastIndex() == 0) {
            heap[0]=1;
            this.heap[heap[0]]=data;
        } else {
            heap[0]+=1;
            heap[heap[0]]=data;
            heapify();
        }
       /*Now bubble up the node and maintain heap property */
    }

    private void heapify() {
        /** parent of any node at index k is k/2 */
        /* Left child of a parent at index k is 2k and right child is at 2k+1 */
        int k = heap[0];
        while(k!=0) {
           if(k/2!=0 && heap[k] > heap[k/2]) {
               int temp = heap[k/2];
               heap[k/2]=heap[k];
               heap[k]=temp;
           }
           k=k/2;
        }
    }

    private int getMax() {
        int max=0;
        if(heap[0] == 0) {
            max=0;
        } else{
            int temp=heap[1];
            heap[1]= heap[heap[0]];
            heap[heap[0]] = temp;
            max=temp;
            heap[heap[0]]=0;
            heap[0]-=1;
            if(heap[0] > 0) {
                siftDown(1);
            }
        }
        return max;
    }

    private void siftDown(int nodeIndex) {
        int leftChildIndex, rightChildIndex, minIndex, tmp;
        leftChildIndex = 2*nodeIndex;
        rightChildIndex = 2*nodeIndex+1;
        if (rightChildIndex > heap[0]) {
            if (leftChildIndex > heap[0])
                return;
            else
                minIndex = leftChildIndex;
        } else {
            if (heap[leftChildIndex] > heap[rightChildIndex])
                minIndex = leftChildIndex;
            else
                minIndex = rightChildIndex;
        }
        if (heap[nodeIndex] < heap[minIndex]) {
            tmp = heap[minIndex];
            heap[minIndex] = heap[nodeIndex];
            heap[nodeIndex] = tmp;
            siftDown(minIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println("********* Heap Tree Implementation **********");
        int[] b = {64,1,32,4,9,6,7,8,29,78,1234};
        int[] a = {98, 23, 45, 190, 28,87,91,887};
        HeapTreeUsingArray bt = new HeapTreeUsingArray();
           for(int i :a) {
               bt.insertIntoHeapTree(i);
           }

        for(int i=1;i<=bt.heap[0];i++) {
            System.out.print(" " + bt.heap[i] );
        }
        System.out.println(" ");

        while(bt.heap[0] !=0) {
            System.out.print(" " + bt.getMax());
        }

    }
}
