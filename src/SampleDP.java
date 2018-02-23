import java.util.PriorityQueue;

public class SampleDP {


    private void  runPQ() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] arr = {12,56,9,8,34,50,11,23,10};

        for(int i=0;i<arr.length;i++) {
            priorityQueue.add(arr[i]);
        }
        while (priorityQueue.peek()!=null) {
            System.out.print("  " +priorityQueue.poll());
        }
    }
    public static void main(String[] args) {

      int[] arr = new int[5];
      arr[0] = 1;
      arr[1]=2;

      for(int i=0;i<arr.length;i++) {
          System.out.println("hello " +arr[i]);
      }

      SampleDP sd = new SampleDP();
      sd.runPQ();


    }


}