import java.util.Arrays;

public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO
        int max =0;
        for(int i =0; i<A.length;i++){
            if(A[i]>max){
                max = A[i];
            }
        }
        int[] count = new int[max+1];
        for (int w: A){
            count[w]++;
        }
        int i =0;
        for(int j = 0; j<max+1;j++){
            while(count[j]>0){
                A[i] = j;
                count[j]--;
                i++;
            }
        }
    }

}
