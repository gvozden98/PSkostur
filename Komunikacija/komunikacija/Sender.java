import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object obj) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(obj);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska pri slanju");
        }
    }
}
