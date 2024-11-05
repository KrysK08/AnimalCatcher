package org.example;
import org.example.window.MyJFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyJFrame window = new MyJFrame();
        });
    }
}