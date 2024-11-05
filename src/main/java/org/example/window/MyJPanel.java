package org.example.window;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        setLayout(new BorderLayout());
        setBackground( new Color(253, 214, 255));

        JTextField Title = new JTextField("Wybierz postać");
        Title.setPreferredSize(new Dimension(200, 60));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Title.setBackground(Color.WHITE);
        Title.setEditable(false);

        ImageIcon buttonBImage = new ImageIcon("C:/Users/uczen/IdeaProjects/AnimalCatcher/src/main/java/org/example/img/boy.jpg");
        Image imageboy = buttonBImage.getImage();
        Image scaledImage = imageboy.getScaledInstance(320, 300, Image.SCALE_SMOOTH);
        JButton buttonBoyImage = new JButton(new ImageIcon(scaledImage));
        buttonBoyImage.setPreferredSize(new Dimension(320, 300));

        ImageIcon buttonGImage = new ImageIcon("C:/Users/uczen/IdeaProjects/AnimalCatcher/src/main/java/org/example/img/girl.jpg");
        Image imagegirl = buttonGImage.getImage();
        Image scaledGrilImage = imagegirl.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JButton buttonGirlImage = new JButton(new ImageIcon(scaledGrilImage));
        buttonGirlImage.setPreferredSize(new Dimension(300, 300));

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        imagePanel.add(buttonBoyImage);
        imagePanel.add(buttonGirlImage);

        JPanel spacerPanel = new JPanel();
        spacerPanel.setPreferredSize(new Dimension(getWidth(), 15));

        JPanel imageAndSpacerPanel = new JPanel();
        imageAndSpacerPanel.setLayout(new BoxLayout(imageAndSpacerPanel, BoxLayout.Y_AXIS));
        imageAndSpacerPanel.add(imagePanel);
        imageAndSpacerPanel.add(spacerPanel);
        imageAndSpacerPanel.setPreferredSize(new Dimension(getWidth(), 350));

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 125, 20));

        JTextField boyStats = new JTextField("Statystyki", 16);
        boyStats.setPreferredSize(new Dimension(320, 400));
        boyStats.setEditable(false);
        boyStats.setBackground(Color.PINK);
        boyStats.setForeground(Color.BLACK);
        boyStats.setFont(new Font("Arial", Font.PLAIN, 16));

        JTextField girlStats = new JTextField("Statystyki", 15);
        girlStats.setPreferredSize(new Dimension(300, 400));
        girlStats.setEditable(false);
        girlStats.setBackground(Color.PINK);
        girlStats.setForeground(Color.BLACK);
        girlStats.setFont(new Font("Arial", Font.PLAIN, 16));

        statsPanel.add(boyStats);
        statsPanel.add(girlStats);

        add(Title, BorderLayout.NORTH);
        add(imageAndSpacerPanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}