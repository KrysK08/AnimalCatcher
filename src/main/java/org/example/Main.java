package org.example;
import org.example.window.MyJFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyJFrame window = new MyJFrame();
                window.show();
            }
        });
    }
}