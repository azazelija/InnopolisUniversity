package lesson15.dao.CrudRepoImpl;

import lesson15.dao.CrudRepository;
import lesson15.dao.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:33
 * @project InnopolisUniversity
 */
public class OrderRepo implements CrudRepository<Order, Long> {

    private Connection connection;

    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    public OrderRepo(Connection connection) {
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
        String createQuery = "DROP TABLE IF EXISTS ORDERSTORE;" +
                "CREATE TABLE ORDERSTORE(id INT PRIMARY KEY, " +
                "address VARCHAR(255));";

        try (PreparedStatement createPreparedStatement = connection.prepareStatement(createQuery)) {
            createPreparedStatement.executeUpdate();
            connection.commit();
            log.trace("Order Table created");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public <S extends Order> S update(S var1) {
        String insertQuery = "INSERT INTO ORDERSTORE" + "(id, address) values" + "(?,?)";

        try (PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery)) {
            insertPreparedStatement.setLong(1, var1.getId());
            insertPreparedStatement.setString(2, var1.getAddress());
            insertPreparedStatement.executeUpdate();
            connection.commit();
            log.trace("UPDATE Order table");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return var1;
    }

    @Override
    public Order findById(Long var1) {

        Order user = null;

        String selectQuery = "SELECT * FROM ORDERSTORE WHERE id = " + var1;

        try (PreparedStatement selectPreparedStatement = connection.prepareStatement(selectQuery);
             ResultSet rs = selectPreparedStatement.executeQuery()) {

            user = new Order();

            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setAddress(rs.getString("address"));
            }
            connection.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return user;
    }

    @Override
    public void deleteById(Long var1) {

        String deleteQuery = "DELETE FROM ORDERSTORE WHERE id = ?";

        try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.setLong(1, var1);
            deletePreparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Order var1) {

        deleteById(var1.getId());
    }

    @Override
    public void deleteAll() {

        String deleteQuery = "DELETE FROM ORDERSTORE";

        try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
