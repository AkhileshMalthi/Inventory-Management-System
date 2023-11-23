package src;

import javax.swing.JOptionPane;

public class GetData {

    public static String getID() {
        String id = JOptionPane.showInputDialog(null, "Enter the ID", "Required Detail", 3);
        // Handle exceptions
        return id;
    }

    public static String getName() {
        String id = JOptionPane.showInputDialog(null, "Enter the Name", "Required Detail", 3);
        // Handle exceptions
        return id;
    }

    public static String getQuantity() {
        String id = JOptionPane.showInputDialog(null, "Enter the Quantity", "Required Detail", 3);
        return id;
    }
    public static String getCost() {
        String id = JOptionPane.showInputDialog(null, "Enter the Cost", "Required Detail", 3);
        return id;
    }

}
