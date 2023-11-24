import java.sql.*;

public class BackEnd {
    private static final String url = "jdbc:mysql://localhost:3306/inventory";
    private static final String user = "root";
    private static final String password = "mysql";

    private static final String tableName = "products";

    private static Connection con;
    static {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                result.append(columnName + ": " + value);
            }
        }
        return result.toString();
    }

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
                result.append(columnName + ": " + value);
            }
            System.out.println("--------------------");
        }
        return result.toString();
    }

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
            System.out.println("The Id already exists");
        }
    }

    public static void updateCost(int id, int newValue) throws SQLException {
        String query = "UPDATE products SET Cost = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateQuantity(int id, int newValue) throws SQLException {
        String query = "UPDATE products SET Quantity = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteProduct(int id) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
