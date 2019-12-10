import java.util.ArrayList;
import java.util.LinkedList;

public class Wilson {

    public static int intiVertex(Graph g){
        int max = 0;
        for(int i = 1; i<g.order; i++){
            if(g.outNeighbours(max).size()<g.outNeighbours(i).size()) max = i;
        }
        return max;
    }

    public static int nonUsedVertex(boolean visit[]){
        for(int vertex = 0; vertex <visit.length; vertex++){
            if (!visit[vertex]){
                return vertex;
            }
        }
        return -1;
    }

    public static boolean visitAll(boolean[] visit){
        for(int i=0; i<visit.length;i++){
            if(!visit[i]) return false;
        }
        return true;
    }

    public static ArrayList<Arc> generateMinimumSpanningTree(Graph g){
        ArrayList<Arc> res = new ArrayList<>();
        boolean visit[] = new boolean[g.order];
        for(int i = 0;i<visit.length;i++){
            visit[i] =false;
        }
        int iv = intiVertex(g);
        int vertex = iv;
        visit[vertex] = true;
        LinkedList<Arc> neighbours = new LinkedList<>();
        do {
             neighbours= g.outNeighbours(vertex);
            if(!neighbours.isEmpty()){
                for(Arc a: neighbours){
                    if(!visit[a.getDest()]){
                        res.add(a);
                        visit[a.getDest()] = true;
                        iv = vertex;
                        vertex = a.getDest();
                    }
                }
            }
            if(vertex == iv){
                vertex = nonUsedVertex(visit);
                if(vertex==-1) return res;
            }
        }while(!visitAll(visit));
        return res;
    }
}
