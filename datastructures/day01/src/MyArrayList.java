public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        // TODO
        elems = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public void add(Cow c) {
        // TODO
        size ++;
         if (size>=elems.length){
            grow();
        }
        elems[size-1] = c;
    }

    // TODO: Runtime: O1?)
    public int size() {
        // TODO
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        // TODO
        if (elems[index] != null){
            return elems[index];
        }
        else{
            throw new IndexOutOfBoundsException("your message goes here");
        }
    }

    // TODO: Runtime: O(N)
    public Cow remove(int index) {
        // TODO
        if (elems[index] != null){
            Cow temp = elems[index];
            int j;
            for (j = index; j < elems.length-1; j++) {
                elems[j]= elems[j+1];
            }
            size--;
            shrink();
            return temp;
        }
        else{
            throw new IndexOutOfBoundsException("your message goes here");
        }
    }

    public void grow() {
        // TODO
        if (size>elems.length) {
            Cow[] temp = new Cow[elems.length *2];
            System.arraycopy(elems, 0, temp, 0, elems.length);
            elems = temp;
        }

    }

    public void shrink() {
        // TODO
        if (size<elems.length/4) {
            Cow[] temp = new Cow[elems.length/2];
            System.arraycopy(elems, 0, temp, 0, elems.length);
            elems = temp;
        }

    }

    // TODO: Runtime: O(N)
    public void add(int index, Cow c) {
        // TODO
        if (size<index){
            throw new IndexOutOfBoundsException();
        }
        size++;
        System.out.println(size);
        System.out.println(elems.length);
        if (index==elems.length) {
            grow();
        }
        int j;
        for (j = elems.length - 1; j > index; j--) {
            elems[j] = elems[j - 1];
        }
        elems[index] = c;
    }
}