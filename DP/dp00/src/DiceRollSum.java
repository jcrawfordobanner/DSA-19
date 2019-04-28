import java.util.HashMap;

public class DiceRollSum {

    // Runtime: TODO
    // Space: TODO
    public static int diceRollSum(int N) {
        // TODO
        HashMap<Integer,Integer> answers = new HashMap<>();
        return recurse(N,answers);
    }

    private static int recurse(int N, HashMap<Integer,Integer> memo){
        int cost=0;
        if(N==0){
            return 1;
        }
        if(N<0){
            return 0;
        }
        if(memo.containsKey(N)){
            return memo.get(N);
        }
        for(int i = 1; i<7;i++){
            cost+=recurse(N-i,memo);
        }
        memo.put(N,cost);
        return cost;
    }

}
