import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Kruskal {

    public static ArrayList<Edge> generateMinimumSpanningTree(Graph g){
        ArrayList<Edge> graphEdges = new ArrayList<>();
        int count = g.order;
        for(LinkedList<Edge> list : g.getAdjacency()){
            if(list != null)
                for(Edge e : list){
                    if(!graphEdges.contains(e)) graphEdges.add(e);
                }
        }
        Collections.sort(graphEdges);
        ArrayList<Edge> mstEdges = new ArrayList<Edge>();
        DisjointSet set = new DisjointSet(count+1);

        for (int i = 0; i < graphEdges.size() && mstEdges.size() < (count - 1); i++) {

            Edge currentEdge = graphEdges.get(i);
            int root1 = set.find(currentEdge.getSource());
            int root2 = set.find(currentEdge.getDest());

            if (root1 != root2) {

                mstEdges.add(currentEdge);
                set.union(root1, root2);

            }

        }

        return mstEdges;
    }

}
