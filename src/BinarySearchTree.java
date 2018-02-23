/**
 * Created by dullam on 7/13/17.
 */
public class BinarySearchTree {
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
            if((int)node.getData() < data) {
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

    public boolean searchBST(Node node,int key){
        if(node!=null){
            if(node.getData() == key) { return true; }
            else if((int)node.getData() > key) {
                return searchBST(node.left,key);
            } else {
                return searchBST(node.right,key);
            }
        } else{
            return false;
        }
    }


    public static void main(String[] args) {

       System.out.println(" Binary Search Tree Implementation ");

       int[] a = {64,1,32,4,96,7,8,29,78};
       BinarySearchTree bt = new BinarySearchTree();

       for(int i :a) {
           bt.insert(i);
           //System.out.println(" Now root is  " + bt.root.getData());
       }

       bt.inorder(bt.root);

       //bt.print(bt.root);

      System.out.println(" Is 8 present in BST?  " + bt.searchBST(bt.root,96));

    }


}
