import java.util.ArrayList;

public class RoadToLeafPaths {
    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        bst.inorder(root);
        System.out.println();

        bst.printRoot2Leaf(root, new ArrayList<>());
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

class BinarySearchTree {
    public Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);

        //leaf
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        path.remove(path.size()-1);
    }

    public void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}