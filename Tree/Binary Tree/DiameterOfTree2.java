public class DiameterOfTree2 {
    public static void main(String[] args) {
        //consider -1 as null
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        //create binary tree
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        //diameter of tree
        System.out.println(tree.diameter(root).diam);
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

class TreeInfo {
    int ht;
    int diam;

    public TreeInfo(int ht, int diam) {
        this.ht = ht;
        this.diam = diam;
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

    public TreeInfo diameter(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myHeight, myDiam);
    }
}
