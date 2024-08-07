import java.util.Scanner;

public class OrderedSinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int data, choice=0;
        do {
            System.out.println("Enter 1 to insert data into ordered linked list");
            System.out.println("Enter 2 to display the linked list");
            System.out.println("Enter -1 to terminate the menu\n");

            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter data");
                    data = sc.nextInt();
                    list.insert(data);
                    break;

                case 2:
                    list.display();
                    break;

                default:
                    if(choice != -1) {
                        System.out.println("Invalid input");
                        break;
                    }
            }
        }while(choice != -1);
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

class LinkedList {
    public Node first = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = newNode;
            System.out.println("Element inserted succesfully");
            return;
        }
        if(newNode.data <= first.data) {
            newNode.link = first;
            first = newNode;
            return;
        }
        Node current = first;
        while(current.link != null && newNode.data >= current.link.data) {
            current = current.link;
        }
        newNode.link = current.link;
        current.link = newNode;
        System.out.println("Element inserted succesfully");
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = first;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.link;
        }
        System.out.println();
    }
}
