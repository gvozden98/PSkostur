public class SOLoginKorisnika extends AbstractSo {

    private Korisnik rezultat;

    public SOLoginKorisnika() throws Exception {
        super();
    }

    public Korisnik getKorisnik() {
        return rezultat;
    }

    @Override
    protected void validate(Object request) throws Exception {
        if (!(request instanceof Korisnik k)) {
            throw new IllegalArgumentException("Očekivan je objekat tipa Korisnik.");
        }
        if (k.getEmail() == null || k.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email je obavezan.");
        }
        if (k.getPassword() == null || k.getPassword().isBlank()) {
            throw new IllegalArgumentException("Šifra je obavezna.");
        }
    }

    @Override
    protected void executeOperation(Object request) throws Exception {
        Korisnik kredencijali = (Korisnik) request;

        Korisnik found = dbbr.getKorisnik(kredencijali);

        if (found == null) {
            throw new Exception("Pogrešan email ili šifra.");
        }

        this.rezultat = found;
    }
}