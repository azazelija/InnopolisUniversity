package lesson10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 22/05/2020 - 00:22
 * @project InnopolisUniversity
 */
class ChatServerTest {
    ExecutorService executorService = Executors.newCachedThreadPool();

    List<Client> clientList;
    ChatServer chatServer;

    @BeforeEach
    void setUp() {
        clientList = new ArrayList<>();
        chatServer = new ChatServer();

        clientList.add(new Client());
    }

    @Test
    void serverTest() throws InterruptedException {
        executorService.execute(chatServer);
        for (Client client : clientList) {
            executorService.execute(client);
        }
        executorService.shutdown();
    }
}