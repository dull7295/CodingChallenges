/**
 * Created by dullam on 7/13/17.
 */
public class BinaryTree {
    private class Node<T> {
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

    private Node<Integer> root = null;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(Integer data ) {
        this.root = insert(this.root,data);
    }

    public Node insert(Node node, int data) {
        if(node == null) {
            node = new Node<Integer>(data);
        }else {
            if((int)node.getData() >= data) {
                node.right = insert(node.right,data);
            }else {
                node.left= insert(node.left,data);
            }
        }
        return node;
    }

   public void print(Node node) {
        if(node != null) {
            System.out.print(node.getData());
        }
        if(node.left != null) {
            print(node.left);

        }
        if(node.right != null) {
           print(node.right);
        }
        System.out.println("\n");
   }

    public void inorder(Node node) {
        if(node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + " ");
            inorder(node.getRight());
        }
    }


    public int height(Node node){
        if(node!=null) {
            int lh = 1 + height(node.left);
            int rh = 1 + height(node.right);
            if(lh>rh) return lh;
            return rh;
        }
        return -1;
    }

    public boolean isBalanced(Node node) {
        if (node != null) {
            int leftHeight = 1 + height(node.left);
            int rightHeight = 1 + height(node.right);
            int height=leftHeight-rightHeight;
            if(Math.abs(height)>1) return false;
            else return isBalanced(node.left) && isBalanced(node.left);
        }
        return true;
    }
    /**/
    public static void main(String[] args) {

       System.out.println(" Binary Tree Implementation ");

     //  int[] a = {64,1,32,4,9,6,7,8,29,78};
       int[] a={64,75,89,90,92,93,3,2,1};
       BinaryTree bt = new BinaryTree();

       for(int i :a) {
           bt.insert(i);
           //System.out.println(" Now root is  " + bt.root.getData());
       }

       bt.inorder(bt.root);
        System.out.println(" Height of binary tree is   " + bt.height(bt.root));

       //bt.print(bt.root);
       System.out.println (bt.isBalanced(bt.root));

    }


}
