import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BalloonPopping {

    public static int maxPoints(int[] B) {
        int[] A = new int[B.length + 2];
        int[][] DP = new int[B.length + 2][B.length + 2];
        A[0] = 1;
        A[DP.length - 1] = 1;
        for (int i = 0; i < B.length; i++) {
            A[i + 1] = B[i];
        }

        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP.length; j++) {
                DP[i][j] = 0;
            }
        }

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i; j >= 1; j--) {
                for (int k = j; k <= i; k++) {
                    DP[j][i]=Math.max(A[j-1]*A[k]*A[i+1] + DP[j][k-1] + DP[k+1][i],DP[j][i]);
                }
            }
        }
        return DP[1][A.length-2];
    }

}