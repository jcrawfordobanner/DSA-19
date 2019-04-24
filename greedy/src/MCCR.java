import javax.xml.stream.events.EndDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MCCR {
        public static int MCCR(EdgeWeightedGraph G) {
            // TODO
            int cost=0;
            List<Integer> connect = new ArrayList<>();
            List<Edge> visited = new ArrayList<>();

            List<Integer> yettie = new ArrayList<>();
            for(int j=0; j<G.numberOfV();j++){
                yettie.add(j);
            }
            IndexPQ<Edge> sad= new IndexPQ<>(200);
            for (int i = 0; i < G.numberOfV(); i++) {
                PriorityQueue<Edge> lake = new PriorityQueue<>();
                for (Edge x : G.edges(i)) {
                    if (yettie.contains(i) && connect.contains(i) && !yettie.contains(x.other(i))) {
                        continue;
                    }
                    if ((yettie.contains(i) || !connect.contains(x.other(i))) && !visited.contains(x)) {
                        lake.add(x);
                    }
                }
                if (lake.size() > 0) {
                    Edge correct = lake.poll();
                    visited.add(correct);
                    cost += correct.weight();
                    connect.add(correct.other(i));
                    yettie.remove(yettie.indexOf(i));
                }
            }
            System.out.println("rest");
            if(yettie.size()>1){
                PriorityQueue<Edge> lake = new PriorityQueue<>();
                for(int v: yettie){
                    for(Edge e: G.edges(v)){
                        if(visited.contains(e)){
                            int k = e.other(v);
                            if(!connect.contains(k)) {
                                for (Edge dab : G.edges(k)) {
                                    if(!visited.contains(dab)) {
                                        lake.add(dab);
                                    }
                                }
                                if (lake.size() > 0) {
                                    Edge correct = lake.poll();
                                    visited.add(correct);
                                    cost += correct.weight();
                                    connect.add(correct.other(k));
                                }
                            }
                        }
                    }
                }
            }
            return cost;
        }

    }

