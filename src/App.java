import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        MainFrame Home = new MainFrame("Inventory Management System");
        Home.getContentPane().setBackground(new Color(30, 30, 30));
        Home.setLayout(null);

        final int SearchAreaX = 0;
        final int SearchAreaY = 25;
        final int OptionsAreaX = 0;
        final int OptionsAreaY = 100;
        final boolean showBorders = false;

        Border line = BorderFactory.createLineBorder(Color.WHITE);

        JPanel searchProduct = new JPanel();
        searchProduct.setBackground(Home.getContentPane().getBackground());
        searchProduct.setBounds(SearchAreaX,SearchAreaY,Home.getWidth(),75);
        searchProduct.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
        
        JLabel enterId = new JLabel("Enter Product Id : ");
        enterId.setForeground(Color.WHITE);
        enterId.setFont(new Font("Ariel",Font.BOLD,20));
        
        JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(200,30));
        
        OurButton viewAllProducts = new OurButton("View All Products");
        viewAllProducts.setBounds(650,50,150,50);
        
        JPanel options = new JPanel();
        options.setBounds(OptionsAreaX, OptionsAreaY, Home.getWidth(), 100);
        options.setBackground(Home.getContentPane().getBackground());
        options.setLayout(new FlowLayout(FlowLayout.CENTER,5,25));
        
        
        
        OurButton listAllProducts = new OurButton("List All Products");
        OurButton addProduct = new OurButton("Add Product");
        OurButton updateQuantity = new OurButton("Update Quantity");
        OurButton updateCost = new OurButton("Update Cost");
        OurButton deleteProduct = new OurButton("Delete Product");
        OurButton exit = new OurButton("Exit");
        
        if (showBorders) {
            searchProduct.setBorder(line);
            options.setBorder(line);
        }
        
        searchProduct.add(enterId);
        searchProduct.add(searchBox);
        searchProduct.add(viewAllProducts);
        
        options.add(listAllProducts);
        options.add(addProduct);
        options.add(updateQuantity);
        options.add(updateCost);
        options.add(deleteProduct);
        options.add(exit);

        Home.add(searchProduct);
        Home.add(options);

        ImageIcon icon = new ImageIcon("..\\resources\\inventory.png");
        Home.setIconImage(icon.getImage());

        Home.setVisible(true);
    }
}