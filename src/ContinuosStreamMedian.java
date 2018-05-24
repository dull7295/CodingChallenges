/**
 * Created by dullam on 7/22/17.
 */
import java.util.*;
public class ContinuosStreamMedian {
   private Queue maxHeap,minHeap;
   private int currentSize=0;
   public ContinuosStreamMedian() {
       minHeap = new PriorityQueue<Integer>();
       maxHeap = new PriorityQueue<Integer>(11,new MaxQueueComparator());
   }

    public float findMedian(int newNumber) {
       float currentMedian=0;
       if(currentSize % 2 == 0){
           /*That means Max heap.Heap is N and Min heap.Heap is N */
           maxHeap.add(newNumber);
           this.currentSize++;
           if(currentSize > 1) {
               //&& (int)maxHeap.peek() > (int)minHeap.peek()
               if((maxHeap.peek() != null) && (minHeap.peek() != null) && !((int)maxHeap.peek()  < (int)minHeap.peek())) {
                   maxHeap.add((int)minHeap.poll());
                   minHeap.add((int)maxHeap.poll());
               }
           }
       } else {
           /*That means Max heap.Heap is N+1 and Min heap.Heap is N */
           maxHeap.add(newNumber);
           this.currentSize++;
           if(maxHeap.peek() != null) {
               int rootOfMaxHeap = (int)maxHeap.poll();
               minHeap.add(rootOfMaxHeap);
           }
       }

           int max=0,min=0;
           if(maxHeap.peek() != null){
               max = (int)maxHeap.peek();
           }
           if(minHeap.peek() !=null) {
               min = (int)minHeap.peek();
           }

        System.out.println("max heap.Heap " +maxHeap);
        System.out.println("min heap.Heap " +minHeap);
        if(currentSize%2==0){
            currentMedian = (min+max)/2;
        } else {
           currentMedian = max;
        }
      return currentMedian;
    }

    private class MaxQueueComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContinuosStreamMedian csm = new ContinuosStreamMedian();
        float median=0;
        int n;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(true) {
         n = in.nextInt();
         arrayList.add(n);
         median = csm.findMedian(n);
         System.out.println("Current median of the stream " + arrayList + " is  " +median);
        }
    }
}
