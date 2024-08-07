import java.util.Scanner;

public class Lab13_72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice, temp;
        do {
            System.out.println("Enter 1 to insert node at first position");
            System.out.println("Enter 2 to delete node from last position");
            System.out.println("Enter 3 to delete node from specified position");
            System.out.println("Enter 4 to display circular linked list");
            System.out.println("Enter -1 to exit from the menu");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the data to enter");
                    temp = sc.nextInt();
                    list.insertAtFirst(temp);
                    break;

                case 2:
                    System.out.println("Enter the data to enter");
                    temp = sc.nextInt();
                    list.insertAtLast(temp);
                    break;

                case 3:
                    System.out.println("Enter the position to delete");
                    temp = sc.nextInt();
                    list.delete(temp);
                    break;

                case 4:
                    list.display();
                    break;
            
                default:
                    if(choice != -1) System.out.println("Invalid choice");
                    break;
            }
        } while(choice != -1);

        sc.close();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class LinkedList {
    Node first = null;
    Node last = null;

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        first.prev = newNode;
        newNode.next = first;
        first = newNode;
        System.out.println("Element inserted successfully");
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        System.out.println("Element inserted successfully");
    }

    public void delete(int pos) {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        if(pos == 1) {
            if(first == last) {
                first = last = null;
                System.out.println("Element deleted successfully");
                return;
            }
            Node temp = first;
            first = first.next;
            temp = null;
            System.out.println("Element deleted successfully");
            return;
        }
        Node current = first;
        for(int i=1; i<pos; i++) {
            current = current.next;
            if(current == null) {
                System.out.println("Invalid position");
                return;
            }
        }
        if(current == last) {
            last = current.prev;
            last.next = null;
            current = null;
            System.out.println("Element deleted successfully");
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current = null;
        System.out.println("Element deleted successfully");
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        while(current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }
}
