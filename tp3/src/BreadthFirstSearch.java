

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class BreadthFirstSearch {
    Graph g;

    public static ArrayList<Arc> generateTree(Graph graph) {
        ArrayList<Arc> res = new ArrayList<Arc>();
        Random r = new Random();
        int s = 0 + r.nextInt(graph.order - 0);
        LinkedList<Integer> file = new LinkedList<Integer>();
        boolean[] marque = new boolean[graph.order];

        for (int index = 0; index < graph.order; index++)
            marque[index] = false;

        while (true) {
            file.addFirst(s);
            marque[s] = true;
            while (!file.isEmpty()) {
                Collections.shuffle(file);
                s = file.removeLast();
                if (graph.getOutAdjacency().get(s) != null)
                    for (Arc arcSource : graph.outNeighbours(s)) {
                        if (!marque[arcSource.getDest()]) {
                            file.addFirst(arcSource.getDest());
                            marque[arcSource.getDest()] = true;
                            res.add(arcSource);
                        }
                    }
            }

            s = unvisitedVertexes(marque);
            if (s == -1)
                break;
        }

        return res;
    }


    public static ArrayList<Arc> generateTree(Graph graph, int i) {
        ArrayList<Arc> res = new ArrayList<Arc>();

        LinkedList<Integer> file = new LinkedList<Integer>();
        boolean[] marque = new boolean[graph.order];

        for (int index = 0; index < graph.order; index++)
            marque[index] = false;

        while (true) {
            file.addFirst(i);
            marque[i] = true;
            while (!file.isEmpty()) {

                i = file.removeLast();
                if (graph.outNeighbours(i) != null)
                    for (Arc arcSource : graph.outNeighbours(i)) {
                        if (!marque[arcSource.getDest()]) {
                            file.addFirst(arcSource.getDest());
                            marque[arcSource.getDest()] = true;
                            res.add(arcSource);
                        }
                    }
            }

            i = unvisitedVertexes(marque);
            if (i == -1)
                break;
        }

        return res;

    }


    private static int unvisitedVertexes(boolean[] tab) {
        for (int i = 0; i < tab.length; i++)
            if (!tab[i])
                return i;
        return -1;

    }

}
