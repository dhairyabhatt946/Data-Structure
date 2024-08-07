import java.util.Scanner;

public class Lab11_61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int choice = 0, data = 0;

        do {
            System.out.println("1. n-queue\n2. d-queue\n3. Display\n-1. Exit\n");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter data to add in thr queue: ");
                    data = sc.nextInt();
                    queue.n_queue(data);
                    break;

                case 2:
                    System.out.println(queue.d_queue());
                    break;

                case 3:
                    queue.display();
                    break;

                default:
                    if(choice != -1) System.out.println("Invalid input");
                    break;
            }
        } while(choice != -1);
        sc.close();
    }
}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue{
    Node first = null;
    Node last = null;
    
    public void n_queue(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = newNode;
            System.out.println("Element inserted succesfully\n");
            return;
        }
        Node last = first;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public int d_queue() {
        if(first == null) {
            System.out.println("List is empty");
            return 0;
        }
        int num = first.data;
        Node temp = first;
        first = first.next;
        temp = null;
        return num;
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = first;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}