import javax.swing.*;

/**
 * The GetData class provides methods to retrieve user input through JOptionPane dialogs.
 */
public class GetData {

    /**
     * Retrieves and validates an integer ID from the user using a JOptionPane dialog.
     *
     * @return The user-entered ID, or -1 if the user cancels the operation.
     */
    public static int getID() {
        int id;
        while (true) {
            try {
                String idString = JOptionPane.showInputDialog(null, "Enter the ID", "Required Detail", 3);
                if (idString == null) {
                    return -1;  
                }
                id = Integer.parseInt(idString);
                break;  
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return id;
    }

    /**
     * The GetName class within GetData provides a method to retrieve and validate a name from the user.
     */
    public static class GetName {

        /**
         * Retrieves and validates a name from the user using a JOptionPane dialog.
         *
         * @return The user-entered name, or null if the user cancels the operation.
         */
        public static String getName() {
            String name;
            while (true) {
                name = JOptionPane.showInputDialog(null, "Enter the Name", "Required Detail", 3);
                
                if (name != null && !containsDigits(name)) {
                    break;  
                } else if (name == null) {
                    return null;  
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid name (without digits).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            return name;
        }

        /**
         * Checks if a given string contains any digits.
         *
         * @param s The string to check.
         * @return True if the string contains digits, false otherwise.
         */
        private static boolean containsDigits(String s) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Retrieves and validates an integer quantity from the user using a JOptionPane dialog.
     *
     * @return The user-entered quantity, or -1 if the user cancels the operation.
     */
    public static int getQuantity() {
        int quantity;
        while (true) {
            try {
                String quantityString = JOptionPane.showInputDialog(null, "Enter the Quantity", "Required Detail", 3);
                
                if (quantityString == null) {
                    return -1;  
                } else if (!quantityString.isEmpty()) {
                    quantity = Integer.parseInt(quantityString);
                    break;  
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for Quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return quantity;
    }

    /**
     * Retrieves and validates an integer cost from the user using a JOptionPane dialog.
     *
     * @return The user-entered cost, or -1 if the user cancels the operation.
     */
    public static int getCost() {
        int cost;
        while (true) {
            try {
                String costString = JOptionPane.showInputDialog(null, "Enter the Cost", "Required Detail", 3);
                if (costString == null) {
                    return -1;  
                }
                cost = Integer.parseInt(costString);
                break;  
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for Cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cost;
    }
}
