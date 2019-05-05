public class Regex {

    public static boolean isMatch(String s, String p) {

        boolean [][] DP = new boolean [s.length()+1][p.length()+1];
        DP[0][0]=true;
        for(int j = 1; j<p.length()+1;j++){
            if(p.charAt(j-1)=='*'){
                DP[0][j] = DP[0][j-2];
            }
        }
        return solver(s,p,DP);
    }

    public static boolean solver(String s, String p, boolean[][]DP){

        for(int i =1; i<=s.length();i++){
            for(int j = 1; j<=p.length();j++){
                if(DP[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1)){
                    DP[i][j]=true;
                }
                else if(p.charAt(j-1)=='.' && DP[i-1][j-1]){
                    DP[i][j]=true;
                }
                else if(p.charAt(j-1)=='*'){// && (DP[i-1][j-1] || DP[i][j-1] || DP[i-1][j])){
                    DP[i][j]= DP[i][j-2];
                    if(p.charAt(j-2)=='.' ||  p.charAt(j-2)==s.charAt(i-1)){
                        if(DP[i-1][j] || DP[i][j]) {
                            DP[i][j] = true;
                        }
                    }
                }
//                else if(p.charAt(j-1)=='*'){
//                    int a = i-1;
//                    int b = j-1;
//                    while(a>0 && b>0){
//                        if(DP[a][b]){
//                            DP[i][j]=true;
//                            break;
//                        }
//                        a--;
//                        b--;
//                    }
//                }
                else{
                    DP[i][j]=false;
                }
            }
        }
        //printer(DP);
        return DP[s.length()][p.length()];
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
