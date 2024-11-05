package org.example.window;
import javax.swing.*;
import java.awt.*;


public class MyJFrame extends JFrame {
 public JFrame window;

 public MyJFrame() {

  setTitle("Animal Catcher");
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setSize(1600, 1000);
  setLocationRelativeTo(null);
  setLayout(new BorderLayout());


  MyJPanel panel = new MyJPanel();
  add(panel);

  setVisible(true);

 }

}
