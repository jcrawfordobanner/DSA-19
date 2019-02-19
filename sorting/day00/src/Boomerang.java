import java.util.HashMap;
import java.util.Iterator;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        // TODO
        int rangs = 0;
        int killa=0;
        HashMap<Double, Integer> jack = new HashMap();
        System.out.println(points.length);
        for(int i = 0; i<points.length;i++){
            int[]  center= points[i];
            for (int j = 0; j<points.length; j++){
                double dist = (Math.pow((center[0]-points[j][0]),2) + Math.pow(center[1]-points[j][1],2));
                if (jack.containsKey(dist)){
                    jack.put(dist,jack.get(dist)+1);
                }
                else {
                    jack.put(dist, 1);
                }
            }
            System.out.println(jack);
            Iterator sad = jack.entrySet().iterator();
//            while(sad.hasNext()){
//                HashMap.Entry  lok = (HashMap.Entry)sad.next();
//                int res  =(int) lok.getValue();
//                int lers = (int) lok.getKey();
//                if (res>1) {
//                    rangs = (res * (res - 1));
//                }
//                System.out.println(rangs);
//                sad.remove();
//            }
            for (Integer k: jack.values()){
                  rangs+=k*(k-1);
             }


            jack.clear();
        }
        return rangs;
    }
}

