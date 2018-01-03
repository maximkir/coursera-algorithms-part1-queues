import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] refs;
    private int lastIndex = 0;
    private int size = 0;

    public RandomizedQueue(){
        this.refs = (Item[]) new Object[32];
    }


    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return this.size;
    }


    public void enqueue(Item item){
        if (item == null) throw new IllegalArgumentException();
        performResizeIfNeeded();
        refs[lastIndex++] = item;
        size++;
    }


    public Item dequeue(){
        if (size() == 0) throw  new NoSuchElementException();
        int itemToDequeue = StdRandom.uniform(lastIndex);
        Item data = refs[itemToDequeue];
        refs[itemToDequeue] = refs[lastIndex - 1];
        refs[lastIndex - 1] = null;
        lastIndex--;
        size--;
        return data;
    }


    public Item sample(){
        if (size() == 0) throw  new NoSuchElementException();
        int itemToDequeue = StdRandom.uniform(lastIndex);
        return refs[itemToDequeue];
    }


    @Override
    public Iterator<Item> iterator() {
        int[] refIndexes = copyRefIndexes();
        StdRandom.shuffle(refIndexes);
        return new Iterator<Item>() {

            int next = 0;

            @Override
            public boolean hasNext() {
                return next < refIndexes.length;
            }

            @Override
            public Item next() {
                if ( !hasNext() ) throw new NoSuchElementException();
                return refs[refIndexes[next++]];
            }
        };
    }

    private int[] copyRefIndexes(){
        int[] indexs = new int[refs.length];
        for (int i = 0; i < indexs.length; i++){
            indexs[i] = i;
        }
        return indexs;
    }

    private void performResizeIfNeeded(){
        if ( size() == refs.length ){
            Item[] resizedRefs = (Item[])new Object[refs.length * 2];
            for (int i = 0; i < size(); i++){
                resizedRefs[i] = refs[i];
            }
            this.refs = resizedRefs;
        }
    }

}
