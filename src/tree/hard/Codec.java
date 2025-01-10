package tree.hard;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();

    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(root.getVal()).append(spliter);
            buildString(root.getLeft(), sb);
            buildString(root.getRight(), sb);

        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>();
        //nodes.addAll();
        return null;
    }
}
