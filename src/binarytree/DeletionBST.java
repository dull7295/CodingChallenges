package binarytree;

/**
 * Created by dullam on 4/6/18.
 */
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeletionBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root, prev = null;
        while(node != null) {
            prev = node;
            if(node.val == key)
                break;
            if(node.val < key)
                node = node.right;
            else
                node = node.left;
        }

        /** root **/
        if(prev == null) return delete(node);
        if(prev.left == node)
            prev.left = delete(node);
        else
            prev.right = delete(node);

        return root;
    }




    private TreeNode delete(TreeNode node) {
        /* No Left and Right Childs */
        if(node == null) return null;
        if(node.left == null && node.right == null) {
            return null;
        }

        /* Only left */
        if(node.right == null)
            return node.left;
        if(node.left == null)
            return node.right;

        /* Both left and right */
        TreeNode minNode = node.right;
        while(minNode.left != null)
            minNode = minNode.left;

        node.val = minNode.val;
        node.right = delete(minNode);
        return node;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int key = Integer.parseInt(line);

            TreeNode ret = new DeletionBST().deleteNode(root, key);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}