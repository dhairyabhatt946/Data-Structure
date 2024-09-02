public class CreateBST {
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        bst.inorder(root);
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
}