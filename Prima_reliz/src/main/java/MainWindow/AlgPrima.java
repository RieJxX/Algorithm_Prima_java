package MainWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AlgPrima {
    private final Graph graph;
    private ArrayList<Edge> result_edges = new ArrayList<>();
    private boolean check;

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

//    public void algorithmPrima(){
//        ArrayList<Edge> edges = graph.getEdges();
//        System.out.println("Start");
//        for (Edge edge: edges){
//            edge.print_edge();
//        }
//        ArrayList<Vertice> vertices = graph.getVertices();
//        HashSet<Vertice> unique = new HashSet<>();
//        PriorityQueue<Edge> queue_curr = new PriorityQueue<>(Comparator.comparingDouble(Edge::get_weight));
//        for(Edge edge: edges){
//            if (edge.get_weight()!= 0) {
//                queue_curr.add(edge);
//                unique.add(edge.get_from());
//                unique.add(edge.get_to());
//            }
//        }
//        System.out.println("Uni");
//        for (Vertice ver: unique){
//            System.out.println(ver.get_name());
//        }
//        System.out.format("Unique %d, vertice %d\n", unique.size(), vertices.size());
//        if (unique.size() == vertices.size() && !edges.isEmpty()){
//            check = true;
//        }
//        else check = false;
//        System.out.println("Alg");
//        result_edges.clear();
//        if (check){
//            Edge curr_edge = queue_curr.peek();
//            result_edges.add(curr_edge);
//            curr_edge.get_from().setLable();
//            curr_edge.get_to().setLable();
//            queue_curr.remove(curr_edge);
//            curr_edge.print_edge();
//            while (free_vertices(vertices)){
//                curr_edge = queue_curr.peek();
//                System.out.print("curr edge ");
//                curr_edge.print_edge();
//                if (curr_edge.get_from().getLable()){
//                    if (!curr_edge.get_to().getLable()){
//                        result_edges.add(curr_edge);
//                        curr_edge.get_to().setLable();
//                        //curr_edge.print_edge();
//                        result_edges.getLast().print_edge();
//                    }
//                }
//                else if (curr_edge.get_to().getLable()){
//                    if(!curr_edge.get_from().getLable()){
//                        result_edges.add(curr_edge);
//                        curr_edge.get_from().setLable();
//                        //curr_edge.print_edge();
//                        result_edges.getLast().print_edge();
//                    }
//                }
//                queue_curr.remove(curr_edge);
//            }
//        }
//
//        for (Vertice ver: vertices){
//            ver.setFalse();
//        }
//    }
    private Edge find_min(ArrayList<Edge> edges){
        Edge min_edge = new Edge(null,null,100000,1);
        for (Edge edge: edges){
            if (edge.get_weight() < min_edge.get_weight()){
                min_edge = edge;
            }
        }
        return min_edge;
    }
    public void algorithmPrima(){
        ArrayList<Edge> edges = graph.getEdges();
        ArrayList<Vertice> vertices = graph.getVertices();

        HashSet<Vertice> unique = new HashSet<>();
        for(Edge edge: edges){
            if (edge.get_weight()!= 0) {
                unique.add(edge.get_from());
                unique.add(edge.get_to());
            }
        }
        System.out.println("Uni");
        for (Vertice ver: unique){
            System.out.println(ver.get_name());
        }
        System.out.format("Unique %d, vertice %d\n", unique.size(), vertices.size());
        if (unique.size() == vertices.size() && !edges.isEmpty()){
            check = true;
        }
        else check = false;
        if(check) {
            //PriorityQueue<Edge> queue_curr = new PriorityQueue<>(Comparator.comparingDouble(Edge::get_weight));
            ArrayList<Edge> curr_edges = new ArrayList<>();
            ArrayList<Vertice> curr_vertice = new ArrayList<>();
            curr_edges.addAll(edges);
            Edge curr = find_min(curr_edges);
            result_edges.add(curr);
            curr.get_from().setLable();
            curr_vertice.add(curr.get_from());
            curr.get_to().setLable();
            curr_vertice.add(curr.get_to());
            curr_edges.clear();
            result_edges.getLast().print_edge();
            while (free_vertices(vertices)) {
                for (Vertice vertice : curr_vertice) {
                    for (Edge edge : edges) {
                        if ((edge.get_from().equals(vertice) && !edge.get_to().getLable()) || (edge.get_to().equals(vertice) && !edge.get_from().getLable())) {
                            curr_edges.add(edge);
                        }
                    }
                }
                Edge new_edge = find_min(curr_edges);
                curr_edges.clear();
                if (new_edge.get_from().getLable()) {
                    new_edge.get_to().setLable();
                    curr_vertice.add(new_edge.get_to());
                } else {
                    new_edge.get_from().setLable();
                    curr_vertice.add(new_edge.get_from());
                }
                result_edges.add(new_edge);
                result_edges.getLast().print_edge();
            }
            for (Vertice ver : vertices) {
                ver.setFalse();
            }
        }
    }

    public boolean getCheck(){
        return check;
    }

    public void print_result(){
        for (Edge edge: result_edges){
            edge.print_edge();
        }
    }
}
