package your_code;

import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList <Integer> ll;

    public MyPriorityQueue() {
        ll = new LinkedList<>();
    }

    public void enqueue(int item) {
        // TODO
        ll.add(item);

    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        // TODO
        int count = 0;
        int index=0;
        int max = ll.get(count);
        while (count<ll.size()){
            if (ll.get(count)>max){
                max = ll.get(count);
                index = count;
            }
            count++;
        }
        ll.remove(index);
        return max;
    }

}