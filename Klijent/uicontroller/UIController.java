import java.net.Socket;

public class UIController {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private static UIController instance;

    private UIController() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static UIController getInstance() throws Exception {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public Object login(Object obj) throws Exception {
        Request request = new Request(obj, Operation.LOGIN);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (Object) response.getResult();
        } else {
            throw response.getException();
        }
    }

}
