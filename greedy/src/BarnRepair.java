import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        // TODO
        Arrays.sort(occupied);
        if(M>occupied.length){
            return occupied.length;
        }
        int sad = 0;
        System.out.println(occupied[0]);
        int max = occupied[occupied.length-1]-(occupied[0]-1);
        PriorityQueue <Integer>gaps= new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0; i<occupied.length-1;i++){
            if(occupied[i + 1] - occupied[i]-1!=0) {
                gaps.add(occupied[i + 1] - occupied[i] - 1);
            }
        }
        System.out.println("number occupied " +occupied.length);
        System.out.println("boards " + M);
        System.out.println("gaps "+ gaps);
        System.out.println("number of gaps "+gaps.size());
        if(M==1){
            return occupied.length+gaps.poll();
        }
        System.out.println(max);
        while(sad<M-1 && !gaps.isEmpty()){
            max-=gaps.poll();
            sad++;
        }
        System.out.println(max);
        return max;
    }
}