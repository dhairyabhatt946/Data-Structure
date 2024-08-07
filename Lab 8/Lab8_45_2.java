import java.util.*;

public class Lab8_45_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix expression");
        String infix = sc.next();
        infix += ")";
        Stack stack = new Stack(infix.length());

        stack.push('(');
        String polish = "";
        for(int i=0; i<infix.length(); i++) {
            char ch = infix.charAt(i);
            if(ch=='(') stack.push(ch);
            else if(ch==')') {
                char temp = stack.pop();
                while(temp != '(') {
                    polish += temp + "";
                    temp = stack.pop();
                }
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                while(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^') {
                    if(precedence(stack.peek()) >= precedence(ch)) {
                        polish += stack.pop() + "";
                    }
                    else {
                        stack.push(ch);
                        break;
                    }
                }
                if(stack.peek() != ch) {
                    stack.push(ch);
                }
            }
            else if(ch=='^') {
                while(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^') {
                    if(precedence(stack.peek()) > precedence(ch)) {
                        polish += stack.pop() + "";
                    }
                    else {
                        stack.push(ch);
                        break;
                    }
                }
                if(stack.peek() != ch) {
                    stack.push(ch);
                }
            }
            else polish += ch;
        }
        System.out.println(polish);
        sc.close();
    }

    public static int precedence(char temp) {
        if(temp=='+' || temp=='-') return 1;
        else if(temp=='*' || temp=='/') return 2;
        else return 3;
    }
}

class Stack {
    char[] stack;
    int size;
    int top = -1;

    public Stack(int size) {
        this.size = size;
        stack = new char[size];
    }

    public void push(char ch) {
        if(top >= size-1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = ch;
    }

    public char pop() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        top--;
        return stack[top+1];
    }

    public char peek() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return stack[top];
    }
}
