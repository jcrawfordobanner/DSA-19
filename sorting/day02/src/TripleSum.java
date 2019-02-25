import java.util.Arrays;
import java.util.Stack;

import static java.util.Arrays.sort;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        // TODO
        int count=0;
        sort(arr);
        System.out.println(Arrays.toString(arr));
        if (arr.length==3 && (arr[0]+arr[1]+arr[2])==sum){
            return 1;
        }
        for(int i=0;i<arr.length;i++){
            int first = i+1;
            int last = arr.length-1;
            while(first<last){
                System.out.println("first " + first);
                System.out.println("last " + last);
                System.out.println(i);
                if (first==i){
                    first++;
                }
                if (last==i){
                    last--;
                }
                if((arr[i]+arr[first]+arr[last])==sum){
                    count++;
                    first++;
                }
                if (arr[i] + arr[first] + arr[last] < sum) {
                    first++;
                }
                if (arr[i] + arr[first] + arr[last] > sum) { // A[i] + A[l] + A[r] > sum
                    last--;
                }
            }
        }
        System.out.println(count);
        return  count;
    }
}
