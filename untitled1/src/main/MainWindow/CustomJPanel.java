package MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class CustomJPanel extends JPanel {

    private Color backgroundColor;
    private double rotationAngle;
    private float topLeftRadius;
    private float topRightRadius;
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private Graph graph  = new Graph(new FileInput(""));

    public CustomJPanel() {
        // Устанавливаем начальные параметры
        this.backgroundColor = Color.WHITE;
        this.rotationAngle = 0;
        this.topLeftRadius = 0;
        this.topRightRadius = 0;
        this.bottomLeftRadius = 0;
        this.bottomRightRadius = 0;
    }

    public void setPanelLocation(int x, int y) {
        setBounds(x, y, getWidth(), getHeight());
    }

    public void setPanelSize(int width, int height) {
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
    }

    public void setPanelColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public void setCornerRadii(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.topLeftRadius = topLeft;
        this.topRightRadius = topRight;
        this.bottomLeftRadius = bottomLeft;
        this.bottomRightRadius = bottomRight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        // Устанавливаем сглаживание
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Устанавливаем цвет фона
        g2d.setColor(backgroundColor);

        // Преобразование для вращения
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotationAngle), getWidth() / 2, getHeight() / 2);

        // Создание формы с закругленными углами
        Shape roundRect = createRoundedRectangle(0, 0, getWidth(), getHeight(),
                topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);

        g2d.fill(roundRect);

        // Восстанавливаем оригинальную трансформацию
        g2d.setTransform(old);
        g2d.dispose();
    }

    private Shape createRoundedRectangle(int x, int y, int width, int height,
                                         float topLeftRadius, float topRightRadius,
                                         float bottomLeftRadius, float bottomRightRadius) {
        Path2D.Float path = new Path2D.Float();
        path.moveTo(x + topLeftRadius, y);
        path.lineTo(x + width - topRightRadius, y);
        path.quadTo(x + width, y, x + width, y + topRightRadius);
        path.lineTo(x + width, y + height - bottomRightRadius);
        path.quadTo(x + width, y + height, x + width - bottomRightRadius, y + height);
        path.lineTo(x + bottomLeftRadius, y + height);
        path.quadTo(x, y + height, x, y + height - bottomLeftRadius);
        path.lineTo(x, y + topLeftRadius);
        path.quadTo(x, y, x + topLeftRadius, y);
        path.closePath();
        return path;
    }

    public void setGraph(Graph graph1){
        graph = graph1;
    }

    public Graph getGraph(){
        return graph;
    }

    public void create() {
        if (graph == null) {
            return;
        }
        int width = 1000;
        int height = 500;

        revalidate(); // Перепроверка компонентов
        repaint();    // Перерисовка панели
    }


}
