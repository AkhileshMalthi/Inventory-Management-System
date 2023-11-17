import javax.swing.JFrame;

public class Home extends JFrame {
    Home(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(1000,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        new Home("null");
    }
}
