public class SearchInBST {
    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        bst.inorder(root);
        System.out.println();
        if(bst.search(root, 1)) {
            System.out.println("found");
        }
        else {
            System.out.println("Not found");
        }
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

    public boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data > key) {
            return search(root.left, key);
        }
        else if(root.data == key) {
            return true;
        }
        else {
            return search(root.right, key);
        }
    }
}