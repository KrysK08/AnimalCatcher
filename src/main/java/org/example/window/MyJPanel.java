package org.example.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJPanel extends JPanel {
    private static String wchichCahracter;
    public static String getWchichCahracter() {
        return wchichCahracter;
    }
    public MyJPanel() {
        setLayout(new BorderLayout());
        JTextField Title = new JTextField("Choose your character");
        Title.setPreferredSize(new Dimension(200, 60));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Title.setBackground(Color.WHITE);
        Title.setEditable(false);

        ImageIcon buttonBImage = new ImageIcon("src/main/java/org/example/img/boy.jpg");
        Image imageboy = buttonBImage.getImage();
        Image scaledImage = imageboy.getScaledInstance(320, 300, Image.SCALE_SMOOTH);
        JButton buttonBoyImage = new JButton(new ImageIcon(scaledImage));
        buttonBoyImage.setPreferredSize(new Dimension(320, 300));

        buttonBoyImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Background();
                wchichCahracter = "boy.jpg";
            }
        });

        ImageIcon buttonGImage = new ImageIcon("src/main/java/org/example/img/girl.jpg");
        Image imagegirl = buttonGImage.getImage();
        Image scaledGrilImage = imagegirl.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JButton buttonGirlImage = new JButton(new ImageIcon(scaledGrilImage));
        buttonGirlImage.setPreferredSize(new Dimension(300, 300));

        buttonGirlImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Background();
                wchichCahracter = "girl.jpg";

            }
        });

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        imagePanel.add(buttonBoyImage);
        imagePanel.add(buttonGirlImage);
        imagePanel.setBackground( new Color(255, 220, 236));

        JPanel spacerPanel = new JPanel();
        spacerPanel.setPreferredSize(new Dimension(getWidth(), 15));

        JPanel imageAndSpacerPanel = new JPanel();
        imageAndSpacerPanel.setLayout(new BoxLayout(imageAndSpacerPanel, BoxLayout.Y_AXIS));
        imageAndSpacerPanel.add(imagePanel);
        imageAndSpacerPanel.add(spacerPanel);
        imageAndSpacerPanel.setPreferredSize(new Dimension(getWidth(), 350));

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JTextArea boyStats = new JTextArea("\n                            Boy character\n\n   Name: Central Cee\n   Speed: ???\n   Jumping: ???\n\n                                 History: \nWhile walking through the park, Central Cee \nnoticed a small dog trapped in some bushes. \nThe dog was scared and helpless, but \nCentral Cee couldn't just walk away. With \npatience, he carefully freed the dog and called \na shelter for help. Thanks to him, the dog got \nthe care it needed, and Central Cee decided \nto dedicate himself to animal rescue from that \nmoment on.", 20,16);
        boyStats.setPreferredSize(new Dimension(320, 400));
        boyStats.setEditable(false);
        boyStats.setBackground(Color.PINK);
        boyStats.setForeground(Color.BLACK);
        boyStats.setFont(new Font("Arial", Font.PLAIN, 16));


        JTextArea girlStats = new JTextArea("\n                          Girl character\n\n   Name: Ice Spice\n   Speed: ???\n   Jumping: ???\n\n                               History: \nWhile traveling through the jungle, Ice Spice \ncame across poachers hunting a rare \njaguar. Without hesitation, she alerted \nwildlife protectors and cleverly distracted \nthe poachers, giving them time to intervene. \nThanks to her bravery, the jaguar was \nsaved, and Ice Spice made a vow to keep \nfighting for the protection of wild animals.",20, 15);
        girlStats.setPreferredSize(new Dimension(300, 400));
        girlStats.setEditable(false);
        girlStats.setBackground(Color.PINK);
        girlStats.setForeground(Color.BLACK);
        girlStats.setFont(new Font("Arial", Font.PLAIN, 16));

        statsPanel.add(boyStats);
        statsPanel.add(girlStats);
        statsPanel.setBackground( new Color(255, 220, 236));

        add(Title, BorderLayout.NORTH);
        add(imageAndSpacerPanel, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
