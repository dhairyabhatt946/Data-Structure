import java.util.Scanner;

public class Lab9_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of queue");
        int temp = sc.nextInt();
        MyQueue myQueue = new MyQueue(temp);
        int choice;
        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("-1. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to insert");
                    temp = sc.nextInt();
                    myQueue.enqueue(temp);
                    break;

                case 2:
                    System.out.println("Deleted element is " + myQueue.dequeue());
                    break;

                case 3:
                    myQueue.display();
                    break;

                default:
                    if(choice != -1) System.out.println("Invalid Input");
                    break;
            }
        } while(choice != -1);

        sc.close();
    }
}

class MyQueue {
    int[] queue;
    int front, rear, size;

    public MyQueue(int size) {
        this.size = size;
        queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int x) {
        if(rear >= size-1) {
            System.out.println("Queue Overflow");
            return;
        }
        rear++;
        queue[rear] = x;
        if(front == -1) front = 0;
        System.out.println("Element inserted successfully");
    }

    public int dequeue() {
        if(front < 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        if(front == rear) {
            int x = queue[front];
            front = rear = -1;
            return x;
        }
        int x = queue[front];
        front++;
        return x;
    }

    public void display() {
        if(front < 0) {
            System.out.println("Queue is empty");
            return;
        }
        for(int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}