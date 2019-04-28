import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestIncreasingSubsequence {
    public static int max =1;
    // Runtime: TODO
    // Space: TODO
    public static int LIS(int[] A) {
        // TODO
        max=1;
        if(A.length==0){
            return 0;
        }
        PriorityQueue<Integer> answers = new PriorityQueue<>();
        int a =0;
        int p= recurse(A,answers);
        System.out.println(max);
        System.out.println(p);
        return max;
    }

    private static int recurse(int[] A, PriorityQueue<Integer> memo){
        int len = 1;
        if(A.length==1){
            return 1;
        }
        for(int j=1;j<A.length;j++){
            int k= recurse(Arrays.copyOfRange(A, 0, j), memo);
            if(A[j-1]<A[A.length-1] && k+1>len){
                len=k+1;
                memo.add(len);
            }
            for(int ak: A){
                System.out.print(ak + " ");
            }
            System.out.println("len "+len);
        }
        if(max<len){
            max=len;
        }
        return len;
    }
}