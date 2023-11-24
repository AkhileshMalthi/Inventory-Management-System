import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * The main class representing the Inventory Management System application.
 */
public class App {

    public static void main(String[] args) {
        // Create the main frame for the application
        MainFrame Home = new MainFrame("Inventory Management System");
        Home.getContentPane().setBackground(new Color(30, 30, 30));
        Home.setLayout(null);

        // Define constants for the positions of different areas in the main window
        final int SearchAreaX = 0;
        final int SearchAreaY = 25;
        final int OptionsAreaX = 0;
        final int OptionsAreaY = 100;
        final int ResultsAreaX = 50;
        final int ResultsAreaY = 200;
        final boolean showBorders = false;

        // Create a line border for styling
        Border line = BorderFactory.createLineBorder(Color.WHITE);

        // Create a panel for searching products
        JPanel searchProduct = new JPanel();
        searchProduct.setBackground(Home.getContentPane().getBackground());
        searchProduct.setBounds(SearchAreaX, SearchAreaY, Home.getWidth(), 75);
        searchProduct.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        // Create a label and text field for entering product ID
        JLabel enterId = new JLabel("Enter Product Id : ");
        enterId.setForeground(Color.WHITE);
        enterId.setFont(new Font("Ariel", Font.BOLD, 20));

        JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(200, 30));
        searchBox.setFont(new Font("Arial", Font.BOLD, 25));

        // Create a custom button for viewing product details
        OurButton viewProduct = new OurButton("View Product");
        viewProduct.setBounds(650, 50, 150, 50);

        // Create a panel for options (buttons for various operations)
        JPanel options = new JPanel();
        options.setBounds(OptionsAreaX, OptionsAreaY, Home.getWidth(), 100);
        options.setBackground(Home.getContentPane().getBackground());
        options.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

        // Create buttons for different operations
        OurButton listAllProducts = new OurButton("List All Products");
        OurButton addProduct = new OurButton("Add Product");
        OurButton updateQuantity = new OurButton("Update Quantity");
        OurButton updateCost = new OurButton("Update Cost");
        OurButton deleteProduct = new OurButton("Delete Product");
        OurButton exit = new OurButton("Exit");

        // Create a display panel for showing operation results
        Display results = new Display();
        results.setBounds(ResultsAreaX, ResultsAreaY, Home.getWidth() - 100, 400);

        // Set borders if showBorders is true
        if (showBorders) {
            searchProduct.setBorder(line);
            options.setBorder(line);
        }

        // Action listener for the "View Product" button
        viewProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve the product ID entered by the user
                    int id = Integer.parseInt(searchBox.getText());
                    if (id != -1) {
                        // Fetch product details from the backend and display the results
                        String data = BackEnd.viewProduct(id);
                        results.setText(data);
                    } else {
                        JOptionPane.showMessageDialog(null, "View Product operation canceled.", "Info",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "List All Products" button
        listAllProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Fetch and display details of all products from the backend
                    String data = BackEnd.listAllProducts();
                    results.setText(data);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "Add Product" button
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get product details from user input using the GetData class
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    String name = GetData.GetName.getName();
                    if (name == null) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    int cost = GetData.getCost();
                    if (cost == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    int quantity = GetData.getQuantity();
                    if (quantity == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    // Add the new product to the backend
                    BackEnd.addProduct(id, name, cost, quantity);

                } catch (NumberFormatException | SQLException e1) {
                    System.out.println("Adding Product Operation failed");
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "Update Quantity" button
        updateQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get product ID and new quantity from user input
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Update Quantity operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    int quantity = GetData.getQuantity();
                    if (quantity == -1) {
                        JOptionPane.showMessageDialog(null, "Update Quantity operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    // Update the quantity of the specified product in the backend
                    BackEnd.updateQuantity(id, quantity);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "Update Cost" button
        updateCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get product ID and new cost from user input
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Update Cost operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    int cost = GetData.getCost();
                    if (cost == -1) {
                        JOptionPane.showMessageDialog(null, "Update Cost operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    // Update the cost of the specified product in the backend
                    BackEnd.updateCost(id, cost);

                } catch (NumberFormatException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "Delete Product" button
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get product ID for deletion from user input
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Delete Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }

                    // Delete the specified product from the backend
                    BackEnd.deleteProduct(id);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Action listener for the "Exit" button
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application window
                Home.dispose();
            }
        });

        // Add components to the main window
        searchProduct.add(enterId);
        searchProduct.add(searchBox);
        searchProduct.add(viewProduct);

        options.add(listAllProducts);
        options.add(addProduct);
        options.add(updateQuantity);
        options.add(updateCost);
        options.add(deleteProduct);
        options.add(exit);

        Home.add(searchProduct);
        Home.add(options);
        Home.add(results);

        // Set the application icon
        ImageIcon icon = new ImageIcon("..\\resources\\inventory-management.png");
        Home.setIconImage(icon.getImage());

        // Make the main window visible
        Home.setVisible(true);
    }
}
