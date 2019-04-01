import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.*;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
        List <Integer> unused = new LinkedList<>();
        for (Integer lop: A){
            unused.add(lop);
        }
        permutations=permHelp(new LinkedList<>(),unused,permutations);
        return permutations;
    }

    public static List<List<Integer>> permHelp(List<Integer> current, List<Integer> unused, List<List<Integer>> permutations){
        if(unused.isEmpty()){
            permutations.add((LinkedList)((LinkedList)current).clone());
            return permutations;
        }
        for (Integer boi: unused) {
            current.add(boi);
            List<Integer> temp= (LinkedList) ((LinkedList)unused).clone();
            temp.remove(boi);
            permHelp(current, temp, permutations);
            current.remove(boi);
        }
        return permutations;
    }

}
