import java.util.*;

import static java.util.Collections.sort;

public class Problems {
    public static BinarySearchTree<Integer>  median(BinarySearchTree<Integer> stff, List<Integer> values,int start, int end) {
        if(start==end){
            return stff;
        }
        List<Integer> temp = values.subList(start,end);
        int med = temp.size()/2;
        if(med==0){
            stff.add(temp.get(0));
            return stff;
        }
        System.out.println("med: " + med);
        stff.add(temp.get(med));
        median(stff,temp,0,med);
        median(stff,temp,med,temp.size());
        return  stff;
    }

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        BinarySearchTree<Integer> boi = new BinarySearchTree();
        sort(values);
        median(boi,values,0,values.size());
        // TODO
        return boi;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
