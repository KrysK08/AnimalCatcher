package org.example.window;
import javax.swing.*;
import java.awt.*;


public class MyJFrame extends JFrame {
 public JFrame window;

 public MyJFrame() {

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int screenWidth = screenSize.width;

  setTitle("Animal Catcher");
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setSize(screenWidth, 880);
  setLocation(0,0);
  setLayout(new BorderLayout());
  setResizable(false);
  ImageIcon logo = new ImageIcon("src/main/java/org/example/img/logo.png");
  setIconImage(logo.getImage());



  MyJPanel panel = new MyJPanel();
  add(panel);

  setVisible(true);

 }

}
