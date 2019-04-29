public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        // TODO: Your code here
        int[][]memo = new int[map.length][map.length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                memo[i][j]=100;
            }
        }
        return  solver(map,0,memo,0,0)+1;
    }

    public static int solver(int[][] map, int reqhp, int [][] memo,int curri, int currj){
        int val = map[curri][currj] + reqhp;
        if(memo[curri][currj]!=100 && Math.abs(memo[curri][currj])<Math.abs(val)){
            return memo[curri][currj];
        }
        if(curri==map.length-1 && currj==map.length-1){
            memo[curri][currj]= val;
            return val;
        }
        if(curri==map.length-1){
            memo[curri][currj]= solver(map,val,memo,curri,currj+1);
        }
        else if(currj==map.length-1){
            memo[curri][currj]= solver(map,val,memo,curri+1,currj);
        }
        else {
            memo[curri][currj] = Math.min(Math.abs(solver(map, val, memo, curri, currj + 1)), Math.abs(solver(map, val, memo, curri + 1, currj)));
        }
        return memo[curri][currj];
    }

    private static void printer(int [][] guu){
        for(int [] i: guu){
            for(int j =0; j<i.length; j++){
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }
}
