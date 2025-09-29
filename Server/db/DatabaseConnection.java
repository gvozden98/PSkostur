import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    private static DatabaseConnection instance;

    private String url = "jdbc:mysql://localhost:3306/nameOfDatabse";
    private String username = "root";
    private String password = "";

    private DatabaseConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/janispit";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija uspesno uspostavljena");
            connection.setAutoCommit(false);
            ;
        } catch (Exception e) {
            System.out.println("Greska, konekcija sa bazom nije usposavljena!");
            e.printStackTrace();
            throw e;
        }

    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        return connection;
    }

    public void closeQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
                // ignore beacuse we want to preserve the original error and,
                // if it fails while in cleanup nothing to do there
            }
        }
    }
}
