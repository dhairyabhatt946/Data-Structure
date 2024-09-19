public class Lab15_83 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = null;

        root = tree.insert(root, 35);
        root = tree.insert(root, 39);
        root = tree.insert(root, 28);
        root = tree.insert(root, 5);
        root = tree.insert(root, 11);
        root = tree.insert(root, 17);
        root = tree.insert(root, 17);

        System.out.println(tree.findMax(root));
        System.out.println(tree.findMin(root));
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

class Tree {
    public Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(root.data == data) {
            return root;
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public int findMax(Node root) {
        if(root == null) {
            return 0;
        }

        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public int findMin(Node root) {
        if(root == null) {
            return 0;
        }
    
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }
}
