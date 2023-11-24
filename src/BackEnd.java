import java.sql.*;
import javax.swing.JOptionPane;

/**
 * The BackEnd class handles database operations for a simple inventory management system.
 */
public class BackEnd {
    private static final String url = "jdbc:mysql://localhost:3306/inventory";
    private static final String user = "root";
    private static final String password = "AKakhilesh#29";
    private static final String tableName = "products";
    private static Connection con;

    // Static block to establish a connection to the database when the class is loaded
    static {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves information about a specific product based on its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return A formatted string containing product information.
     * @throws SQLException If a database access error occurs.
     */
    public static String viewProduct(int id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE Id = " + id;
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet product = stmt.executeQuery();
        StringBuilder result = new StringBuilder("");

        ResultSetMetaData metaData = product.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (product.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = product.getObject(i);
                result.append(columnName + ": " + value + "\n");
            }
        }
        return result.toString();
    }

    /**
     * Retrieves information about the first 10 products in the database.
     *
     * @return A formatted string containing information about multiple products.
     * @throws SQLException If a database access error occurs.
     */
    public static String listAllProducts() throws SQLException {
        String sql = "SELECT * FROM " + tableName + " limit 10";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        StringBuilder result = new StringBuilder();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(i);
                result.append(columnName + ": " + value + "\n");
            }
            result.append("____________________\n\n");
        }
        return result.toString();
    }

    /**
     * Adds a new product to the database.
     *
     * @param id       The ID of the new product.
     * @param name     The name of the new product.
     * @param cost     The cost of the new product.
     * @param quantity The quantity of the new product.
     * @throws SQLException If a database access error occurs.
     */
    public static void addProduct(int id, String name, int cost, int quantity) throws SQLException {
        String query = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, cost);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            String errorMessage = "The ID already exists. Please use a different ID.";
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the cost of a product in the database.
     *
     * @param id       The ID of the product to update.
     * @param newValue The new cost value.
     * @throws SQLException If a database access error occurs.
     */
    public static void updateCost(int id, int newValue) throws SQLException {
        String query = "UPDATE products SET Cost = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, newValue);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                String errorMessage = "No product found with the given ID.";
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Updates the quantity of a product in the database.
     *
     * @param id       The ID of the product to update.
     * @param newValue The new quantity value.
     */
    public static void updateQuantity(int id, int newValue) {
        String query = "UPDATE products SET Quantity = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, newValue);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                String errorMessage = "No product found with the given ID.";
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a product from the database based on its ID.
     *
     * @param id The ID of the product to delete.
     */
    public static void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                String errorMessage = "No product found with the given ID.";
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
