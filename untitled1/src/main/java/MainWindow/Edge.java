package MainWindow;

public class Edge {

    private final Vertice from;
    private final Vertice to;
    private final float weight;
    private final int color;

    public Edge(Vertice from_input, Vertice to_input, float weight_input, int color_input){
        from = from_input;
        to = to_input;
        weight = weight_input;
        color = color_input;
    }

    public Vertice get_from(){
        return from;
    }

    public Vertice get_to(){
        return to;
    }
    public float get_weight(){
        return weight;
    }

//    public int get_color(){
//        return color;
//    }

    public void print_edge(){
        System.out.format("Egde: weight = %f from = %d to = %d\n", weight, from.get_name(), to.get_name());
    }

}
