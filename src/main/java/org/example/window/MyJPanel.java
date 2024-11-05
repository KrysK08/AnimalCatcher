package org.example.window;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        setLayout(new BorderLayout());

        JButton buttonTitle = new JButton("Wybierz postać");
        buttonTitle.setPreferredSize(new Dimension(200, 60));
        buttonTitle.setHorizontalAlignment(SwingConstants.CENTER);
        buttonTitle.setFont(new Font("Arial", Font.BOLD, 25));

        ImageIcon buttonBImage = new ImageIcon("C:/Users/uczen/IdeaProjects/AnimalCatcher/src/main/java/org/example/img/boy.jpg");
        Image imageboy = buttonBImage.getImage();
        Image scaledImage = imageboy.getScaledInstance(320, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledButtonBImage = new ImageIcon(scaledImage);
        JButton buttonBoyImage = new JButton(scaledButtonBImage);
        buttonBoyImage.setPreferredSize(new Dimension(320, 300));

        ImageIcon buttonGImage = new ImageIcon("C:/Users/uczen/IdeaProjects/AnimalCatcher/src/main/java/org/example/img/girl.jpg");
        Image imagegirl = buttonGImage.getImage();
        Image scaledGrilImage = imagegirl.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledButtonGImage = new ImageIcon(scaledGrilImage);
        JButton buttonGirlImage = new JButton(scaledButtonGImage);
        buttonGirlImage.setPreferredSize(new Dimension(300, 300));


        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        imagePanel.add(buttonBoyImage);
        imagePanel.add(buttonGirlImage);

        JTextField boyStats = new JTextField("Statystyki", 20);
        boyStats.setPreferredSize(new Dimension(200, 60));

        JTextField girlStats = new JTextField("Statystyki", 20);
        girlStats.setPreferredSize(new Dimension(200, 60));

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        statsPanel.add(boyStats);
        statsPanel.add(girlStats);

        add(buttonTitle, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
