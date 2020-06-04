package lesson10;

import java.io.*;
import java.net.Socket;

/**
 * @author 18395435
 * @created_at 21/05/2020 - 23:43
 * @project InnopolisUniversity
 */
public class Client implements Runnable {

    private String name;
    private static final String HOST = "localhost";

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try (Socket clientSocket = new Socket(HOST, ChatServer.PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            while (!clientSocket.isClosed()) {
                out.write(reader.readLine() + System.lineSeparator());
                out.flush();

                String serverWord = in.readLine();
                System.out.println(serverWord);
            }

            out.write(name + " exit.");
            out.flush();

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public String getName() {
        return name;
    }
}
