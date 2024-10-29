package org.example.window;
import javax.swing.*;


public class MyJFrame{
 private JFrame window;

 public MyJFrame() {
  window = new JFrame();
  window.setTitle("Animal Catcher");
  window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  window.setSize(500, 400);
  window.setLocationRelativeTo(null);

 }

 public void show() {
  window.setVisible(true);
 }
}
