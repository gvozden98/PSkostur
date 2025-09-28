import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread {
    private Server server;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private ServerController controller;
    private Object loggedKorisnik;

    public ClientThread() {
    }

    public ClientThread(Socket socket, Server server) {
        this.server = server;
        this.socket = socket;
        this.controller = new ServerController();
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {

        while (true) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperacije()) {
                        /*
                         * case LOGIN:
                         * Korisnik k = (Korisnik) request.getArgument();
                         * if (server.notLogin(k)) {
                         * response.setResult(controller.Login(k));
                         * loggedKorisnik = k;
                         * server.refreshUI();
                         * } else {
                         * response.setException(new Exception("User already logged in"));
                         * }
                         * break;
                         * case LOGOUT:
                         * if (loggedKorisnik != null) {
                         * try {
                         * controller.Logout(loggedKorisnik);
                         * response.setResult(true);
                         * loggedKorisnik = null;
                         * server.refreshUI();
                         * } catch (Exception e) {
                         * response.setException(e);
                         * }
                         * } else {
                         * response.setException(new Exception("User not logged in"));
                         * }
                         * break;
                         * case GET_ALL_LOGGEDIN:
                         * List<Korisnik> loggedInKorisnici = controller.getAllLoggedIn();
                         * response.setResult(request);
                         * 
                         * break;
                         */
                        default:
                            throw new AssertionError("N/A");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (Exception e) {
                System.out.println("Client disconnected: " + e.getMessage());
                break;
            }
        }

    }

}
