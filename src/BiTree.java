/**
 * Created by dullam on 7/23/17.
 */
public class BiTree {
    private class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right = null;
        }
    }

    public Node root;

    public Node insert(int data) {
        Node node;
        node = new Node(data);
        return node;
    }


    public void inorder(Node node) {
        if(node!=null) {
         inorder(node.left);
         System.out.print(" " + node.data);
         inorder(node.right);
        }
    }


  public static void main(String[] args) {

      BiTree firstBT = new BiTree();
      Node node1 = firstBT.insert(1);

      firstBT.root = node1;

      Node node5= firstBT.insert(5);
      node1.left = node5;

      Node node7= firstBT.insert(7);
      node5.right = node7;

      Node node8= firstBT.insert(8);
      node1.right = node8;

      Node node9= firstBT.insert(9);
      node8.left = node9;

      firstBT.inorder(firstBT.root);
  }

}
