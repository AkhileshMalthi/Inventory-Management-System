import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * The MainFrame class represents the main application window.
 * It extends the JFrame class and sets up basic properties for the window.
 */
public class MainFrame extends JFrame {

    /**
     * Constructor for the MainFrame class.
     * Initializes the main application window with specified properties.
     *
     * @param title The title of the main window.
     */
    MainFrame(String title) {
        // Set the title of the main window
        this.setTitle(title);

        // Set default close operation to exit the application when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager for the content pane to FlowLayout
        this.setLayout(new FlowLayout());

        // Set the size of the main window to 1000 pixels width and 750 pixels height
        this.setSize(1000, 750);

        // Center the main window on the screen
        this.setLocationRelativeTo(null);

        // Disable window resizing
        this.setResizable(false);

        // Make the main window visible
        this.setVisible(true);
    }
}
