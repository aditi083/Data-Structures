public class LL{
    public Node head;
    public Node tail;
    int size;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(tail == null){
            insertFirst(val);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if(index<=size){
            if(index == 0){
                insertFirst(val);
                return;
            }
            if(index == size){
                insertLast(val);
                return;
            }

            Node temp = head;
            for(int i = 1; i<index; i++){
                temp = temp.next;
            }

            Node node = new Node(val,temp.next);
            temp.next=node;
            size++;
        }
    }

    public void display(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i =0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        int val = tail.value;
        Node secondLast = get(size-2);
        tail = secondLast;
        tail.next = null;
        size--;

        return val;
    }

    public int deleteAt(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;

        return val;
    }

    public boolean find(int value){
        Node node = head;
        while(node != null){
            if(node.value==value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public class Node{
        int value;
        Node next;

        public Node(int value){
            this.value= value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index, node.next);
        return node;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(12);
        list.insertFirst(3);
        list.insertFirst(14);
        list.insertFirst(5);
        list.insertLast(7);
        list.insertLast(23);
        list.insert(13,3);
        // System.out.println(list.deleteAt(3));
        // System.out.println(list.find(12));
        list.insertRec(88, 2);
        list.display();
    }
}