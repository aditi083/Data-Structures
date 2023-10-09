public class DoublyLinkedList {
    public Node head;
    int size;

    public class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value= value;
        }

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev = node; 
        }
        head = node;
        size++;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " <-> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void displayRev(){
        Node node = head;
        Node last = null;
        while( node != null){
            last = node;
            node = node.next;
        }
        while(last != null){
            System.out.print(last.value + " <-> ");
            last = last.prev;
        }
        System.out.println("null");
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
        node.next = null;
        if(head == null){
            head = node;
            node.prev = null;
            return;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        size++;
    }

    public Node get(int index){
        Node node = head;
        for(int i =0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public void insert(int val, int index){
        Node p = get(index-1);
        if(p == null){
            System.out.println("Does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();
        dlist.insertFirst(34);
        dlist.insertFirst(12);
        dlist.insertFirst(3);
        dlist.insertLast(14);
        dlist.insertLast(5);
        dlist.insert(77,3);

        dlist.display();
        // dlist.displayRev();
    }
}
