import java.util.Scanner;

public class Lab11_60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int data, choice = 0, i=0;

        do {
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Peep\n5. Change\n6. Display\n-1. Exit");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter data to enter");
                    data = sc.nextInt();
                    stack.push(data);
                    break;

                case 2:
                    System.out.println(stack.pop());
                    break;

                case 3:
                    System.out.println(stack.peek());
                    break;

                case 4:
                    System.out.println("Enter the index to peep");
                    i = sc.nextInt();
                    System.out.println(stack.peep(i));
                    break;
                
                case 5:
                    System.out.println("Enter data to change: ");
                    data = sc.nextInt();
                    System.out.println("Enter index to change");
                    i = sc.nextInt();
                    stack.change(data, i);
                    break;

                case 6:
                    stack.display();
                    break;

                default:
                    if(choice != -1) {
                        System.out.println("Invalid input");
                        break;
                    }
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

class Stack{
    Node first = null;
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public int pop() {
        if(first == null) {
            System.out.println("Satck is empty");
            return 0;
        }
        int num = first.data;
        Node temp = first;
        first = first.next;
        temp = null;
        return num;
    }

    public int peek() {
        if(first == null) {
            System.out.println("Satck is empty");
            return 0;
        }
        return first.data;
    }

    public int peep(int i) {
        if(first == null) {
            System.out.println("Satck is empty");
            return 0;
        }
        Node current = first;
        for(int j = 1; j < i; j++) {
            if(current.next != null) {
                current = current.next;
            }
            else {
                if(j != i-1) {
                    System.out.println("Index out of bound");
                    return 0;
                }
                else {
                    return current.data;
                }
            }
        }
        return current.data;
    }

    public void change(int data, int i) {
        if(first == null) {
            System.out.println("Satck is empty");
            return;
        }
        Node current = first;
        for(int j = 1; j < i; j++) {
            if(current.next != null) {
                current = current.next;
            }
            else {
                if(j != i-1) {
                    System.out.println("Index out of bound");
                    return;
                }
                else {
                    current.data = data;
                    return;
                }
            }
        }
        current.data = data;
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
    }
}
