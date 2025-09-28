import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseBroker {

    private final Connection connection;

    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    /*
     * public Korisnik getKorisnik(Korisnik kredencijali) throws SQLException {
     * String sql = """
     * SELECT idKorisnika, ime, prezime, email, ocena
     * FROM korisnik
     * WHERE email = ? AND lozinka = ?
     * """;
     * try (PreparedStatement ps = connection.prepareStatement(sql)) {
     * ps.setString(1, kredencijali.getEmail());
     * ps.setString(2, kredencijali.getPassword());
     * try (ResultSet rs = ps.executeQuery()) {
     * if (rs.next())
     * return mapKorisnik(rs);
     * }
     * }
     * return null;
     * }
     */

    /*
     * private Korisnik mapKorisnik(ResultSet rs) throws SQLException {
     * Korisnik k = new Korisnik();
     * k.setIdKorisnika(rs.getLong("idKorisnika"));
     * k.setIme(rs.getString("ime"));
     * k.setPrezime(rs.getString("prezime"));
     * k.setEmail(rs.getString("email"));
     * k.setOcena(rs.getInt("ocena"));
     * return k;
     * }
     */
}
