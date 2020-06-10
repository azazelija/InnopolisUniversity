package lesson15.dao.CrudRepoImpl;

import lesson15.dao.CrudRepository;
import lesson15.dao.entity.Product;
import lesson15.dao.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:33
 * @project InnopolisUniversity
 */
public class ProductRepo implements CrudRepository<Product, Long> {

    private Connection connection;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public ProductRepo(Connection connection) {
        try {
            this.connection = connection;
            connection.setAutoCommit(false);
            log.info("Connection accepted");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void create() {
        String createQuery = "DROP TABLE IF EXISTS PRODUCT;" +
                "CREATE TABLE PRODUCT(id INT PRIMARY KEY, " +
                "label VARCHAR(255));";

        String createQueryForLogger = "DROP TABLE IF EXISTS LOGS;" +
                "CREATE TABLE LOGS(userid VARCHAR(255), " +
                "message VARCHAR(255));";

        try (PreparedStatement createPreparedStatement = connection.prepareStatement(createQuery);
        PreparedStatement preparedStatement = connection.prepareStatement(createQueryForLogger)) {
            createPreparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            connection.commit();
            log.info("Product Table created");
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public <S extends Product> S update(S var1) {
        String insertQuery = "INSERT INTO PRODUCT" + "(id, label) values" + "(?,?)";

        try (PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery)) {
            insertPreparedStatement.setLong(1, var1.getId());
            insertPreparedStatement.setString(2, var1.getLabel());
            insertPreparedStatement.executeUpdate();
            connection.commit();
            log.info("Product table UPDATED");
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }

        return var1;
    }

    @Override
    public Product findById(Long var1) {

        Product user = null;

        String selectQuery = "SELECT * FROM PRODUCT WHERE id = " + var1;

        try (PreparedStatement selectPreparedStatement = connection.prepareStatement(selectQuery);
             ResultSet rs = selectPreparedStatement.executeQuery()) {

            user = new Product();

            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setLabel(rs.getString("label"));
            }
            connection.commit();
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }

        return user;
    }

    @Override
    public void deleteById(Long var1) {

        String deleteQuery = "DELETE FROM PRODUCT WHERE id = ?";

        try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.setLong(1, var1);
            deletePreparedStatement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Product var1) {

        deleteById(var1.getId());
    }

    @Override
    public void deleteAll() {

        String deleteQuery = "DELETE FROM PRODUCT";

        try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }

    }
}
