import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;

    //TODO
    // Create a 2D array representing the solved board state
    private int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        // TODO: Your code here
        tiles =b;
        n = tiles.length;
    }

    /*
     * Size of the board
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
        // TODO: Your code here
        return tiles.length;
    }

    /*
    Make a  D E E P  copy of a thicc 2D array
     */
    private static int[][] copyOf(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        // TODO: Your code here
        int sum = 0;
        for (int i =0; i<tiles.length;i++){
            for(int j = 0; j<tiles[0].length;j++){
                if (tiles[i][j]!=0){
                    sum+=Math.abs(i-(tiles[i][j]-1)/n);
                    sum+=Math.abs(j-(tiles[i][j]-1)%n);
                }
            }
        }
        return sum;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        // TODO: Your code here
        if(equals(goal)){
            return true;
        }
        return false;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        // TODO: Your code here
        int sum = 0;
        for (int i =0; i<n*n;i++){
            int idealy = i/n;
            int idealx = i%n;
            if(tiles[idealy][idealx]!=0) {
                for (int j = i + 1; j < n * n; j++) {
                    int jdealy = j / n;
                    int jdealx = j % n;
                    if (tiles[idealy][idealx] < tiles[jdealy][jdealx] && tiles[jdealy][jdealx] != 0) {
                        sum++;
                    }
                }
            }
        }
        if(sum%2==0){
            return true;
        }
        return false;
    }



    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors(){
        // TODO: Your code here
        List<Board> neighbor=new ArrayList<>();
        int blanki=0;
        int blankj=0;
        for(int i =0; i<n; i++){
            for (int j = 0;j<n;j++ ){
                if(tiles[i][j]==0){
                    blanki=i;
                    blankj=j;
                    break;
                }
            }
        }
        if(blanki+1<n){
            int[][] temp = copyOf(tiles);
            temp[blanki][blankj]=temp[blanki+1][blankj];
            temp[blanki+1][blankj]=0;
            neighbor.add(new Board(temp));
        }
        if(blanki-1>=0){
            int[][] temp = copyOf(tiles);
            temp[blanki][blankj]=temp[blanki-1][blankj];
            temp[blanki-1][blankj]=0;
            neighbor.add(new Board(temp));
        }
        if(blankj-1>=0){
            int[][] temp = copyOf(tiles);
            temp[blanki][blankj]=temp[blanki][blankj-1];
            temp[blanki][blankj-1]=0;
            neighbor.add(new Board(temp));
        }
        if(blankj+1<n){
            int[][] temp = copyOf(tiles);
            temp[blanki][blankj]=temp[blanki][blankj+1];
            temp[blanki][blankj+1]=0;
            neighbor.add(new Board(temp));
        }
        return neighbor;
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }
}
