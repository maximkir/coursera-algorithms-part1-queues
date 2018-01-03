import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> firstNode;

    private Node<Item> lastNode;

    private int size = 0;

    public Deque() {

    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        checkItemNotNull(item);
        Node<Item> node = new Node<>(item);

        if (size()==0) {
            this.firstNode = this.lastNode = node;
            size++;
            return;
        }
        size++;
        this.firstNode.prev = node;
        node.next = firstNode;
        this.firstNode = node;
    }

    public void addLast(Item item){
        checkItemNotNull(item);
        Node<Item> node = new Node<>(item);

        if (size() == 0) {
            this.firstNode = this.lastNode = node;
            size++;
            return;
        }
        size++;
        lastNode.next = node;
        node.prev = lastNode;
        this.lastNode = node;
    }

    public Item removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        Node<Item> n = this.firstNode;
        firstNode = this.firstNode.next;
        size--;
        return n.data;
    }

    public Item removeLast(){
        if (isEmpty()) throw new NoSuchElementException();
        Node<Item> last = this.lastNode;
        this.lastNode = last.prev;
        size--;
        return last.data;
    }

    @Override
    public Iterator<Item> iterator() {



        return new Iterator<Item>() {

            private Item[] items = createSnapshot();
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < items.length;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                return items[iteratorIndex++];
            }
        };
    }

    private Item[] createSnapshot(){
        Item[] snap = (Item[])new Object[size()];
        int pos = 0;
        Node<Item> item = firstNode;
        while (item != null && item.data != null){
            snap[pos++] = item.data;
            item = item.next;
        }
        return snap;
    }


    private void checkItemNotNull(Item item){
        if (item == null) throw  new IllegalArgumentException();
    }


    private static class Node<T> {
        private final T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
