import java.util.Scanner;

class Stack {
    int top = -1;
    int size = 0;
    int[] stack;
    
    public Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push(int num) {
        if(top >= size-1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = num;
        System.out.println("Element inserted succesfully");
        display();
    }

    public int pop() {
        if(top<0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        top--;
        display();
        return stack[top+1];
    }

    public int peep(int i) {
        if(top-i+1 < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        display();
        return stack[top-i+1];
    }

    public void change(int num, int i) {
        if(top-i+1 < 0) {
            System.out.println("Stack Underflow");
            return;
        }
        stack[top-i+1] = num;
        System.out.println("Element changed succesfully");
        display();
    }

    public void display() {
        for(int i=top; i>=0; i--) {
            System.out.println("stack["+i+"] = "+stack[i]);
        }
    }
}

public class Lab7_38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        int choice;
        do{
            System.out.println();
            System.out.println("Enter 1 to insert an element\n2 to delete an element from the top\n3 to view an element at any position\nEnter 4 to change element from any position\nEnter 5 to display the stack\nEnter -1 to terminate the menu: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter an element to insert: ");
                    int num = sc.nextInt();
                    stack.push(num);
                    break;

                case 2:
                    System.out.println("Deleted Element is "+stack.pop());
                    break;

                case 3:
                    System.out.println("Enter the position from top to view the element: ");
                    int i = sc.nextInt();
                    System.out.println("Element at position "+i+" is "+stack.peep(i));
                    break;

                case 4:
                    System.out.println("Enter the position to change the element: ");
                    int pos = sc.nextInt();
                    System.out.println("Enter an element to update at possition "+pos+": ");
                    int n = sc.nextInt();
                    stack.change(n, pos);
                    break;

                case 5:
                    stack.display();
                    break;

                default:
                    System.out.println("Invalid Input");
            }
        } while(choice != -1);
        sc.close();
    }
}
