import java.util.Scanner;

public class Lab9_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of queue");
        int temp = sc.nextInt();
        MyQueue myQueue = new MyQueue(temp);
        int choice;
        do {
            System.out.println("1. Enqueue_rear");
            System.out.println("2. Enqueue_front");
            System.out.println("3. Dequeue_front");
            System.out.println("4. Dequeue_rear");
            System.out.println("5. Display");
            System.out.println("-1. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to insert");
                    temp = sc.nextInt();
                    myQueue.enqueue_rear(temp);
                    break;

                case 2:
                    System.out.println("Enter element to insert");
                    temp = sc.nextInt();
                    myQueue.enqueue_front(temp);
                    break;

                case 3:
                    System.out.println("Deleted element is " + myQueue.dequeue_front());
                    break;

                case 4:
                    System.out.println("Deleted element is " + myQueue.dequeue_rear());
                    break;

                case 5:
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

    public void enqueue_rear(int x) {
        if((rear+1)%size == front) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear+1)%size;
        queue[rear] = x;
        if(front == -1) front = 0;
        System.out.println("Element inserted successfully");
    }

    public void enqueue_front(int x) {
        if(front == 0) {
            if(rear == size-1) {
                System.out.println("Queue Overflow");
                return;
            }
            front = size - 1;
            queue[front] = x;
        }
        else {
            if((front-1) == rear) {
                System.out.println("Queue Overflow");
                return;
            }
            front--;
            queue[front] = x;
            System.out.println("Element inserted successfully");
        }
        
    }

    public int dequeue_front() {
        if(front < 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int x = queue[front];
        if(front == rear) front = rear = -1;
        else front = (front+1)%size;
        return x;
    }

    public int dequeue_rear() {
        if(rear == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int x = queue[rear];
        if(front == rear) front = rear = -1;
        else {
            if(rear == 0) rear = size - 1;
            else rear--;
        }
        return x;
    }

    public void display() {
        if(front < 0) {
            System.out.println("Queue is empty");
            return;
        }
        int i=front;
        while(i != rear) {
            System.out.print(queue[i] + " ");
            i = (i+1) % size;
        }
        System.out.print(queue[i]);
        System.out.println();
    }
}