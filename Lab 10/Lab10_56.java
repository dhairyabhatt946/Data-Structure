import java.util.Scanner;

public class Lab10_56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        Node node = new Node(num);
        System.out.println(node.data);
        System.out.println(node.link); // It will generate exception bcoz link is null.
        sc.close();
    }
}

class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}
