package MainWindow;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private ArrayList<Vertice> vertices;
    private ArrayList<Edge> edges;

    public Graph(ArrayList<Vertice> vertices_input, ArrayList<Edge> edges_input){
        vertices = vertices_input;
        edges = edges_input;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Graph(FileInput fileInput){
        HashMap<Integer, ArrayList<Float>> matrix = fileInput.getMatrix();
        ArrayList<Vertice> vertices_input = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++){
            Vertice new_ver = new Vertice(i+1);
            vertices_input.add(new_ver);
        }
        vertices = vertices_input;

        ArrayList<Edge> edge_input = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++){
            int k = 0;
            for (Float num: matrix.get(i+1)){
                if (num != 0) {
                    Edge new_edge = new Edge(vertices_input.get(i), vertices_input.get(k), num, 1);
                    edge_input.add(new_edge);
                }
                k++;
            }
        }
        edges = edge_input;
    }

    public boolean edgeExists(Vertice v1, Vertice v2, ArrayList<Edge> edges){
        for (Edge edge : edges) {
            if ((edge.get_from().equals(v1) && edge.get_to().equals(v2)) ||
                    (edge.get_from().equals(v2) && edge.get_to().equals(v1))) {
                return true;
            }
        }
        return false;
    }
}
