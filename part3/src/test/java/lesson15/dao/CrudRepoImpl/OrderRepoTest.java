package lesson15.dao.CrudRepoImpl;

import lesson15.dao.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 21:40
 * @project InnopolisUniversity
 */
class OrderRepoTest {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    @Mock
    private Connection connection;

    @Mock
    private OrderRepo orderRepo;

    @BeforeEach
    void setUp() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            orderRepo = new OrderRepo(connection);

            orderRepo.create();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        orderRepo.create();
    }

    @Test
    void update() {
        Order order = new Order();
        order.setId(1l);
        order.setAddress("Moscow");

        orderRepo.update(order);
    }

    @Test
    void findById() {

        Order order = new Order();
        order.setId(1l);
        order.setAddress("Moscow");

        orderRepo.update(order);
        Order orderRepoById = orderRepo.findById(1l);
        assertEquals(orderRepoById, order);
    }

    @Test
    void deleteById() {
        update();

        orderRepo.deleteById(1l);
        assertNull(orderRepo.findById(1l).getAddress());
    }

    @Test
    void delete() {
        Order order = new Order();
        order.setId(1l);
        order.setAddress("Moscow");

        orderRepo.update(order);

        orderRepo.delete(order);
        assertNull(orderRepo.findById(1l).getAddress());
    }

    @Test
    void deleteAll() {

        Order order = new Order();
        order.setId(1l);
        order.setAddress("Moscow");

        Order order2 = new Order();
        order2.setId(2l);
        order2.setAddress("France");


        orderRepo.update(order);
        orderRepo.update(order2);

        orderRepo.deleteAll();
        assertNull(orderRepo.findById(1l).getAddress());
        assertNull(orderRepo.findById(2l).getAddress());
    }

}