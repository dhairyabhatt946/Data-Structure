import java.util.Scanner;

public class Lab13_71 {
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
    int info;
    Node link;

    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}

class LinkedList {
    Node first = null;
    Node last = null;

    public void insertAtFirst(int info) {
        Node newNode = new Node(info);

        if(first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        newNode.link = first;
        first = newNode;
        last.link = newNode;
        System.out.println("Element inserted successfully");
    }

    public void insertAtLast(int info) {
        Node newNode = new Node(info);
        if(first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        newNode.link = first;
        last.link = newNode;
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
            last.link = first.link;
            first = first.link;
            temp = null;
            System.out.println("Element deleted successfully");
            return;
        }
        Node current = first;
        for(int i=1; i<pos-1; i++) {
            current = current.link;
            if(current == last) {
                System.out.println("Invalid position");
                return;
            }
        }
        if(current.link == last) {
            Node temp = last;
            current.link = first;
            last = current;
            temp = null;
            System.out.println("Element deleted successfully");
            return;
        }
        Node temp = current.link;
        current.link = current.link.link;
        temp = null;
        System.out.println("Element deleted successfully");
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        while(current != last) {
            System.out.print(current.info + ", ");
            current = current.link;
        }
        System.out.print(current.info);
        System.out.println();
    }
}
