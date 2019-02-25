import java.util.Arrays;

public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        // TODO
        if(rightChild(i)<size && leftChild(i)<size){
            if(heap[i]<heap[rightChild(i)] && heap[i]<heap[leftChild(i)]){
                if(heap[leftChild(i)]<heap[rightChild(i)]){
                    int temp = heap[rightChild(i)];
                    heap[rightChild(i)] = heap[i];
                    heap[i]=temp;
                    sink(rightChild(i));
                }
                if(heap[leftChild(i)]>heap[rightChild(i)]){
                    int temp = heap[leftChild(i)];
                    heap[leftChild(i)] = heap[i];
                    heap[i]=temp;
                    sink(leftChild(i));
                }
            }
            if(heap[i]<heap[rightChild(i)]){
                int temp = heap[rightChild(i)];
                heap[rightChild(i)] = heap[i];
                heap[i]=temp;
                sink(rightChild(i));
            }
            if(heap[i]<heap[leftChild(i)]){
                int temp = heap[leftChild(i)];
                heap[leftChild(i)] = heap[i];
                heap[i]=temp;
                sink(leftChild(i));
            }
        }
        if(rightChild(i)<size && heap[i]<heap[rightChild(i)]){
            int temp = heap[rightChild(i)];
            heap[rightChild(i)] = heap[i];
            heap[i]=temp;
            sink(rightChild(i));
        }
        if(leftChild(i)<size && heap[i]<heap[leftChild(i)]){
            int temp = heap[leftChild(i)];
            heap[leftChild(i)] = heap[i];
            heap[i]=temp;
            sink(leftChild(i));
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO
            sink(i);
        }
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
            // TODO
            int temp=heap[0];
            heap[0]=heap[size-1];
            heap[size-1]=temp;
            size--;
            sink(0);
        }
        System.out.println(Arrays.toString(heap));

        return heap;
    }
}
