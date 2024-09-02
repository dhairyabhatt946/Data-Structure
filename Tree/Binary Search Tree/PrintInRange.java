public class PrintInRange {
    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        bst.printInRange(root, 6, 10);
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

    public void printInRange(Node root, int x, int y) {
        if(root == null) {
            return;
        }

        if(root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(root.data > y) {
            printInRange(root.left, x, y);
        }
        else {
            printInRange(root.right, x, y);
        }
    }
}