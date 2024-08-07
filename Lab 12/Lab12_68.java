public class Lab12_68 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.display();
        System.out.println();
        list.swap_consecutive_nodes();
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

    public void swap_consecutive_nodes() {
        if(first == null || first.link == null) return;
        Node current = first;
        Node prev = null;
        Node temp = first.link;
        first.link = first.link.link;
        temp.link = first;
        prev = first;
        current = first.link;
        first = temp;
        while(current != null && current.link != null) {
            prev.link = current.link;
            temp = current.link;
            current.link = current.link.link;
            temp.link = current;
            prev = current;
            current = current.link;
        }
    }
}

