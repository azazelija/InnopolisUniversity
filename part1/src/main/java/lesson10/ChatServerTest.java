package lesson10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 18395435
 * @created_at 23/05/2020 - 02:00
 * @project InnopolisUniversity
 */
public class ChatServerTest {
    public static void main(String[] args) {
        ExecutorService server = Executors.newSingleThreadExecutor();
        server.execute(new ChatServer());

        ExecutorService clients = Executors.newFixedThreadPool(10);
        Client client = new Client("Sasha");
        clients.execute(client);
        clients.execute(new Client("Marina"));

        //TODO: не рботает прослушка клиентов
    }
}
