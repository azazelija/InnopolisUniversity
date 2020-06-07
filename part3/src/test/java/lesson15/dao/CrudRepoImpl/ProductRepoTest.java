package lesson15.dao.CrudRepoImpl;

import lesson15.dao.entity.Product;
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
 * @created_at 07/06/2020 - 21:23
 * @project InnopolisUniversity
 */
class ProductRepoTest {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    @Mock
    private Connection connection;

    @Mock
    private ProductRepo productRepo;

    @BeforeEach
    void setUp() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            productRepo = new ProductRepo(connection);

            productRepo.create();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create() {
        productRepo.create();
    }

    @Test
    void update() {
        Product product = new Product();
        product.setId(1l);
        product.setLabel("Moloko");

        productRepo.update(product);
    }

    @Test
    void findById() {

        Product product = new Product();
        product.setId(1l);
        product.setLabel("Moloko");

        productRepo.update(product);
        Product productRepoById = productRepo.findById(1l);
        assertEquals(productRepoById, product);
    }

    @Test
    void deleteById() {
        update();

        productRepo.deleteById(1l);
        assertNull(productRepo.findById(1l).getLabel());
    }

    @Test
    void delete() {
        Product product = new Product();
        product.setId(1l);
        product.setLabel("Moloko");

        productRepo.update(product);

        productRepo.delete(product);
        assertNull(productRepo.findById(1l).getLabel());
    }

    @Test
    void deleteAll() {

        Product product = new Product();
        product.setId(1l);
        product.setLabel("Moloko");

        Product product2 = new Product();
        product2.setId(2l);
        product2.setLabel("Kefir");


        productRepo.update(product);
        productRepo.update(product2);

        productRepo.deleteAll();
        assertNull(productRepo.findById(1l).getLabel());
        assertNull(productRepo.findById(2l).getLabel());
    }
}