import java.util.*;

public class Lab8_47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix expression");
        String postfix = sc.nextLine();
        double ans = evalpostfix(postfix);
        System.out.println("Result: "+ans);
        sc.close();
    }

    public static double evalpostfix(String postfix) {
        Stack<Double> stack = new Stack<Double>();
        String[] arr = postfix.split(",");
        for(int i=0; i<arr.length; i++) {
            String temp = arr[i];
            temp = temp.trim();
            if(isOperator(temp)) {
                double opd1, opd2;
                if(!stack.isEmpty()) opd2 = stack.pop();
                else {
                    System.out.println("Invalid postfix expression");
                    return 0;
                }
                if(!stack.isEmpty()) opd1 = stack.pop();
                else {
                    System.out.println("Invalid postfix expression");
                    return 0;
                }

                switch (temp) {
                    case "+":
                        stack.push(opd1+opd2);
                        break;

                    case "-":
                        stack.push(opd1-opd2);
                        break;

                    case "*":
                        stack.push(opd1*opd2);
                        break;

                    case "/":
                        stack.push(opd1/opd2);
                        break;

                    case "^":
                        stack.push(Math.pow(opd1, opd2));
                        break;
                }
            }
            else {
                for(int j=0; j<temp.length(); j++) {
                    if(!Character.isDigit(temp.charAt(j))) {
                        System.out.println("Invalid postfix expression");
                        return 0;
                    }
                }
                stack.push(Double.parseDouble(temp));
            }
        }
        double ans = stack.pop();
        if(!stack.isEmpty()) {
            System.out.println("Invalid postfix expression");
            return 0;
        }
        return ans;
    }

    public static boolean isOperator(String temp) {
        if(temp.length() != 1) return false;
        if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("^")) return true;
        return false;
    }
}