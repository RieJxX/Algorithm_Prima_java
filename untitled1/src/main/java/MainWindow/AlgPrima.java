package MainWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AlgPrima {
    private final Graph graph;
    private ArrayList<Edge> result_edges = new ArrayList<>();

    public AlgPrima(Graph graph_input){
        graph = graph_input;
        algorithmPrima();
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

    public void algorithmPrima(){
        ArrayList<Edge> edges = graph.getEdges();
        ArrayList<Vertice> vertices = graph.getVertices();


        PriorityQueue<Edge> queue_curr = new PriorityQueue<>(Comparator.comparingDouble(Edge::get_weight));
        for(Edge edge: edges){
            if (edge.get_weight()!= 0) queue_curr.add(edge);
        }
        while (free_vertices(vertices)){
            Edge curr_edge = queue_curr.peek();
            if (curr_edge.get_from().getLable()){
                if (!curr_edge.get_to().getLable()){
                    result_edges.add(curr_edge);
                    curr_edge.get_to().setLable();
                }
            }
            else if (curr_edge.get_to().getLable()){
                if(!curr_edge.get_from().getLable()){
                    result_edges.add(curr_edge);
                    curr_edge.get_from().setLable();
                }
            }
            else{
                result_edges.add(curr_edge);
                curr_edge.get_from().setLable();
                curr_edge.get_to().setLable();
            }
            queue_curr.remove(curr_edge);
        }

    }

    public void print_result(){
        for (Edge edge: result_edges){
            edge.print_edge();
        }
    }
}
