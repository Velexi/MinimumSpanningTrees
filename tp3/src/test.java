import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        Graph graphArc = new Graph(8);

        graphArc.addEdge(new Edge(0, 4, 0));
        graphArc.addEdge(new Edge(0, 1, 1));
        graphArc.addEdge(new Edge(1, 4, 0));
        graphArc.addEdge(new Edge(1, 5, 0));
        graphArc.addEdge(new Edge(1, 6, 0));
        graphArc.addEdge(new Edge(1, 3, 1));
        graphArc.addEdge(new Edge(5, 6, 1));
        graphArc.addEdge(new Edge(4, 2, 0));
        graphArc.addEdge(new Edge(4, 7, 1));
        graphArc.addEdge(new Edge(3, 7, 0));
        graphArc.addEdge(new Edge(3, 2, 0));

        ArrayList<Edge> insertionTest = new ArrayList<Edge>();
        ArrayList<Arc> wilsonTest = new ArrayList<Arc>();
        ArrayList<Edge> Kruskaltest = new ArrayList<Edge>();
        ArrayList<Arc> bfsTest = new ArrayList<Arc>();
        ArrayList<Arc> bfsAleatoireTest = new ArrayList<Arc>();


        long debut = System.currentTimeMillis();
        wilsonTest = Wilson.generateMinimumSpanningTree(graphArc);
        System.out.println("Wilson");
        for (int i=0; i<wilsonTest.size(); i++){
            System.out.println(wilsonTest.get(i).getSource()+"---"+wilsonTest.get(i).getDest());
        }
        System.out.println("temps d'execution wilson :"+(System.currentTimeMillis() - debut)+" ms");

        System.out.println("------------------------");

        debut = System.currentTimeMillis();
        Kruskaltest = Kruskal.generateMinimumSpanningTree(graphArc);
        System.out.println("algorithme de kruskal ");
        for (int i = 0; i < Kruskaltest.size(); i++)
            System.out.println(Kruskaltest.get(i).getSource() + "---" + Kruskaltest.get(i).getDest());
        System.out.println("temps execution Kruskal: " + (System.currentTimeMillis() - debut) +" ms");

        System.out.println("------------------------");

        debut = System.currentTimeMillis();
        bfsTest = BreadthFirstSearch.generateTree(graphArc, 0);
        System.out.println("parcours en largeur ");
        for (int i = 0; i < bfsTest.size(); i++)
            System.out.println(bfsTest.get(i).getSource() + "---" + bfsTest.get(i).getDest());
        System.out.println("temps execution de parcours en largeur: " + (System.currentTimeMillis() - debut) + " ms");

        System.out.println("------------------------");

        debut = System.currentTimeMillis();
        bfsAleatoireTest = BreadthFirstSearch.generateTree(graphArc);
        System.out.println("parcours en largeur aleatoire");
        for (int i = 0; i < bfsAleatoireTest.size(); i++) {
            System.out.println(bfsAleatoireTest.get(i).getSource() + "---" + bfsAleatoireTest.get(i).getDest());
        }
        System.out.println("temps execution de parcours en largeur aleatoire: " + (System.currentTimeMillis() - debut)+" ms");

        System.out.println("------------------------");

        debut = System.currentTimeMillis();
        insertionTest = InsertionAleatoire.generateMinimumSpanningTree(graphArc);
        System.out.println("Insertion aleatoire");
        for(int i = 0; i<insertionTest.size();i++){
            System.out.println(insertionTest.get(i).getSource() + "---" + insertionTest.get(i).getDest());
        }
        System.out.println("temps d'execution de la generation d'un arbre couvrant par insertionTest aleatoire: "+(System.currentTimeMillis()-debut)+" ms");

    }
}
