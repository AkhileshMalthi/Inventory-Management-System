import java.sql.*;

public class BackEnd {
    private static final String url = "jdbc:mysql://localhost:3306/inventory";
    private static final String user = "root";
    private static final String password = "AKakhilesh#29";

    private static final String tableName = "products";
    private static Connection con;

    public static void viewAllProducts() throws SQLException {
        String sql = "SELECT * FROM "+tableName+" limit 10";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

// ------------------------------------------------------------------------------------
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String college = resultSet.getString("college");
//            String branch = resultSet.getString("branch");
//
//
//            System.out.println("ID: " + id);
//            System.out.println("Name: " + name);
//            System.out.println("College: " + college);
//            System.out.println("Branch: " + branch);
//            System.out.println("--------------------");
//        }
// -------------------------------------------------------------------------------------
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Iterate through the ResultSet and print the entire row
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(i);
                System.out.println(columnName + ": " + value);
            }
            System.out.println("--------------------");
        }
    }

    public static void addProduct(String... values) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES(");
        for (int i = 0; i < values.length; i++) {
            if (i == values.length-1) {
                query.append("\"").append(values[i]).append("\")");
            }
            else {
                query.append("\"").append(values[i]).append("\",");
            }
        }

        try {
            PreparedStatement stmt = con.prepareStatement(query.toString());
            stmt.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("The Id already exits");
        }
    }

    public static void updateCost(String id, String newValue) throws SQLException {

        String query = "UPDATE products SET Cost = "+newValue+" WHERE id = "+id;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void updateQuantity(String id, String newValue) throws SQLException {

        String query = "UPDATE products SET Quantity = "+newValue+" WHERE id = "+id;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void deleteProduct(String id) throws SQLException {

        String query = "DELETE FROM products WHERE id = "+id;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) throws SQLException {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (con != null) {

            System.out.println("Connection Successful");

            // Functions to Implement

        } else {
            System.out.println("Connection Unsuccessful");
        }

    }
}
