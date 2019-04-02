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
        int coins=pennies+nickels+dimes;
        result = permHelp(new char[coins], unvisited,result,pennies,nickels,dimes,hoursInDay,hoursInDay);
        System.out.println(result);
        return result;
    }

    public static List<char[]> permHelp(char[] current, List<Integer> unvisited, List<char[]> permutations,int p, int n, int d,int time,int max){
        if(unvisited.size()==1){
            if(p>0){
                current[time]='p';
                p-=1;
            }
            else if(n>0){
                current[time]='n';
                n-=1;
            }
            else if(d>0){
                current[time]='d';
                d-=1;
            }
            permutations.add(current);
            return permutations;
        }
        int future1 = time+1;
        int future5 = time+5;
        int future10= time+10;
        if(future1>max){
            future1=future1%max;
        }
        if(future5>max){
            future5=future5%max;
        }
        if(future10>max){
            future10=future10%max;
        }
        if((unvisited.contains(future1))&&p>0){
            List<Integer> temp= (LinkedList) ((LinkedList)unvisited).clone();
            temp.remove(temp.indexOf(time));
            if(time<max) {
                current[time] = 'p';
            }
            else{
                current[0]='p';
            }
            permHelp(current.clone(),temp,permutations,p-1,n,d,future1,max);
        }
        if((unvisited.contains(future5))&&n>0){
            List<Integer> temp= (LinkedList) ((LinkedList)unvisited).clone();
            temp.remove(temp.indexOf(time));
            if(time<max) {
                current[time] = 'n';
            }
            else{
                current[0]='n';
            }
            permHelp(current.clone(),temp,permutations,p,n-1,d,future5,max);
        }
        if((unvisited.contains(future10))&&d>0){
            List<Integer> temp= (LinkedList) ((LinkedList)unvisited).clone();
            temp.remove(temp.indexOf(time));
            if(time<max) {
                current[time] = 'd';
            }
            else{
                current[0]='d';
            }
            permHelp(current.clone(),temp,permutations,p,n,d-1,future10,max);
        }
        return permutations;
    }
}
