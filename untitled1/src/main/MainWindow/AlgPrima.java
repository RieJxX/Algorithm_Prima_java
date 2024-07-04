package MainWindow;

import java.util.ArrayList;

public class AlgPrima {
    private final Graph graph;
    private ArrayList<Edge> result_edges;

    public AlgPrima(Graph graph_input){
        graph = graph_input;
    }

    public ArrayList<Edge> getResult_edges(){
        return result_edges;
    }

    private boolean free_vertices(ArrayList<Vertice> vertices){
        for (Vertice ver: vertices){
            if (!ver.getLable()){
                return true;
            }
        }
        return false;
    }
// еще не работает
    public void algorithmPrima(){
        ArrayList<Edge> edges = graph.getEdges();
        ArrayList<Vertice> vertices = graph.getVertices();

        while(free_vertices(vertices)){
            ArrayList<Edge> curr_edges = new ArrayList<>();
            for (Vertice ver: vertices){
                if (ver.getLable()){
                    for (Edge edge: edges){
                        if (edge.get_from() == ver && !edge.get_to().getLable()){
                            curr_edges.add(edge);
                        }
                    }
                }
            }

            //curr_edges.sort();
            Edge min = curr_edges.get(0);
            min.get_to().setLable();
            result_edges.add(min);
        }

    }

}
