import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class DequeTest {

    private Deque<Integer> deque;

    @Before
    public void setup(){
        deque = new Deque<>();
    }


    @Test
    public void addFirstTest(){
        deque.addFirst(1);
        Assert.assertTrue(deque.size() == 1 );

        Assert.assertEquals(new Integer(1), deque.removeLast());
    }


    @Test
    public void addLastTest(){
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(3), deque.removeFirst());
    }


    @Test
    public void iteratorTest(){
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        Iterator<Integer> iter = deque.iterator();
        deque.removeLast();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }


    }


}