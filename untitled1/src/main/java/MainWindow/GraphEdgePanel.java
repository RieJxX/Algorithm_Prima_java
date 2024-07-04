package MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphEdgePanel extends JPanel {
    private GraphNodePanel startNode;
    private GraphNodePanel endNode;
    private float thickness;
    private Color color;
    private float weight;
    private String weightLabel;
    private boolean isSelected;
    private static GraphEdgePanel selectedEdge;

    public GraphEdgePanel(GraphNodePanel startNode, GraphNodePanel endNode, float thickness, Color color, float weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.thickness = thickness;
        this.color = color;
        this.isSelected = false;
        setWeight(weight);
        setOpaque(false);
        setPreferredSize(new Dimension(10, 10));

        // Устанавливаем начальные размеры
        // Добавляем обработчик мыши для выделения ребра
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (contains(e.getPoint())) {
                    if (isSelected) {
                        setSelected(false);
                    } else {
                        setSelected(true);
                    }
                }
            }
        });
    }

    public void setSelected(boolean selected) {
        if (selected) {
            // Снять выделение с предыдущего выделенного ребра
            if (selectedEdge != null) {
                selectedEdge.deselect();
            }
            selectedEdge = this;
            color = Color.RED;
        } else {
            color = Color.LIGHT_GRAY;
        }
        isSelected = selected;
        revalidate();
        repaint();
    }

    public void deselect() {
        setSelected(false);
    }

    public void setWeight(float weight) {
        this.weight = weight;
        this.weightLabel = String.valueOf(weight);
        repaint();  // Перерисовать компонент для отображения нового веса
    }

    public boolean isSelected() {
        return isSelected;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x1 = startNode.getLocation().x + startNode.getWidth() / 2;
        int y1 = startNode.getLocation().y + startNode.getHeight() / 2;
        int x2 = endNode.getLocation().x + endNode.getWidth() / 2;
        int y2 = endNode.getLocation().y + endNode.getHeight() / 2;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(x1, y1, x2, y2);
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;
        g2d.setColor(Color.BLACK);
        g2d.drawString(weightLabel, midX, midY);
        if(startNode == null || endNode == null){
            remove(this);
        }
    }

    public static GraphEdgePanel getSelectedEdge(){
        return selectedEdge;
    }
    public boolean connects(GraphNodePanel node) {
        return startNode.equals(node) || endNode.equals(node);
    }

    public GraphNodePanel getStartNode(){
        return startNode;
    }

    public GraphNodePanel getEndNode(){
        return endNode;
    }

    public void setColor(Color color1){
        color = color1;
    }
    @Override
    public boolean contains(int x, int y) {
        // Переопределяем метод contains для определения кликабельной области
        int x1 = startNode.getX() + startNode.getWidth() / 2;
        int y1 = startNode.getY() + startNode.getHeight() / 2;
        int x2 = endNode.getX() + endNode.getWidth() / 2;
        int y2 = endNode.getY() + endNode.getHeight() / 2;

        // Вычисляем расстояние от точки до линии (ребра)
        double distance = pointToLineDistance(x, y, x1, y1, x2, y2);

        // Принимаем клик, если расстояние до линии меньше заданной толщины
        return distance <= thickness * 2;
    }

    // Вспомогательный метод для вычисления расстояния от точки до линии
    private double pointToLineDistance(int px, int py, int x1, int y1, int x2, int y2) {
        double A = px - x1;
        double B = py - y1;
        double C = x2 - x1;
        double D = y2 - y1;

        double dot = A * C + B * D;
        double lenSq = C * C + D * D;
        double param = dot / lenSq;

        double xx, yy;

        if (param < 0) {
            xx = x1;
            yy = y1;
        } else if (param > 1) {
            xx = x2;
            yy = y2;
        } else {
            xx = x1 + param * C;
            yy = y1 + param * D;
        }

        double dx = px - xx;
        double dy = py - yy;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
