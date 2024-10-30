package org.example.window;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        setLayout(new FlowLayout()); // Set layout for the panel

        JButton buttonTitle = new JButton("Wybierz postać");
        JButton buttonBoy = new JButton("Boy");
        JButton buttonGirl = new JButton("Girl");

        buttonTitle.setPreferredSize(new Dimension(150, 50)); // Set button sizes
        buttonBoy.setPreferredSize(new Dimension(150, 50));
        buttonGirl.setPreferredSize(new Dimension(150, 50));
        setLayout(new BorderLayout());

        add(buttonTitle, BorderLayout.NORTH);
        add(buttonBoy, BorderLayout.WEST);
        add(buttonGirl, BorderLayout.EAST);

        setVisible(true);
    }
}
