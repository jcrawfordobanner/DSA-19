import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if (array.length<INSERTION_THRESHOLD){
            InsertionSort pop = new InsertionSort();
            return pop.sort(array);
        }
        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right =new int[array.length-mid];
        System.arraycopy(array,0,left,0,mid);
        System.arraycopy(array,mid,right,0,array.length-mid);
        int[] sorl = sort(left);
        int[] sorr = sort(right);
        System.out.println(Arrays.toString(merge(sorl,sorr)));
        return merge(sorl,sorr);
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        // TODO
        int[] lko= new int[a.length+b.length];
        int k=0;
        int count = 0;
        int crack = 0;
        int back = 0;
        while(count<a.length+b.length) {
            if (back==b.length) {
                lko[count] = a[crack];
                crack++;
                count++;
            }
            else if (crack==a.length) {
                lko[count] = b[back];
                back++;
                count++;
            }
            else if (a[crack]>=b[back]) {
                lko[count] = b[back];
                back++;
                count++;
            }
            else{
                lko[count] = a[crack];
                crack++;
                count++;
            }
        }
        return lko;
    }

}
