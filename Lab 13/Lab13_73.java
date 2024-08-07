public class Lab13_73 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);
        System.out.println("Before Deletion");
        list.display();
        list.deleteAlternateNodes();
        System.out.println("After deletion");
        list.display();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class LinkedList {
    Node first = null;
    Node last = null;

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = last = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        System.out.println("Element inserted successfully");
    }

    public void display() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        while(current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    // public void deleteAlternateNodes() {
    //     if(first == null) {
    //         System.out.println("List is empty");
    //         return;
    //     }
    //     if(first == last) {
    //         return;
    //     }
    //     Node current = first;
    //     int count = 1;
    //     while(current.next != null) {
    //         current = current.next;
    //         count++;

    //         if(count == 2) {
    //             if(current.next == null) {
    //                 current.prev.next = null;
    //                 current = null;
    //                 break;
    //             }
    //             else {
    //                 current.prev.next = current.next;
    //                 current.next.prev = current.prev;
    //                 Node temp = current;
    //                 current = current.next;
    //                 temp = null;
    //                 count = 1;
    //             }
    //         }
    //     }
    // }

    public void deleteAlternateNodes() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        if(first == last) {
            return;
        }
        Node current = first.next;
        while(current != null) {
            if(current.next == null) {
                current.prev.next = null;
                current = null;
                break;
            }
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                Node temp = current;
                current = current.next.next;
                temp = null;
            }
        }
    }
}
