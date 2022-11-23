package tree;

public class TreeTraversalEasy extends TreeExamples {
    public static void main(String[] args) {

        TreeTraversalEasy tte = new TreeTraversalEasy();
        TreeNode tree = tte.tree1();
        TreeNode tree2 = tte.tree1();
        boolean sameTree = tte.isSameTree(tree, tree2);
        System.out.println("Is same tree " + sameTree);

        TreeNode tree4 = tte.tree4();
        System.out.println(tte.isSymmetric(tree4));
        System.out.println(tte.maxDepthRecursion(tree));

        TreeNode t5 = tte.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(t5);
        tte.isBalanced(tree4);
        System.out.println(tte.isBalancedRec(tree));
        System.out.println(tte.minDepth(tree));
        TreeNode invertTree = tte.tree1();
        TreeNode treeNode = tte.invertTree(invertTree);
        System.out.println(treeNode);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p != null && q == null) || (q != null && p == null))
            return false;
        if (p.val == q.val) {
            boolean leftSame = isSameTree(p.left, q.left);
            boolean rightSame = isSameTree(p.right, q.right);
            return leftSame && rightSame;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return areSymmetric(root.left, root.right);
    }

    public boolean areSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null || !isValueSame(leftNode, rightNode)) {
            return false;
        }

        return areSymmetric(leftNode.right, rightNode.left)
                &&
                areSymmetric(leftNode.left, rightNode.right);
    }

    public boolean isValueSame(TreeNode leftRoot, TreeNode rightNode) {
        return leftRoot.val == rightNode.val;
    }

    public int maxDepthRecursion(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + maxDepthRecursion(root.left), 1 + maxDepthRecursion(root.right));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode t = sortedArrayBst(nums, 0, nums.length - 1);
        return t;
    }

    public TreeNode sortedArrayBst(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayBst(nums, start, mid - 1);
        node.right = sortedArrayBst(nums, mid + 1, end);

        return node;

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }


    public int depth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalancedRec(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;

    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lH = height(node.left);
        if (lH == -1) {
            return -1;
        }
        int rH = height(node.right);
        if (rH == -1) {
            return -1;
        }
        if (lH - rH < -1 || lH - rH > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
    }

    public int minDepth(TreeNode root) {
        return minDepthHelper(root);
    }

    public int minDepthHelper(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepthHelper(root.left);
        int right = minDepthHelper(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
