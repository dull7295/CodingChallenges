package TernaryTree;

/**
 * Created by dullam on 4/3/18.
 */
public class TernaryUtilities {

    public static void insert(TernaryNode root, int data) {
        //Find a Proper Place to Insert given data

        //insert it.

        if(data < root.data) {
            if (root.left == null)
                root.left = new TernaryNode(data);
            else
                insert(root.left, data);
        } else if(data > root.data) {
            if (root.right == null)
                root.right = new TernaryNode(data);
            else
                insert(root.right, data);
        } else  {
            if(root.middle == null)
                root.middle = new TernaryNode(data);
            else
                insert(root.middle, data);
        }

    }



    public static void dfs(TernaryNode root) {
        if(root != null) {
            dfs(root.left);
            System.out.println(" : "+root.data);
            dfs(root.middle);
            dfs(root.right);
        }
    }

    public static void delete(TernaryNode root, TernaryNode node) {
        //if(root.data == node.data && root.left == null && root.right == null && root.middle == null)

        
        if(root != null) {
            dfs(root.left);
            System.out.println(" : "+root.data);
            dfs(root.middle);
            dfs(root.right);
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{4,9, 8 , 6, 5,3,2,4};
        TernaryNode root = new TernaryNode(arr[0]);

        for(int i=1; i< arr.length; i++)
            insert(root,arr[i]);

        dfs(root);

    }
}
