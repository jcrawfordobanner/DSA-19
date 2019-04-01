import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
        List<char[]> result = new ArrayList<>();
        List<Integer> unvisited = new LinkedList<>();
        for(int i = 1; i<=hoursInDay;i++){
            unvisited.add(i);
        }
        System.out.println(unvisited);
        return result;
    }

    public static List<char[]> permHelp(char[] current, List<Integer> unvisited, List<char[]> permutations){
        if(unvisited.isEmpty()){
            permutations.add(current);
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
