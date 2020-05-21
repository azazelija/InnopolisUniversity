package lesson10;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 15:03
 * @project InnopolisUniversity
 */
public class ChatServerApi {
    static int port = 8000;

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        //TODO: SOCket
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
    }

}
