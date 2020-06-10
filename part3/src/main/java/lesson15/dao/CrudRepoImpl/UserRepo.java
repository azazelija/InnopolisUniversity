package lesson15.dao.CrudRepoImpl;

import lesson15.dao.CrudRepository;
import lesson15.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:32
 * @project InnopolisUniversity
 */
public class UserRepo implements CrudRepository<User, Long> {

    private Connection connection;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public UserRepo(Connection connection) {
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
        String createQuery = "DROP TABLE IF EXISTS USER;" +
                "CREATE TABLE USER(id INT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "password VARCHAR(255), " +
                "position VARCHAR(255));";

        try (PreparedStatement createPreparedStatement = connection.prepareStatement(createQuery)) {
            createPreparedStatement.executeUpdate();
            connection.commit();
            log.info("User Table created");
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public <S extends User> S update(S var1) {
        String insertQuery = "INSERT INTO USER" + "(id, name, password, position) values" + "(?,?,?,?)";

        try (PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery)) {
            insertPreparedStatement.setLong(1, var1.getId());
            insertPreparedStatement.setString(2, var1.getUsername());
            insertPreparedStatement.setString(3, var1.getPassword());
            insertPreparedStatement.setString(4, var1.getPosition());
            insertPreparedStatement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }

        return var1;
    }

    @Override
    public User findById(Long var1) {

        User user = null;

        String selectQuery = "SELECT * FROM USER WHERE id = " + var1;

        try (PreparedStatement selectPreparedStatement = connection.prepareStatement(selectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery()) {

            user = new User();

            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPosition(rs.getString("position"));
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

        String deleteQuery = "DELETE FROM USER WHERE id = ?";

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
    public void delete(User var1) {

        deleteById(var1.getId());
    }

    @Override
    public void deleteAll() {

        String deleteQuery = "DELETE FROM USER";

        try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e) {
            log.error(e.getMessage());
        }

    }
}
