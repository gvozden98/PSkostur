import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                // clients.add(clientThread);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
