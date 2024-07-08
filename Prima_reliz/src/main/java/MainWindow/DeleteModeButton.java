package MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteModeButton extends CustomJButton {
    private boolean removeMode = false;
    private List<MouseAdapter> mouseAdapters = new ArrayList<>();

    public DeleteModeButton(String text) {
        super(text);
        setDefaults();
    }

    public boolean getRemoveMode() {
        return removeMode;
    }

    public void setRemoveMode(boolean removeMode1) {
        removeMode = removeMode1;
    }

    public void setBackgroundRemoveMode() {
        if (removeMode) {
            this.setBackground(Color.RED);
        } else {
            this.setBackground(new Color(174, 188, 242));
        }
    }

    public void enableComponentRemoval(CustomJPanel panel, List<GraphEdgePanel> graph_edges, List<GraphNodePanel> nodes) {
        for (Component component : panel.getComponents()) {
            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (removeMode) {
                        if (component instanceof GraphNodePanel) {
                            GraphNodePanel node = (GraphNodePanel) component;
                            List<GraphEdgePanel> edgesToRemove = new ArrayList<>();
                            for (GraphEdgePanel edge : graph_edges) {
                                if (edge.connects(node)) {
                                    edgesToRemove.add(edge);
                                }
                            }
                            for (GraphEdgePanel edge : edgesToRemove) {
                                graph_edges.remove(edge);
                                edge.getStartNode().removeEdge(edge);
                                edge.getEndNode().removeEdge(edge);
                                panel.remove(edge);
                            }
                            nodes.remove(node);
                        } else if (component instanceof GraphEdgePanel) {
                            GraphEdgePanel edge = (GraphEdgePanel) component;
                            graph_edges.remove(edge);
                            edge.getStartNode().removeEdge(edge);
                            edge.getEndNode().removeEdge(edge);
                        }
                        panel.remove(component);
                        panel.revalidate();
                        panel.repaint();
                    }
                }
            };
            component.addMouseListener(mouseAdapter);
            mouseAdapters.add(mouseAdapter);
        }
    }

    public void disableComponentRemoval(JPanel panel) {
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Component component = panel.getComponent(i);
            component.removeMouseListener(mouseAdapters.get(i));
        }
        mouseAdapters.clear();
    }

    private void setDefaults() {
        setContentAreaFilled(false); // Устанавливаем прозрачный фон кнопки
        setFocusPainted(false); // Убираем рамку при фокусировке
        setBorderPainted(false); // Убираем стандартную рамку
    }
}
