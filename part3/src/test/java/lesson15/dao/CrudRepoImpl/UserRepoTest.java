package lesson15.dao.CrudRepoImpl;

import lesson15.dao.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:56
 * @project InnopolisUniversity
 */
class UserRepoTest {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    @Mock
    private Connection connection;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            userRepo = new UserRepo(connection);

            userRepo.create();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        userRepo.create();
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1l);
        user.setUsername("Marina");
        user.setPassword("12345");
        user.setPosition("Driver");

        userRepo.update(user);
    }

    @Test
    void findById() {

        User user = new User();
        user.setId(1l);
        user.setUsername("Marina");
        user.setPassword("12345");
        user.setPosition("Driver");

        userRepo.update(user);
        User userFromQuery = userRepo.findById(1l);
        assertEquals(userFromQuery, user);
    }

    @Test
    void deleteById() {
        update();

        userRepo.deleteById(1l);
        assertNull(userRepo.findById(1l).getUsername());
    }

    @Test
    void delete() {
        User user = new User();
        user.setId(1l);
        user.setUsername("Marina");
        user.setPassword("12345");
        user.setPosition("Driver");

        userRepo.update(user);

        userRepo.delete(user);
        assertNull(userRepo.findById(1l).getUsername());
    }

    @Test
    void deleteAll() {

        User user = new User();
        user.setId(1l);
        user.setUsername("Marina");
        user.setPassword("12345");
        user.setPosition("Driver");

        User user2 = new User();
        user2.setId(2l);
        user2.setUsername("Sasha");
        user2.setPassword("123456");
        user2.setPosition("Admin");

        userRepo.update(user);
        userRepo.update(user2);

        userRepo.deleteAll();
        assertNull(userRepo.findById(1l).getUsername());
        assertNull(userRepo.findById(2l).getUsername());
    }
}