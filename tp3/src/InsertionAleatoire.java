import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class InsertionAleatoire {
    public static ArrayList<Edge> generateMinimumSpanningTree(Graph g){
        ArrayList<Edge> Edges = new ArrayList<>();
        int count = g.order;
        for(LinkedList<Edge> list : g.getAdjacency()){
            if(list != null){
                for (Edge e : list){
                    if(!Edges.contains(e)) Edges.add(e);
                }
            }
        }

        ArrayList<Edge> MSTEdges = new ArrayList<Edge>();
        Collections.shuffle(Edges);
        DisjointSet set = new DisjointSet(count +1);

        for(int i=0; i<Edges.size() && MSTEdges.size()<(count-1);i++){
            Edge current = Edges.get(i);
            int r1 = set.find(current.getSource());
            int r2 = set.find(current.getDest());

            if(r1 != r2){
                MSTEdges.add(current);
                set.union(r1,r2);
            }
        }

        return MSTEdges;
    }
}
