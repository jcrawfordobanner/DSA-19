import java.util.*;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        HashMap <String,Integer> haters = new HashMap();
        HashMap <Integer, ArrayList<String>> killem = new HashMap();
        String [] dembois = s.split(" ");
        String ret = "";
        for(int i = 0; i<dembois.length;i++){
            if(!haters.containsKey(dembois[i])){
                haters.put(dembois[i],1);
            }
            else{
                haters.put(dembois[i],haters.get(dembois[i])+1);
            }
        }
        for(Map.Entry<String, Integer> entry : haters.entrySet()) {
            if(!killem.containsKey(entry.getValue())){
                ArrayList<String> kill = new ArrayList<>();
                kill.add(entry.getKey());
                killem.put(entry.getValue(),kill);
            }
            else{
                ArrayList<String> nok = killem.get(entry.getValue());
                nok.add(entry.getKey());
                killem.put(entry.getValue(),nok);
            }
        }
        for(int i =0; i<dembois.length;i++){
            if(killem.containsKey(i)){
                for(int k = 0; k<killem.get(i).size();k++){
                    for(int j=0;j<i;j++){
                        ret+= killem.get(i).get(k)+" ";
                    }
                }
            }
        }
        System.out.println(ret);
        return ret;
    }

}
