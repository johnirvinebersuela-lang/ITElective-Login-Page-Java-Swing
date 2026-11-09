import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

  private CustomLabel1 label1;
  private CustomLabel2 label2;
  private CustomLabel3 label3;
  private CustomLabel4 label4;
  private CustomLabel5 label5;
  private CustomButton1 button6;

  public HomePage() {
    setTitle("HomePage");
    setSize(1024, 768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(255, 255, 255));
    setLayout(null);

    label1 = new CustomLabel1();
    label1.setBounds(750, 60, 999, 28);
    label1.setForeground(Color.BLACK);
    this.add(label1);

    label2 = new CustomLabel2();
    label2.setBounds(750, 40, 225, 28);
    label2.setForeground(Color.BLACK);
    this.add(label2);

    label3 = new CustomLabel3();
    label3.setBounds(750, 80, 480, 28);
    label3.setForeground(Color.BLACK);
    this.add(label3);

    label4 = new CustomLabel4();
    label4.setBounds(750, 100, 480, 28);
    label4.setForeground(Color.BLACK);
    this.add(label4);

    label5 = new CustomLabel5();
    label5.setBounds(750, 120, 480, 28);
    label5.setForeground(Color.BLACK);
    this.add(label5);

    button6 = new CustomButton1();
    button6.setBounds(886, 675, 120, 36);
    this.add(button6);

    setLocationRelativeTo(null);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      HomePage frame = new HomePage();
      frame.setVisible(true);
    });
  }
}
