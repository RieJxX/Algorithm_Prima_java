package MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class mainWind {
    public static void main(String[] args) {

        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<GraphNodePanel> nodes = new ArrayList<GraphNodePanel>();
        ArrayList<GraphEdgePanel> graph_edges = new ArrayList<GraphEdgePanel>();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Algorithm Prima");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Запуск в полноэкранном режиме
        frame.setSize(screenSize);
        frame.setLayout(null);
        frame.setResizable(false);

        Color Edge_color = Color.LIGHT_GRAY;
        float Edge_thikness = 5 ;
        float default_weight = 0;

        CustomJPanel graphPanel = new MainWindow.CustomJPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (GraphEdgePanel edge : graph_edges) {
                    edge.paintComponent(g);
                }
            }
        };
        graphPanel.setSize(1000 , 500);
        graphPanel.setLocation(200 , 200);
        graphPanel.setLayout(null);
//        graphPanel.setPanelColor(null);
        graphPanel.setOpaque(false);

        graphPanel.setGraph(new Graph(new FileInput("C:\\Users\\USER1\\IdeaProjects\\untitled1\\src\\main\\resources\\Graph.txt"))); // Установка графа
        graphPanel.create(); // Создание узлов и рёбер на панели

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphPanel.repaint(); // Перерисовываем панель
            }
        });

        CustomJPanel customPanel = new CustomJPanel();
        customPanel.setPanelLocation( frame.getWidth()*15/100, 0);
        customPanel.setPanelSize(frame.getWidth()*70/100, frame.getHeight()*15/100);
        customPanel.setPanelColor(Color.GRAY);
        customPanel.setCornerRadii(0, 0, 40, 40);

        CustomJPanel customPanel2 = new CustomJPanel();
        customPanel2.setPanelLocation(frame.getWidth()*15/100, frame.getHeight()*85/100);
        customPanel2.setPanelSize(frame.getWidth()*70/100, frame.getHeight()*15/100);
        customPanel2.setPanelColor(Color.GRAY);
        customPanel2.setCornerRadii(40, 40, 0, 0);

        CustomJPanel customPanel3 = new CustomJPanel();
        customPanel3.setPanelLocation(frame.getWidth()*92/100, frame.getHeight()*15/100);
        customPanel3.setPanelSize(frame.getWidth()*8/100, frame.getHeight()*70/100);
        customPanel3.setPanelColor(Color.GRAY);
        customPanel3.setCornerRadii(40, 0, 40, 0);


        MainWindow.CustomJButton customButton1_2 = new MainWindow.CustomJButton("");
        customButton1_2.setButtonSize(100 , 100);
        customButton1_2.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton1_2.setCornerRadii(20,20,0,0);
        customButton1_2.setButtonLocation((customPanel2.getWidth() - customButton1_2.getWidth()) / 5, (customPanel2.getHeight() - customButton1_2.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon1_2 = new ImageIcon("src/main/resources/Polygon 16.png");
        customButton1_2.setButtonIcon(icon1_2);

        customButton1_2.addActionListener(e ->{
            if(graphPanel.getGraph() != null) {
                AlgPrima prima = new AlgPrima(graphPanel.getGraph());
                ArrayList<Edge> res_edges = prima.getResult_edges();
                prima.print_result();
                for(Edge edge : res_edges){
                    int from = edge.get_from().get_name();
                    int to = edge.get_to().get_name();
                    GraphNodePanel first = new GraphNodePanel("");
                    GraphNodePanel second = new GraphNodePanel("");
                    for(GraphNodePanel node : nodes){
                        if(node.getLabel().equals(String.valueOf(from))){
                            first = node;
                        }
                        if(node.getLabel().equals(String.valueOf(to))){
                            second = node;
                        }
                    }
                    for(GraphEdgePanel graph_edge : graph_edges){
                        if(graph_edge.getStartNode() == first && graph_edge.getEndNode() == second){
                            graph_edge.setColor(Color.green);
                        }
                        else if(graph_edge.getStartNode() == second && graph_edge.getEndNode() == first){
                            graph_edge.setColor(Color.green);
                        }
                    }
                }
            }
        });

        MainWindow.CustomJButton customButton2_2 = new MainWindow.CustomJButton("");
        customButton2_2.setButtonSize(100 , 100);
        customButton2_2.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton2_2.setCornerRadii(20,20,0,0);
        customButton2_2.setButtonLocation((customPanel2.getWidth() - customButton2_2.getWidth()) * 2 / 5, (customPanel2.getHeight() - customButton2_2.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon2_2 = new ImageIcon("src/main/resources/Icon.png");
        customButton2_2.setButtonIcon(icon2_2);

        MainWindow.CustomJButton customButton3_2 = new MainWindow.CustomJButton("");
        customButton3_2.setButtonSize(100 , 100);
        customButton3_2.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton3_2.setCornerRadii(20,20,0,0);
        customButton3_2.setButtonLocation((customPanel2.getWidth() - customButton3_2.getWidth())* 3 / 5, (customPanel2.getHeight() - customButton3_2.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon3_2 = new ImageIcon("src/main/resources/Icon (1).png");
        customButton3_2.setButtonIcon(icon3_2);

        MainWindow.CustomJButton customButton4_2 = new MainWindow.CustomJButton("");
        customButton4_2.setButtonSize(100 , 100);
        customButton4_2.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton4_2.setCornerRadii(20,20,0,0);
        customButton4_2.setButtonLocation((customPanel2.getWidth() - customButton4_2.getWidth())* 4 / 5, (customPanel2.getHeight() - customButton4_2.getHeight()) / 2);
        // Установка иконки на кнопку
        ImageIcon icon4_2 = new ImageIcon("src/main/resources/Icon (2).png");
        customButton4_2.setButtonIcon(icon4_2);

        MainWindow.CustomJButton customButton1_1 = new MainWindow.CustomJButton("");
        customButton1_1.setButtonSize(100 , 100);
        customButton1_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton1_1.setCornerRadii(20,20,20,20);
        customButton1_1.setButtonLocation((customPanel.getWidth() - customButton1_1.getWidth()) / 5, (customPanel.getHeight() - customButton1_1.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon1_1 = new ImageIcon("src/main/resources/Icon (3).png");
        customButton1_1.setButtonIcon(icon1_1);

        MainWindow.CustomJButton customButton2_1 = new MainWindow.CustomJButton("");
        customButton2_1.setButtonSize(100 , 100);
        customButton2_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton2_1.setCornerRadii(20,20,20,20);
        customButton2_1.setButtonLocation((customPanel.getWidth() - customButton2_1.getWidth()) * 2 / 5, (customPanel.getHeight() - customButton2_1.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon2_1 = new ImageIcon("src/main/resources/Edit 10.png");
        customButton2_1.setButtonIcon(icon2_1);
        ArrayList<Integer> kkk = new ArrayList<Integer>();
        kkk.add(1);
        customButton1_1.addActionListener(e -> {
            Vertice vertice = new Vertice(kkk.get(kkk.size()-1));
            kkk.add(kkk.get(kkk.size()-1)+1);
            GraphNodePanel newNode = new GraphNodePanel(String.format("%d" , vertice.get_name()));
            newNode.setVertice(vertice);
            newNode.setBounds(650, 50, 70, 70); // Устанавливаем положение и размеры нового узла
            vertices.add(vertice);
            nodes.add(newNode);
            graphPanel.add(newNode);
            graphPanel.revalidate();
            graphPanel.repaint();
        });
        customButton2_1.addActionListener(e ->{
            if(GraphNodePanel.get_selectedNodes().size() == 2) {

                Vertice vertice1 = GraphNodePanel.get_selectedNodes().get(0).getVertice();
                Vertice vertice2 = GraphNodePanel.get_selectedNodes().get(1).getVertice();

                if(!graphPanel.getGraph().edgeExists(vertice1, vertice2, edges)){
                    Edge edge = new Edge(vertice1, vertice2, default_weight, 1);
                    GraphEdgePanel newedge = new MainWindow.GraphEdgePanel(GraphNodePanel.get_selectedNodes().get(0), GraphNodePanel.get_selectedNodes().get(1), Edge_thikness, Edge_color, default_weight);
                    edges.add(edge);
                    graph_edges.add(newedge);
                    GraphNodePanel.get_selectedNodes().get(0).addEdge(newedge);
                    GraphNodePanel.get_selectedNodes().get(1).addEdge(newedge);
                    graphPanel.add(newedge);
                    graphPanel.repaint();
                    System.out.println("Edge button is clicked! There are 2 selected vertices");
                } else{
                    System.out.println("Edge already exists between the selected vertices.");
                }

            }
        });



        MainWindow.CustomJButton customButton3_1 = new MainWindow.CustomJButton("");
        customButton3_1.setButtonSize(100 , 100);
        customButton3_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton3_1.setCornerRadii(20,20,20,20);
        customButton3_1.setButtonLocation((customPanel.getWidth() - customButton3_2.getWidth())* 3 / 5, (customPanel.getHeight() - customButton3_2.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon3_1 = new ImageIcon("src/main/resources/Edit 11.png");
        customButton3_1.setButtonIcon(icon3_1);
        customButton3_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GraphEdgePanel.getSelectedEdge() != null) {
                    if (GraphEdgePanel.getSelectedEdge().isSelected()) {
                        String weightStr = JOptionPane.showInputDialog("Enter new weight:");
                        try {
                            float newWeight = Float.parseFloat(weightStr);
                            GraphEdgePanel.getSelectedEdge().setWeight(newWeight);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid weight value.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        MainWindow.DeleteModeButton customButton4_1 = new MainWindow.DeleteModeButton("");
        customButton4_1.setButtonSize(100 , 100);
        customButton4_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton4_1.setCornerRadii(20,20,20,20);
        customButton4_1.setButtonLocation((customPanel.getWidth() - customButton4_2.getWidth())* 4 / 5, (customPanel.getHeight() - customButton4_2.getHeight()) / 2);
        // Установка иконки на кнопку
        ImageIcon icon4_1 = new ImageIcon("src/main/resources/Delete.png");
        customButton4_1.setButtonIcon(icon4_1);

        customButton4_1.addActionListener(e -> {
            customButton4_1.setRemoveMode(!customButton4_1.getRemoveMode());
            customButton4_1.setBackgroundRemoveMode();
            if (customButton4_1.getRemoveMode()) {
                customButton4_1.enableComponentRemoval(graphPanel , graph_edges , nodes);
                customButton1_1.setEnabled(false);
                customButton2_1.setEnabled(false);
                customButton3_1.setEnabled(false);
            } else {
                customButton4_1.disableComponentRemoval(graphPanel);
                customButton1_1.setEnabled(true);
                customButton2_1.setEnabled(true);
                customButton3_1.setEnabled(true);
            }
        });

        MainWindow.CustomJButton customButton1_3 = new MainWindow.CustomJButton("");
        customButton1_3.setButtonSize(100 ,  100);
        customButton1_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton1_3.setCornerRadii(20,20,20,20);
        customButton1_3.setButtonLocation((customPanel3.getWidth() - customButton1_3.getWidth()) / 2, (customPanel3.getHeight() - customButton1_1.getHeight()) * 1 / 11);
        // Установка иконки на кнопку
        Icon icon1_3 = new ImageIcon("src/main/resources/Icon (4).png");
        customButton1_3.setButtonIcon(icon1_3);
        customButton1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphPanel.removeAll();
                edges.clear();
                graph_edges.clear();
                GraphNodePanel.remove_selectedNodes();
                //graphPanel.revalidate();
                graphPanel.repaint();
                graphPanel.setGraph(new Graph(new FileInput("")));
                kkk.clear();
                kkk.add(1);

            }
        });

        MainWindow.CustomJButton customButton2_3 = new MainWindow.CustomJButton("");
        customButton2_3.setButtonSize(100 ,  100);
        customButton2_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton2_3.setCornerRadii(20,20,20,20);
        customButton2_3.setButtonLocation((customPanel3.getWidth() - customButton2_3.getWidth()) / 2, (customPanel3.getHeight() - customButton2_3.getHeight()) * 4 / 11);
        // Установка иконки на кнопку
        Icon icon2_3 = new ImageIcon("src/main/resources/Info.png");
        customButton2_3.setButtonIcon(icon2_3);

        MainWindow.CustomJButton customButton3_3 = new MainWindow.CustomJButton("");
        customButton3_3.setButtonSize(100 ,  100);
        customButton3_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton3_3.setCornerRadii(20,20,20,20);
        customButton3_3.setButtonLocation((customPanel3.getWidth() - customButton3_3.getWidth()) / 2, (customPanel3.getHeight() - customButton3_3.getHeight()) * 7 / 11);
        // Установка иконки на кнопку
        Icon icon3_3 = new ImageIcon("src/main/resources/Icon (5).png");
        customButton3_3.setButtonIcon(icon3_3);

        MainWindow.CustomJButton customButton4_3 = new MainWindow.CustomJButton("");
        customButton4_3.setButtonSize(100 ,  100);
        customButton4_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton4_3.setCornerRadii(20,20,20,20);
        customButton4_3.setButtonLocation((customPanel3.getWidth() - customButton4_3.getWidth()) / 2, (customPanel3.getHeight() - customButton4_3.getHeight()) * 10 / 11);
        // Установка иконки на кнопку
        Icon icon4_3 = new ImageIcon("src/main/resources/Upload.png");
        customButton4_3.setButtonIcon(icon4_3);
        customButton4_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int option = fileChooser.showOpenDialog(customButton3_3);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    FileInput fileInput = new FileInput(selectedFile.getAbsolutePath());
                    Graph graph = new Graph(fileInput);
                    if(fileInput != null){
                        graphPanel.removeAll();
                        edges.clear();
                        graph_edges.clear();
                        graphPanel.setGraph(graph);
                        ArrayList<Edge> edges_file = graph.getEdges();
                        ArrayList<Vertice> vertices = graph.getVertices();
                        ArrayList<MainWindow.GraphNodePanel> nodes1 = new ArrayList<>();

                        int vertexCount = vertices.size();
                        int radius = graphPanel.getHeight() / 3; // Радиус многоугольника
                        int centerX = graphPanel.getWidth() / 2;
                        int centerY = graphPanel.getHeight() / 2;

                        // Создание и добавление панелей узлов на панель CustomJPanel
                        for (int i = 0; i < vertexCount; i++) {
                            double angle = 2 * Math.PI * i / vertexCount;
                            int x = (int) (centerX + radius * Math.cos(angle));
                            int y = (int) (centerY + radius * Math.sin(angle));

                            GraphNodePanel nodePanel = new GraphNodePanel(String.valueOf(i + 1));
                            nodePanel.setVertice(vertices.get(i));
                            nodePanel.setBounds(x - 25, y - 25, 70, 70);
                            nodes1.add(nodePanel);
                            nodes.add(nodePanel);
                            graphPanel.add(nodePanel);
                        }

                        // Создание и добавление панелей рёбер на панель CustomJPanel
                        for (Edge edge : edges_file) {

                            ArrayList<MainWindow.GraphNodePanel> el_primo = new ArrayList<>();
                            for (MainWindow.GraphNodePanel node: nodes1){

                                //System.out.println("for1");
                                if(String.valueOf(edge.get_from().get_name()).equals(node.getLabel())){
                                    el_primo.add(node);
                                    //System.out.println("if1");
                                }
                                if(String.valueOf(edge.get_to().get_name()).equals(node.getLabel())){
                                    el_primo.add(node);
                                    //System.out.println("if2");
                                }

                            }
                            if(String.valueOf(edge.get_to().get_name()).equals(el_primo.getFirst().getLabel())){
                                //MainWindow.GraphEdgePanel
                                GraphEdgePanel edgePanel = new GraphEdgePanel(el_primo.get(1), el_primo.getFirst(), 5, Color.LIGHT_GRAY, edge.get_weight());
                                el_primo.get(1).addEdge(edgePanel);
                                el_primo.getFirst().addEdge(edgePanel);
                                graphPanel.add(edgePanel);
                                edges.add(edge);
                                graph_edges.add(edgePanel);
                                graphPanel.revalidate(); // Перепроверка компонентов
                                graphPanel.repaint();
                            }
                            else {
                                GraphEdgePanel edgePanel = new GraphEdgePanel(el_primo.getFirst(), el_primo.get(0), 10, Color.GRAY, edge.get_weight());
                                el_primo.getFirst().addEdge(edgePanel);
                                el_primo.get(1).addEdge(edgePanel);
                                graph_edges.add(edgePanel);
                                edges.add(edge);
                                graphPanel.add(edgePanel);
                                graphPanel.revalidate(); // Перепроверка компонентов
                                graphPanel.repaint();
                            }
                        }
                    }


                }
            }
        });


        customPanel.setLayout(null);
        customPanel2.setLayout(null);
        customPanel3.setLayout(null);
        frame.add(customPanel);
        customPanel.add(customButton1_1);
        customPanel.add(customButton2_1);
        customPanel.add(customButton3_1);
        customPanel.add(customButton4_1);
        frame.add(customPanel2);
        customPanel2.add(customButton1_2);
        customPanel2.add(customButton2_2);
        customPanel2.add(customButton3_2);
        customPanel2.add(customButton4_2);
        frame.add(customPanel3);
        customPanel3.add(customButton1_3);
        customPanel3.add(customButton2_3);
        customPanel3.add(customButton3_3);
        customPanel3.add(customButton4_3);

        frame.add(graphPanel);
        frame.setVisible(true);

        timer.start();
    }
}
