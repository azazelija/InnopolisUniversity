package lesson10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 18395435
 * @created_at 21/05/2020 - 23:36
 * @project InnopolisUniversity
 */
public class ChatServer implements Runnable {
    public static final int PORT = 8080;
    private static final ExecutorService executeIt = Executors.newCachedThreadPool();

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(PORT)) {

            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new SocketListener(client));
            }
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
