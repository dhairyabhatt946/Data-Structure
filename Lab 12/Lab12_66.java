import java.util.Scanner;

public class Lab12_66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;
        LinkedList list = new LinkedList();
        do {
            System.out.println("Enter 1 to insert a node at the first of the linked list");
            System.out.println("Enter 2 to insert a node at the end of the linked list");
            System.out.println("Enter 3 to insert a node at any position in the linked list");
            System.out.println("Enter 4 to delete a node from first of the linked list");
            System.out.println("Enter 5 to delete a node from the last of the linked list");
            System.out.println("Enter 6 to delete a node from any position of the linked list");
            System.out.println("Enter 7 to display the linked list");
            System.out.println("Enter 8 to count the nodes");
            System.out.println("Enter -1 to exit the menu: \n");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data to enter: ");
                    data = sc.nextInt();
                    list.insertAtFirst(data);
                    break;

                case 2:
                    System.out.println("Enter data to enter: ");
                    data = sc.nextInt();
                    list.insertAtLast(data);
                    break;

                case 3:
                    System.out.println("Enter data to enter: ");
                    data = sc.nextInt();
                    System.out.println("Enter a position at which you want to enter the data: ");
                    pos = sc.nextInt();
                    list.insertAtAnyPosition(data, pos);
                    break;

                case 4:
                    list.deleteFromFirst();
                    break;

                case 5:
                    list.deleteFromLast();
                    break;

                case 6:
                    System.out.println("Enter the position to delete the data: ");
                    pos = sc.nextInt();
                    list.deleteFromAnyPosition(pos);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    list.count();
                    break;

                default:
                    if (choice != -1) {
                        System.out.println("Invalid input");
                        break;
                    }
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice != -1);

        System.out.println("Enter the kth node to replace");
        int k = sc.nextInt();
        list.replace(k);
        list.display();

        sc.close();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node first = null;

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            System.out.println("Element inserted succesfully\n");
            return;
        }
        Node last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public void insertAtAnyPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (first == null) {
            if (pos == 1) {
                insertAtFirst(data);
                return;
            } else {
                System.out.println("Position not Found\n");
                return;
            }
        } else if (pos == 1) {
            insertAtFirst(data);
            return;
        }
        Node current = first;
        Node previous = null;
        for (int i = 1; i < pos; i++) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else {
                if (i == pos - 1) {
                    insertAtLast(data);
                    return;
                } else {
                    System.out.println("Position not found\n");
                    return;
                }
            }
        }
        newNode.next = previous.next;
        previous.next = newNode;
        System.out.println("Element inserted succesfully\n");
    }

    public void deleteFromFirst() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = first;
        first = first.next;
        temp = null;
        System.out.println("Element deleted succesfully\n");
    }

    public void deleteFromLast() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (first.next == null) {
            first = null;
            System.out.println("Element deleted succesfully\n");
            return;
        }
        Node current = first;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        current = null;
        previous.next = null;
        System.out.println("Element deleted succesfully\n");
    }

    public void deleteFromAnyPosition(int pos) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) {
            deleteFromFirst();
            return;
        }
        Node current = first;
        Node previous = null;
        for (int i = 1; i < pos; i++) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else {
                System.out.println("Position not found");
                return;
            }
        }
        previous.next = current.next;
        current = null;
        System.out.println("Element deleted succesfully\n");
    }

    public void display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }

    public int count() {
        if (first == null) {
            System.out.println("List is empty");
            return 0;
        }
        Node current = first;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void replace(int k) {
        if (k > count() || k < 0) {
            System.out.println("Position not found");
            return;
        } else if (first == null || first.next == null)
            return;
        Node node1 = null;
        Node node1_pred = null;
        Node node2 = null;
        Node node2_pred = null;
        Node current = first;
        Node prev = null;
        for (int i = 1; i <= count(); i++) {
            if (i == k) {
                node1 = current;
                node1_pred = prev;
            }
            if (i == count() - (k - 1)) {
                node2 = current;
                node2_pred = prev;
            }
            prev = current;
            current = current.next;
        }
        if (node1 != node2) {
            if (node2_pred == node1) {
                if (node1_pred != null)
                    node1_pred.next = node2;
                node1.next = node2.next;
                node2.next = node1;
            } else {
                Node temp = node1.next;
                node2_pred.next = node1;
                node1.next = node2.next;
                if (node1_pred != null)
                    node1_pred.next = node2;
                node2.next = temp;
            }
            if (k == 1 || k == count())
                first = node2;
        }
    }
}