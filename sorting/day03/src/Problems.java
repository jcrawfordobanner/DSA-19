import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO
        PriorityQueue<Integer> killem= new PriorityQueue<>();
        PriorityQueue<Integer> billem= new PriorityQueue<>();
        for(int i=0;i<A.length;i++){
            if(A[i]>=0){
                killem.add(A[i]);
            }
            else{
                billem.add(A[i]);
            }
        }
        int j = 0;
        while(!billem.isEmpty()){
            A[j]=billem.poll();
            if(j<A.length) {
                j++;
            }
        }
        while(!killem.isEmpty()){
            A[j]=killem.poll();
            if(j<A.length) {
                j++;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // TODO
        LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();
        for (String i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            int fope = getNthCharacter(i, n);
            L[fope].add(i);
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            // TODO: Put all numbers in the linked lists into
            for (String pop : list) {
                A[j] = pop;
                if(j<A.length-1) {
                    j++;
                }
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        // TODO
        // TODO: Perform radix sort
        for (int j = 0; j < stringLength; j++) {
            countingSortByCharacter(S, j);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
