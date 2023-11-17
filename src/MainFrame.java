import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    MainFrame(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(1000,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
