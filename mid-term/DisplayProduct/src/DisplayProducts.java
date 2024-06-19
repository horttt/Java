import java.sql.*;

public class DisplayProducts {
    private static final String JDBC_URL = "jdbc:mysql://localhost:8080/javaDb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");

            System.out.println("ID\tName\t\tPrice\tActive");
            System.out.println("---------------------------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double pricePerUnit = resultSet.getDouble("price_per_unit");
                boolean activeForSell = resultSet.getBoolean("active_for_sell");

                System.out.println(id + "\t" + name + "\t\t" + pricePerUnit + "\t" + activeForSell);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}