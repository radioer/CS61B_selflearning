import org.jetbrains.annotations.NotNull;

public class LinkedListDeque <T>{

    public class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node nextNode, Node prevNode){
            item = i;
            next = nextNode;
            prev = prevNode;
        }
    }

    private int size;
    private final Node sentinel;
    private final T sentinelItem = null;
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(sentinelItem, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        size = other.size();
        sentinel = new Node(sentinelItem, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        int i = 0;
        while(i < size){
            addFirst(other.get(i));
            i += 1;
        }
    }

    public T getRecursive(int index){
        if (index >= size()){
            return null;
        }
        return helper(sentinel.next, index);
    }

    private T helper(Node p, int index){
        if (index == 0){
            return p.item;
        }
        return helper(p.next, index - 1);
    }
    public void addFirst(T item){
        size += 1;
        Node firstNode = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = firstNode;
        sentinel.next = firstNode;
    }

    public void addLast(T item){
        size += 1;
        Node lastNode = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = lastNode;
        sentinel.prev = lastNode;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item);
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        size -= 1;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        return sentinel.next.item;
    }

    public T removeLast(){
        size -= 1;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        return sentinel.prev.item;
    }

    public T get(int index){
        if (index >= size()){
            return null;
        }
        int i = 0;
        Node p = sentinel;
        while (i <= index){
            p = p.next;
            i += 1;
        }
        return p.item;
    }
}
