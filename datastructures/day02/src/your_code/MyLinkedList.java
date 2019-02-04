package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        // TODO
        size = 0;
        head= new Node(null);
        tail = new Node(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        // TODO
        if (size==0){
            tail = new Node(c,null,null);
            head = tail;
            size++;
        }

        else{
            Node temp= tail;
            tail = new Node(c,temp,null);
            temp.next = tail;
            size++;
        }
    }

    public void addFirst(Chicken c) {
        // TODO
        if (size==0){
            head =new Node(c, null,null);
            tail=head;
            size++;
        }

        else{
            Node temp = head;
            head = new Node(c,null,temp);
            temp.prev = head;
            size++;
        }
    }

    public Chicken get(int index) {
        // TODO
        Node current=head;
        while(index>0){
            current=current.next;
            index--;
        }
        return current.val;
    }

    public Chicken remove(int index) {
        // TODO
        if (size == 0){
            return null;
        }

        else if (size == 1){
            Node temp = head;
            head= new Node(null);
            size--;
            return temp.val;
        }

        else{
            Node current=head;
            while(index>0){
                current=current.next;
                index--;
            }
            if (current!=tail){
                current.next.prev=current.prev;
            }

            if (current==tail){
                tail=current.prev;
                current.prev.next=null;
            }
            if (current!=head){
                current.prev.next=current.next;
            }
            if (current==head){
                head=current.next;
                current.next.prev=null;
            }
            size--;
            return current.val;
        }
    }

    public Chicken removeFirst() {
        // TODO
        if (size == 0){
            return null;
        }

        else if (size == 1){
            Node temp = head;
            head= new Node(null);
            size--;
            return temp.val;
        }

        else{
            Node temp = head;
            head= temp.next;
            temp.next.prev=null;
            size--;
            return temp.val;
        }
    }

    public Chicken removeLast() {
        // TODO
        if (size == 0){
            return null;
        }

        else if (size == 1){
            Node temp = tail;
            tail= new Node(null);
            size--;
            return temp.val;
        }

        else{
            Node temp = tail;
            tail= temp.prev;
            temp.prev.next=null;
            size--;
            return temp.val;
        }
    }
}