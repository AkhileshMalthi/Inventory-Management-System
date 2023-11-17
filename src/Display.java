import java.awt.Dimension;
import javax.swing.JTextArea;

public class Display extends JTextArea {

    Display() {
        this.setLineWrap(true); // Enable word wrap
        this.setWrapStyleWord(true); // Wrap at word boundaries
        this.setPreferredSize(new Dimension(800,400));
    }
    public static void main(String[] args) {
        
    }
}
