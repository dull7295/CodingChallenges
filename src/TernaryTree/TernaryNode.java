package TernaryTree;

/**
 * Created by dullam on 4/2/18.
 */
public class TernaryNode {
    int data;
    TernaryNode left, middle, right;
    public TernaryNode(int data) {
        this.data = data;
        this.left = this.right = this.middle = null;
    }
}
