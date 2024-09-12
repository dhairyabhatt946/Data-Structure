public class Lab15_82 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6};
        int[] post = {3, 4, 2, 6, 5, 1};

        Tree tree = new Tree();
        Node root = tree.insert(pre, post);
        System.out.println(root.data);
        tree.preorder(root);
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
    int i=0, j=0;

    public Node insert(int[] pre, int[] post) {
        Node newNode = new Node(pre[i]);
        i++;

        if(newNode.data != post[j]) {
            newNode.left = insert(pre, post);
        }
        if(newNode.data != post[j]) {
            newNode.right = insert(pre, post);
        }
        j++;

        return newNode;
    }

    public void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}