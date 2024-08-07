public class Lab12_69 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(13);
        list.add(13);
        list.add(13);
        list.add(27);
        list.add(27);
        list.display();
        System.out.println();
        list.remove_duplicates();
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

    public void remove_duplicates() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        if(first.link == null) {
            return;
        }
        Node current = first;
        while(current != null && current.link != null) {
            Node temp = current.link;
            Node previous = current;
            while(temp != null) {
                if(temp.info == current.info) {
                    previous.link = temp.link;
                    temp = null;
                    temp = previous.link;
                }
                else {
                    break;
                }
            }
            current = current.link;
        }
    }
}
