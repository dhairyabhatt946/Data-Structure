import java.util.Scanner;

public class Lab13_75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        LinkedList list = new LinkedList();

        int choice;
        String song;

        do {
            list.display();
            System.out.println("Enter 1 to add a song");
            System.out.println("Enter 2 to delete a song");
            System.out.println("Enter 3 for next song");
            System.out.println("Enter 4 for previous song");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a song to add");
                    song = scanner.nextLine();
                    list.insertAtLast(song);
                    break;

                case 2:
                    if(list.save != null) list.delete(list.save.song);
                    break;

                case 3:
                    if (list.save != null) list.save = list.save.next;
                    break;

                case 4:
                    if (list.save != null) list.save = list.save.prev;
                    break;
            
                default:
                    if(choice != -1) System.out.println("Invalid Input");
            }
        } while(choice != -1);
        sc.close();
        scanner.close();
    }    
}

class Node {
    String song;
    Node next;
    Node prev;

    public Node(String song) {
        this.song = song;
        this.prev = null;
        this.next = null;
    }
}

class LinkedList {
    Node first = null;
    Node last = null;
    Node save = null;

    public void insertAtLast(String song) {
        Node newNode = new Node(song);
        if(first == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
            first = last = save = newNode;
            System.out.println("Element inserted successfully");
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        newNode.next = first;
        last = newNode;
        save = last;
        System.out.println("Element inserted successfully");
    }

    public void delete(String song) {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        if(first.song == song) {
            if(first == last) {
                first = last = save = null;
                System.out.println("Element deleted successfully");
                return;
            }
            Node temp = first;
            first = first.next;
            save = first;
            last.next = first;
            temp = null;
            System.out.println("Element deleted successfully");
            return;
        }
        Node current = first;
        while(current.song != song) {
            current = current.next;
            if(current == last) {
                if(current.song == song) {
                    Node temp = last;
                    last = current.prev;
                    first.prev = last;
                    temp = null;
                    save = last;
                    System.out.println("Element deleted successfully");
                    return;
                }
                else {
                    System.out.println("Song doesn't exist");
                    return;
                }
            }
        }
        save = current.prev.next = current.next;
        current.next.prev = current.prev;
        current = null;
        System.out.println("Element deleted successfully");
    }

    public void display() {
        if(save == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print(save.song);
        System.out.println();
    }
}
