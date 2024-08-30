public class DiameterOfTree1 {
    public static void main(String[] args) {
        //consider -1 as null
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        //create binary tree
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        //diameter of tree
        System.out.println(tree.diameter(root));
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    int idx = -1;
    public Node buildTree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public int countHeight(Node root) {
        if(root == null) return 0;

        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameter(Node root) {
        if(root == null) return 0;

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = countHeight(root.left) + countHeight(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }
}
