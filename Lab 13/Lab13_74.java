public class Lab13_74 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtLast(0);
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);

        if(list.first == null) {
            System.out.println("List is empty");
            return;
        }
        if(list.first == list.last) {
            System.out.println("List has only one element");
            return;
        }
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        Node current = list.first;
        for(int i=1; i<=Math.ceil(list.count()/2.0); i++) {
            list1.insertAtLast(current.info);
            current = current.link;
        }
        while(current != list.last) {
            list2.insertAtLast(current.info);
            current = current.link;
        }
        list2.insertAtLast(current.info);

        System.out.println("List 1");
        list1.display();
        System.out.println("List 2");
        list2.display();
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
    Node last = null;

    public void insertAtLast(int info) {
        Node newNode = new Node(info);
        if(first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        newNode.link = first;
        last.link = newNode;
        last = newNode;
        System.out.println("Element inserted successfully");
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        while(current != last) {
            System.out.print(current.info + ", ");
            current = current.link;
        }
        System.out.print(current.info);
        System.out.println();
    }

    public int count() {
        if(first == null) return 0;
        if(first == last) return 1;
        Node current = first;
        int count = 1;
        do {
            current = current.link;
            count++;
        } while(current != last);
        return count;
    }
}
