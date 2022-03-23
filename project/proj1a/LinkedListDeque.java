public class LinkedListDeque<type>{
    public SNode sentinel;
    public Node last;
    public int size;


    public class Node{
       public Node prev;
       public Node next;
       public type value;

       public Node(type value, Node prev, Node next){
           this.value = value;
           this.prev = prev;
           this.next = next;
       }


    }

    public class SNode{
        public Node prev;
        public Node next;
        public String value;

        public SNode(String value, Node prev, Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


    public LinkedListDeque(){
        sentinel = new SNode("sentinel", null, null);
        last = sentinel.next;
    }

    public LinkedListDeque(LinkedListDeque other){
        LinkedListDeque returnLink = new LinkedListDeque();
        Node p = other.sentinel.next;
        while(p!=null){
            returnLink.addLast(p.value);
            p = p.next;
        }


    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return sentinel.next == null;
    }

    public void addFirst(type x){
        if(isEmpty()){
            sentinel.next = new Node(x, null, null);
            last = sentinel.next;
        }
        sentinel.next.prev = new Node(x, null, sentinel.next);
        size += 1;
    }

    public void addLast(type x){
        last.next = new Node(x, last, null);
        last = last.next;
        size += 1;
    }

    public void printDeque(){
        if(!isEmpty()){
            Node p = sentinel.next;
            while(p!=null){
                System.out.println(p.value);
                p = p.next;
            }
            System.out.println('\n');
        }
    }

    public type removeFirst(){
        if(isEmpty()){
            return null;
        }else if(sentinel.next.next == null){
            type returnValue = sentinel.next.value;
            sentinel.next = null;
            return returnValue;
        }
        type returnValue = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev.next = null;
        sentinel.next.prev = null;
        size -= 1;
        return returnValue;
    }

    public type removeLast(){
        if(isEmpty()){
            return null;
        }
        type returnValue = last.value;
        last = last.prev;
        last.next.prev = null;
        last.next = null;
        size -= 1;
        return returnValue;
    }

    public type get(int index){
        Node p = sentinel.next;
        while(p != null && index != 0){
            index -= 1;
            p = p.next;
        }
        if(index==0){
            return p.value;
        }
        return null;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        System.out.println(lld1.isEmpty());
        lld1.addFirst(10);
        lld1.addLast(20);
        System.out.println(lld1.isEmpty());
        lld1.printDeque();
        lld1.removeFirst();
        lld1.printDeque();
    }
}
