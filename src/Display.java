import java.awt.Dimension;
import javax.swing.JTextArea;

public class Display extends JTextArea {

    public static int lineCount;

    Display() {
        this.setText("Our Result here");
        this.setLineWrap(true); // Enable word wrap
        this.setWrapStyleWord(true); // Wrap at word boundaries
        this.setPreferredSize(new Dimension(800,400));
        this.setEditable(false);
        lineCount = this.getLineCount();
    }
    public static void main(String[] args) {
        
    }
}
