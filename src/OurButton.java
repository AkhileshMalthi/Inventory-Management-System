import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class OurButton extends JButton {
    
    OurButton(String name) {
        this.setText(name);
        this.setFocusable(false);
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(107, 61, 200));
        this.setFont(new Font("Comic sans",Font.BOLD,15));
    }
}
