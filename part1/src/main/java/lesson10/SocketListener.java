package lesson10;

import java.io.*;
import java.net.Socket;

/**
 * @author 18395435
 * @created_at 22/05/2020 - 00:02
 * @project InnopolisUniversity
 */
public class SocketListener implements Runnable {
    private Socket socket;

    private BufferedReader in;
    private BufferedWriter out;

    public SocketListener(Socket socket) {
        try {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection accepted.");
            while (!socket.isClosed()) {
                String message = in.readLine();
                out.write("Server reply - " + message + " - OK\n");
                out.flush();
            }
            System.out.println("Client disconnected");

            in.close();
            out.close();

            socket.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
