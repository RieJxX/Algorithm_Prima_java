package MainWindow;

import javax.swing.*;
    import java.awt.*;
    import java.awt.geom.Path2D;

    public class CustomJButton extends JButton {

        private float topLeftRadius;
        private float topRightRadius;
        private float bottomLeftRadius;
        private float bottomRightRadius;

        public CustomJButton(String text) {
            super(text);
            setDefaults();
        }

        public CustomJButton(String text, Icon icon) {
            super(text, icon);
            setDefaults();
        }

        private void setDefaults() {
            setContentAreaFilled(false); // Устанавливаем прозрачный фон кнопки
            setFocusPainted(false); // Убираем рамку при фокусировке
            setBorderPainted(false); // Убираем стандартную рамку
            topLeftRadius = 20; // Закругление углов по умолчанию
            topRightRadius = 20; // Закругление углов по умолчанию
            bottomLeftRadius = 20; // Закругление углов по умолчанию
            bottomRightRadius = 20; // Закругление углов по умолчанию
        }

        public void setButtonLocation(int x, int y) {
            setBounds(x, y, getWidth(), getHeight());
        }

        public void setButtonColor(Color backgroundColor, Color textColor) {
            setBackground(backgroundColor);
            setForeground(textColor);
        }

        public void setButtonIcon(Icon icon) {
            setIcon(icon);
        }

        public void setButtonSize(int width, int height) {
            setSize(width, height);
            setPreferredSize(new Dimension(width, height));
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
            Graphics2D g2d = (Graphics2D) g.create();

            // Включаем сглаживание
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Создаем форму с закругленными углами
            Shape buttonShape = createRoundedRectangle(0, 0, getWidth(), getHeight(),
                    topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);

            // Рисуем закругленные углы
            g2d.setColor(getBackground());
            g2d.fill(buttonShape);

            // Рисуем текст и иконку
            super.paintComponent(g);

            g2d.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape buttonShape = createRoundedRectangle(0, 0, getWidth(), getHeight(),
                    topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
            g2d.setColor(getForeground());
            g2d.draw(buttonShape);
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

    }
