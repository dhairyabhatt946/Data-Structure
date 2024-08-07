public class Lab12_67 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(18);
        list.add(6);
        list.add(10);
        list.add(3);
        list.display();
        System.out.println();
        list.addGCD_Node();
        list.display();
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

    public void add(int info) {
        Node newNode = new Node(info);
        if (first == null) {
            first = newNode;
            System.out.println("Element inserted succesfully\n");
            return;
        }
        Node last = first;
        while (last.link != null) {
            last = last.link;
        }
        last.link = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public void display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + ", ");
            temp = temp.link;
        }
    }

    public void addGCD_Node() {
        if(first == null || first.link == null) return;
        Node current = first;
        while(current.link != null) {
            int gcd = 1;
            for(int i=Math.min(current.info, current.link.info); i>=1; i--) {
                if(current.info % i == 0 && current.link.info % i == 0) {
                    gcd = i;
                    break;
                }
            }
            Node newNode = new Node(gcd);
            Node temp = current.link;
            current.link = newNode;
            newNode.link = temp;
            current = temp;
        }
    }
}

