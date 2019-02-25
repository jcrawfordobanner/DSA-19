import java.util.*;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        System.out.println(Arrays.toString(out));
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        PriorityQueue<Integer> maxPQ = maxPQ();
        PriorityQueue<Integer> minPQ = minPQ();
        // TODO
        if(inputStream.length==0){
            return runningMedian;
        }
        runningMedian[0]=inputStream[0];
        double med = runningMedian[0];
        for(int i =0; i<inputStream.length;i++){
            if(inputStream[i]<med){
                maxPQ.offer(inputStream[i]);
            }
            if(inputStream[i]>=med){
                minPQ.offer(inputStream[i]);
            }

            if((minPQ.size()-maxPQ.size()>1)){
                int temp =minPQ.poll();
                maxPQ.offer(temp);
            }
            if (maxPQ.size()>minPQ.size()){
                int temp=maxPQ.poll();
                minPQ.offer(temp);
            }
            if ((minPQ.size()-maxPQ.size()>0)){ ;
                runningMedian[i]=minPQ.peek();
            }
            if (!minPQ.isEmpty() && !maxPQ.isEmpty() && maxPQ.size()==minPQ.size()){
                runningMedian[i]=((double)minPQ.peek() + (double)maxPQ.peek())/2;
            }
            med=runningMedian[i];
        }
        System.out.println(Arrays.toString(runningMedian));
        return runningMedian;
    }

}
