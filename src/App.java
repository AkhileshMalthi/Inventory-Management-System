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

public class App {

    public static void main(String[] args) {
        MainFrame Home = new MainFrame("Inventory Management System");
        Home.getContentPane().setBackground(new Color(30, 30, 30));
        Home.setLayout(null);

        final int SearchAreaX = 0;
        final int SearchAreaY = 25;

        final int OptionsAreaX = 0;
        final int OptionsAreaY = 100;

        final int ResultsAreaX = 50;
        final int ResultsAreaY = 200;

        final boolean showBorders = false;

        Border line = BorderFactory.createLineBorder(Color.WHITE);

        JPanel searchProduct = new JPanel();
        searchProduct.setBackground(Home.getContentPane().getBackground());
        searchProduct.setBounds(SearchAreaX, SearchAreaY, Home.getWidth(), 75);
        searchProduct.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JLabel enterId = new JLabel("Enter Product Id : ");
        enterId.setForeground(Color.WHITE);
        enterId.setFont(new Font("Ariel", Font.BOLD, 20));

        JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(200, 30));

        OurButton viewProduct = new OurButton("View Product");
        viewProduct.setBounds(650, 50, 150, 50);

        JPanel options = new JPanel();
        options.setBounds(OptionsAreaX, OptionsAreaY, Home.getWidth(), 100);
        options.setBackground(Home.getContentPane().getBackground());
        options.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

        OurButton listAllProducts = new OurButton("List All Products");
        OurButton addProduct = new OurButton("Add Product");
        OurButton updateQuantity = new OurButton("Update Quantity");
        OurButton updateCost = new OurButton("Update Cost");
        OurButton deleteProduct = new OurButton("Delete Product");
        OurButton exit = new OurButton("Exit");

        Display results = new Display();
        results.setBounds(ResultsAreaX, ResultsAreaY, Home.getWidth() - 100, 400);

        if (showBorders) {
            searchProduct.setBorder(line);
            options.setBorder(line);
        }

        viewProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(searchBox.getText());
                    if (id != -1) {
                        String data = BackEnd.viewProduct(id);
                        results.setText(data);
                    } else {
                        JOptionPane.showMessageDialog(null, "View Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        listAllProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String data = BackEnd.listAllProducts();
                    results.setText(data);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    String name = GetData.GetName.getName();
                    if (name == null) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    int cost = GetData.getCost();
                    if (cost == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    int quantity = GetData.getQuantity();
                    if (quantity == -1) {
                        JOptionPane.showMessageDialog(null, "Add Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    BackEnd.addProduct(id, name, cost, quantity);

                } catch (NumberFormatException | SQLException e1) {
                    System.out.println("Adding Product Operation failed");
                    e1.printStackTrace();
                }
            }
        });

        updateQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Update Quantity operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    int quantity = GetData.getQuantity();
                    if (quantity == -1) {
                        JOptionPane.showMessageDialog(null, "Update Quantity operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    BackEnd.updateQuantity(id, quantity);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
            }
        });

        updateCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Update Cost operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    int cost = GetData.getCost();
                    if (cost == -1) {
                        JOptionPane.showMessageDialog(null, "Update Cost operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    BackEnd.updateCost(id, cost);

                } catch (NumberFormatException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = GetData.getID();
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Delete Product operation canceled.", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return; // Cancel the operation
                    }

                    BackEnd.deleteProduct(id);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
            }
        });

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

        ImageIcon icon = new ImageIcon("..\\resources\\inventory-management.png");
        Home.setIconImage(icon.getImage());

        Home.setVisible(true);
    }
}
