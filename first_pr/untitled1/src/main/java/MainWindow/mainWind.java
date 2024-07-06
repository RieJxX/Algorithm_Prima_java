package MainWindow;

import javax.swing.*;
import java.awt.*;

public class mainWind {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Custom Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Запуск в полноэкранном режиме
        frame.setSize(screenSize);
        frame.setResizable(false);
        frame.setLayout(null);

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

        MainWindow.CustomJButton customButton3_1 = new MainWindow.CustomJButton("");
        customButton3_1.setButtonSize(100 , 100);
        customButton3_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton3_1.setCornerRadii(20,20,20,20);
        customButton3_1.setButtonLocation((customPanel.getWidth() - customButton3_2.getWidth())* 3 / 5, (customPanel.getHeight() - customButton3_2.getHeight()) / 2);
        // Установка иконки на кнопку
        Icon icon3_1 = new ImageIcon("src/main/resources/Edit 11.png");
        customButton3_1.setButtonIcon(icon3_1);

        MainWindow.CustomJButton customButton4_1 = new MainWindow.CustomJButton("");
        customButton4_1.setButtonSize(100 , 100);
        customButton4_1.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton4_1.setCornerRadii(20,20,20,20);
        customButton4_1.setButtonLocation((customPanel.getWidth() - customButton4_2.getWidth())* 4 / 5, (customPanel.getHeight() - customButton4_2.getHeight()) / 2);
        // Установка иконки на кнопку
        ImageIcon icon4_1 = new ImageIcon("src/main/resources/Delete.png");
        customButton4_1.setButtonIcon(icon4_1);

        MainWindow.CustomJButton customButton1_3 = new MainWindow.CustomJButton("");
        customButton1_3.setButtonSize(100 ,  100);
        customButton1_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton1_3.setCornerRadii(20,20,20,20);
        customButton1_3.setButtonLocation((customPanel3.getWidth() - customButton1_3.getWidth()) / 2, (customPanel3.getHeight() - customButton1_1.getHeight()) * 1 / 11);
        // Установка иконки на кнопку
        Icon icon1_3 = new ImageIcon("src/main/resources/Icon (4).png");
        customButton1_3.setButtonIcon(icon1_3);

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
        Icon icon3_3 = new ImageIcon("src/main/resources/Info.png");
        customButton3_3.setButtonIcon(icon3_3);

        MainWindow.CustomJButton customButton4_3 = new MainWindow.CustomJButton("");
        customButton4_3.setButtonSize(100 ,  100);
        customButton4_3.setButtonColor(Color.LIGHT_GRAY, Color.WHITE);
        customButton4_3.setCornerRadii(20,20,20,20);
        customButton4_3.setButtonLocation((customPanel3.getWidth() - customButton4_3.getWidth()) / 2, (customPanel3.getHeight() - customButton4_3.getHeight()) * 10 / 11);
        // Установка иконки на кнопку
        Icon icon4_3 = new ImageIcon("src/main/resources/Upload.png");
        customButton4_3.setButtonIcon(icon4_3);

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
        frame.setVisible(true);
    }
}
