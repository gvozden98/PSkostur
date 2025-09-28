import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractSo {
    protected final DatabaseBroker dbbr;
    private final Connection connection;

    protected AbstractSo() throws Exception {
        this.connection = DatabaseConnection.getInstance().getConnection();
        this.dbbr = new DatabaseBroker(connection);
    }

    public final void execute(Object request) throws Exception {
        long startNs = System.nanoTime();
        try {
            validate(request);
            executeOperation(request);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        } finally {
            // Uvek zatvori konekciju (bez pool-a)
            DatabaseConnection.getInstance().closeQuietly(connection);
        }
    }

    private void commit() throws SQLException {
        connection.commit();
    }

    private void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ignored) {
        }
    }

    protected abstract void validate(Object request) throws Exception;

    protected abstract void executeOperation(Object request) throws Exception;

}
