/**
 * Created by dullam on 8/4/17.
 */
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MedianOfTwoSortedLists {
    private class Node {
        int array;
        int data;
        int current_index;
        Node(int array,int data, int current_index) {
            this.array= array;
            this.data=data;
            this.current_index=current_index;
        }
    }
    public class MyComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.data-o2.data;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        double median=0;
        int pos=(size+1)/2;
        if(nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0 && size % 2==0) {
                median = (nums2[pos-1] + nums2[pos])/2;
                System.out.println(" " +nums2[pos-1] +" " + nums2[pos] + " " + median);
            }
            else if (nums1.length == 0 && size % 2 != 0) median = nums2[pos-1];
            if (nums2.length == 0 && size % 2==0) median = nums1[pos-1]/2+nums1[pos]/2;
            else if (nums2.length == 0 && size % 2 != 0) median = nums1[pos-1];
            return median;
        }
        MyComparator myComparator = new MyComparator();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(size,myComparator);
        Node node=null;
        node = new Node(1,nums1[0],0);
        pq.add(node);
        node = new Node(2,nums2[0],0);
        pq.add(node);
        while(pos>0){
            if(pq.peek()!=null) {
                node = pq.poll();
                median = node.data;
                //System.out.println(" " + node.data);
                if(node.array == 1 && nums1.length > node.current_index+1) {
                    pq.add(new Node(1,nums1[node.current_index+1], node.current_index+1));
                } else if(node.array == 2 && nums2.length > node.current_index+1) {
                    pq.add(new Node(2,nums2[node.current_index+1], node.current_index+1));
                }
            }
            pos--;
        }

        if ( size % 2 == 0) {
            node = pq.poll();
            median = (median+node.data)/2;
        }

        return median;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedLists medianOfTwoSortedLists = new MedianOfTwoSortedLists();
        double median = medianOfTwoSortedLists.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{7,8,9});
        System.out.println("median is "+ median);
    }
}


