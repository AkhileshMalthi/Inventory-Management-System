import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 * The OurButton class represents a customized JButton with specific styling.
 */
public class OurButton extends JButton {

    /**
     * Constructor for the OurButton class.
     * Initializes the button with the specified name and sets up custom styling.
     *
     * @param name The text to be displayed on the button.
     */
    OurButton(String name) {
        // Set the text on the button
        this.setText(name);

        // Ensure the button does not get focus when clicked
        this.setFocusable(false);

        // Set the text color to white
        this.setForeground(Color.WHITE);

        // Set the background color using RGB values
        this.setBackground(new Color(107, 61, 200));

        // Set the font style to Arial, bold, and size 13
        this.setFont(new Font("Arial", Font.BOLD, 13));

        // Set the preferred size of the button to 150 pixels width and 50 pixels height
        this.setPreferredSize(new Dimension(150, 50));

        // Uncomment the line below to hide the button border
        // this.setBorderPainted(false);
    }
}
