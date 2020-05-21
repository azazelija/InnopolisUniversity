package lesson10;

import java.io.*;
import java.net.Socket;

/**
 * @author 18395435
 * @created_at 21/05/2020 - 23:43
 * @project InnopolisUniversity
 */
public class Client implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedReader in;
    private PrintWriter out;

    @Override
    public void run() {
        try {
            clientSocket = new Socket("localhost", ChatServer.PORT);

            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));

            out.write(reader.readLine());
            String serverWord = in.readLine();

            System.out.println(serverWord);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
