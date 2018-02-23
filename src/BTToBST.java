/**
 * Created by dullam on 8/10/17.
 */


import java.util.Arrays;

public class BTToBST {
    TreeNode head;
    int index=0;
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public int maxIndex(int arr[], int strt, int end) {
        int i, max = arr[strt], maxindex = strt;
        for (i = strt + 1; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    public TreeNode buildTree(int[] arr, int start, int end, TreeNode node) {
        if (start > end)
            return null;
        int i = maxIndex(arr, start, end);
        node = new TreeNode(arr[i]);
        if (start == end)
            return node;
        node.left = buildTree(arr, start, i - 1, node.left);
        node.right = buildTree(arr, i + 1, end, node.right);
        return node;
    }

    void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void btToBST(int[] a,TreeNode node) {
        if (node == null)
            return;
        btToBST(a,node.left);
        node.data=a[index++];
        btToBST(a,node.right);
    }


    public TreeNode binarySearchTree(TreeNode node, int[] data, int start, int end) {
        if (node == null && start > end)
            return null;
        if (node.left != null) {
            binarySearchTree(node.left, data, start, end);
            if (node.left.data > data[start]) {
                node.left.data = data[start];
            } else if (node.data < data[start]) {
                node.data = data[start];
            } else

                node.right.data = data[start];
            start = start + 1;
        }

        return node;
    }

    public static void main(String[] args) {

        int[] input = { 4, 2, 5, 1, 6, 3, 7 };
        int len = input.length;
        BTToBST btree = new BTToBST();
        TreeNode head = btree.buildTree(input, 0, len - 1, btree.head);
        btree.printInorder(head);

        Arrays.sort(input);
        System.out.println("\n\n");
//        TreeNode newHead = btree.binarySearchTree(head, input, 0, len - 1);
//        btree.printInorder(newHead);

        btree.index=0;
        btree.btToBST(input,head);
        btree.index=0;
        btree.printInorder(head);


    }
}

//    TreeNode root = new btree.TreeNode(input[0]);
//        btree.head = root;
//
//                root.left = new TreeNode(a[1]);
//                root.right = new TreeNode(a[2]);