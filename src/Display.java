import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Display extends JScrollPane {

    private JTextArea textArea;

    Display() {
        textArea = new JTextArea("Our Result here");
        textArea.setFont(new Font("Arial", Font.BOLD, 25));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(800, 400));
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
