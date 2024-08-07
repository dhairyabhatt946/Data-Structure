public class Lab13_76 {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(3, 2);
        p1.addTerm(5, 1);
        p1.addTerm(6, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(6, 1);
        p2.addTerm(8, 0);

        System.out.print("Polynomial 1: ");
        p1.display();

        System.out.print("Polynomial 2: ");
        p2.display();

        Polynomial result = Polynomial.addPolynomials(p1, p2);

        System.out.print("Sum: ");
        result.display();
    }
}

class Node {
    int coefficient;
    int exponent;
    Node next;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    Node head;

    public Polynomial() {
        this.head = null;
    }

    // Method to add a new term to the polynomial
    public void addTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null || head.exponent < exponent) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.exponent >= exponent) {
                current = current.next;
            }
            if (current.exponent == exponent) {
                current.coefficient += coefficient;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    // Method to add two polynomials
    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        Node t1 = p1.head;
        Node t2 = p2.head;

        while (t1 != null && t2 != null) {
            if (t1.exponent == t2.exponent) {
                result.addTerm(t1.coefficient + t2.coefficient, t1.exponent);
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.exponent > t2.exponent) {
                result.addTerm(t1.coefficient, t1.exponent);
                t1 = t1.next;
            } else {
                result.addTerm(t2.coefficient, t2.exponent);
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            result.addTerm(t1.coefficient, t1.exponent);
            t1 = t1.next;
        }

        while (t2 != null) {
            result.addTerm(t2.coefficient, t2.exponent);
            t2 = t2.next;
        }

        return result;
    }

    // Method to display the polynomial
    public void display() {
        if (head == null) {
            System.out.println("0");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.coefficient != 0) {
                if (current != head && current.coefficient > 0) {
                    System.out.print(" + ");
                }
                System.out.print(current.coefficient + "x^" + current.exponent);
            }
            current = current.next;
        }
        System.out.println();
    }
}
