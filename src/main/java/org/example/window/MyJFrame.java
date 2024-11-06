package org.example.window;
import javax.swing.*;
import java.awt.*;


public class MyJFrame extends JFrame {
 public JFrame window;

 public MyJFrame() {

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int screenWidth = screenSize.width;
  int screenHeight = screenSize.height;

  setTitle("Animal Catcher");
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setSize(screenWidth+20, screenHeight-30);
  setLocation(0,0);
  setLayout(new BorderLayout());



  MyJPanel panel = new MyJPanel();
  add(panel);

  setVisible(true);

 }

}
