import java.util.PriorityQueue;

public class EditDistance {

    public static int minEditDist(String a, String b) {
        // TODO: Your code here
        if(a.equals("")){
            return b.length();
        }
        if(b.equals("")){
            return a.length();
        }
        a=" " + a;
        b = " "+b;
        int [][] DP = new int[a.length()][b.length()];
        for(int s =0; s<a.length();s++){
            DP[s][0]=s;
        }
        for(int s =0; s<b.length();s++){
            DP[0][s]=s;
        }
        for (int i=1;i<a.length();i++){
            for(int j=1; j<b.length();j++){
                PriorityQueue<Integer> arr = new PriorityQueue<>();
                arr.add(DP[i-1][j-1]);
                arr.add(DP[i][j-1]);
                arr.add(DP[i-1][j]);
                if(a.substring(0,i+1).equals(b.substring(0,j+1))){
                    DP[i][j]=0;
                }
                else if(a.charAt(i)==b.charAt(j)){
                    DP[i][j]=DP[i-1][j-1];
                }
                else{
                    DP[i][j]=arr.poll()+1;
                }
            }
        }
        printer(DP);
        return DP[a.length()-1][b.length()-1];
    }

    private static void printer(int [][] guu){
        for(int i = 0; i<guu.length;i++){
            for(int j =0; j<guu[0].length; j++){
                System.out.print(guu[i][j]);
            }
            System.out.println();
        }
    }

}
