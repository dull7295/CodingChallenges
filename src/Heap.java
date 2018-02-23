/**
 * Created by dullam on 7/31/17.
 */
public class Heap {
    public int heapSize = 0;
    public int[] heap = new int[100];

	/* Phase 1 helper methods **/

    public void insert(int data) {

        if (this.heapSize == 0) {
            heapSize++;
            heap[heapSize] = data;
        } else {
            heapSize++;
            heap[heapSize] = data;
            bubbleUp();
        }

    }

    public void bubbleUp() {
        int k = heapSize;
        while (k != 0) {
            if (k / 2 != 0 && heap[k] > heap[k / 2]) {
                int temp = heap[k / 2];
                heap[k / 2] = heap[k];
                heap[k] = temp;
            }
            k = k / 2;
        }
    }

    /* Phase 2 helper methods */
    public int getMax() {
        int maxNode = 0;
        if (heapSize == 0) {
            maxNode = 0;
        } else {
            int temp = heap[heapSize];
            heap[heapSize] = heap[1];
            heap[1] = temp;

            maxNode = heap[heapSize];
            heapSize--;

            heapify(1);
            System.out.print(" --- " + maxNode);
            System.out.println(" ");

//            for (int i = 1; i < this.heapSize + 1; i++) {
//                System.out.print(" " + this.heap[i]);
//            }

            System.out.println(" ");


        }
        return maxNode;
    }

    public void heapify(int indexNode) {
        int parent = indexNode, left = 2 * parent, right = 2 * parent + 1, index;
        if (right > heapSize) {
            if (left > heapSize)
                return;
            else
                index = left;
        } else {
            if (heap[left] > heap[right]) {
                index = left;
            } else {
                index = right;
            }
        }
        if (heap[parent] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            heapify(index);
        }

    }

    public static void main(String[] args) {
        int[] arrayTobeSorted = new int[] { 98, 23, 45, 190, 28 };

        Heap obj = new Heap();

        // Alogorithm:
		/* Phase 1: Put all elements in array into Heap Tree */
        for (int i : arrayTobeSorted) {
            obj.insert(i);
        }

        for (int i = 1; i < obj.heapSize + 1; i++) {
            System.out.print(" " + obj.heap[i]);
        }
        System.out.println(" ");

        /** Phase 2: */

        while (obj.heapSize != 0) {
            int elem = obj.getMax();

        }
    }
}




