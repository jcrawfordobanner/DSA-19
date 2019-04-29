import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class SplitCoins {

    public static int splitCoins(int[] coins) {
        // TODO
        int sum=0;
        
        PriorityQueue<Integer> mad = new PriorityQueue<>();
        HashMap<Integer,Integer> boi = new HashMap<>();
        for(int i =0; i<coins.length;i++){
            sum+=coins[i];
        }
        int ans = solver(coins,sum, 0,mad,boi);
        System.out.println("ans " +ans);
        return  ans;
    }

    public static int solver(int[] coins, int max, int accum, PriorityQueue<Integer> lis,HashMap<Integer,Integer> pop){
        if(pop.containsKey(accum)){
            return pop.get(accum);
        }
        int left = Math.abs(max-accum);
        int dif = Math.abs(left-accum);
        pop.put(accum,dif);
//        System.out.println("max " + max + " accum " + accum + " left " + left + " dif " +dif);
        if(left<=0){
            return lis.poll();
        }
        lis.add(dif);
        for(int i =0; i<coins.length;i++){
            int[] clone = coins.clone();
            clone[i] = 0;
            if(coins[i]!=0) {
                lis.add(solver(clone, max, accum + coins[i], lis, pop));
            }
        }
        return lis.poll();
    }
}
