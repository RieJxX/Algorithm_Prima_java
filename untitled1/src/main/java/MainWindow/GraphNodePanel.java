package MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GraphNodePanel extends JPanel {

    private String label;
    private Color backgroundColor;
    private Color defaultColor = Color.LIGHT_GRAY;
    private Color selectedColor;
    private boolean isSelected;
    private static List<GraphNodePanel> selectedNodes = new ArrayList<>();
    private Point initialClick;
    Vertice vertice;
    private List<GraphEdgePanel> edges;

    public Vertice getVertice(){
        return vertice;
    }

    public void setVertice(Vertice vertice1){
        vertice = vertice1;
    }

    public GraphNodePanel(String label) {
        this.label = label;
        this.backgroundColor = Color.LIGHT_GRAY;
        this.selectedColor = Color.YELLOW;
        this.isSelected = false;
        setPreferredSize(new Dimension(50, 50));
        setOpaque(false); // чтобы сделать фон прозрачным
        this.edges = new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isSelected) {
                    setSelected(false);
                    selectedNodes.remove(GraphNodePanel.this);
                } else {
                    if(selectedNodes.size() == 2) {
                        selectedNodes.getFirst().setSelected(false);
                        selectedNodes.remove(selectedNodes.getFirst());
                        GraphNodePanel.this.setSelected(true);
                        selectedNodes.add(GraphNodePanel.this);
                    }
                    else{
                        setSelected(true);
                        selectedNodes.add(GraphNodePanel.this);
                    }
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Получаем текущее положение панели
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Определяем изменение положения
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Новая позиция панели
                int x = thisX + xMoved;
                int y = thisY + yMoved;

                // Проверяем, чтобы панель не выходила за границы окна
                Container parent = getParent();
                if (parent != null) {
                    Dimension parentSize = parent.getSize();
                    int panelWidth = getWidth();
                    int panelHeight = getHeight();

                    if (x < 0) {
                        x = 0;
                    } else if (x + panelWidth > parentSize.width) {
                        x = parentSize.width - panelWidth;
                    }

                    if (y < 0) {
                        y = 0;
                    } else if (y + panelHeight > parentSize.height) {
                        y = parentSize.height - panelHeight;
                    }
                }

                // Перемещаем панель
                setLocation(x, y);

                updateEdges();
            }
        });
    }

    public void updateEdges() {
        for (GraphEdgePanel edge : edges) {
            setPreferredSize(new Dimension(50, 50));
            edge.repaint();
        }
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        if (isSelected) {
            setBackgroundColor(selectedColor);
        } else {
            setBackgroundColor(defaultColor);
        }
        repaint();
    }

    public boolean isSelected() {
        return isSelected;
    }
    public static List<GraphNodePanel> get_selectedNodes(){
        return selectedNodes;
    }
    public static void remove_selectedNodes(){
        selectedNodes.clear();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Рисуем круг
        int diameter = Math.min(getWidth(), getHeight()) - 10;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g2d.setColor(backgroundColor);
        g2d.fillOval(x, y, diameter, diameter);

        // Рисуем текст
        g2d.setColor(Color.BLACK);
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(label);
        int textHeight = fm.getAscent();
        int textX = (getWidth() - textWidth) / 2;
        int textY = (getHeight() + textHeight) / 2 - 3;

        g2d.drawString(label, textX, textY);
    }

    public void addEdge(GraphEdgePanel edge) {
        edges.add(edge);
    }

    public List<GraphEdgePanel> getEdges() {
        return edges;
    }

    public void removeEdge(GraphEdgePanel edge) {
        edges.remove(edge);
    }
}
