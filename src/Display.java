import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The Display class represents a scrollable text area within a JScrollPane.
 * It provides methods to set and display text content with specific formatting.
 */
public class Display extends JScrollPane {

    private JTextArea textArea;

    /**
     * Constructor for the Display class.
     * Initializes the display with a default text and specific formatting.
     */
    Display() {
        // Create a JTextArea with default text
        textArea = new JTextArea("Our Result here");

        // Set the font of the text area to Arial, bold, and size 25
        textArea.setFont(new Font("Arial", Font.BOLD, 25));

        // Enable line wrapping to break lines at word boundaries
        textArea.setLineWrap(true);

        // Enable word wrapping to wrap long words to the next line
        textArea.setWrapStyleWord(true);

        // Make the text area non-editable
        textArea.setEditable(false);

        // Set the text area as the view for the scroll pane
        this.setViewportView(textArea);

        // Set the preferred size of the scroll pane to 800 pixels width and 400 pixels height
        this.setPreferredSize(new Dimension(800, 400));
    }

    /**
     * Set the text content of the display.
     *
     * @param text The text to be displayed in the text area.
     */
    public void setText(String text) {
        textArea.setText(text);
    }
}
