import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class SplitCoins {
    static int sum;

    public static int splitCoins(int[] coins) {
        // TODO
        sum=0;


        for(int i =0; i<coins.length;i++){
            sum+=coins[i];
        }
        boolean [][] DP = new boolean [(sum/2)+1][coins.length+1];
        for(int i =0; i<(sum/2)+1;i++){
            for(int j = 0; j<coins.length+1;j++){
                if(i==0){
                    DP[i][j]=true;
                }
                if(j==0&&i>0){
                    DP[i][j]=false;
                }
            }
        }
        return solver(coins,DP,0);
    }

    public static int solver(int[] coins, boolean[][]DP,int accum){

        for(int i =1; i<=sum/2;i++){
            for(int j = 1; j<=coins.length;j++){
                if(DP[i][j-1]){
                    DP[i][j]=true;
                }
                else if(i-coins[j-1]>=0 && DP[i-coins[j-1]][j-1]){
                    DP[i][j]=true;
                }
                else{
                    DP[i][j]=false;
                }
            }
        }
        for(int k =(sum/2); k>=0;k--){
            if(DP[k][coins.length]){
                return sum-2*(k);
            }
        }
        return 0;
    }

    private static void printer(boolean[][] guu){
        for(int i = 0; i<guu.length;i++){
            for(int j =0; j<guu[0].length; j++){
                System.out.print(guu[i][j]);
            }
            System.out.println();
        }
    }
}
