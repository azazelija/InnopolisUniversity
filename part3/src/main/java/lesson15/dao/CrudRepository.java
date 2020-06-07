package lesson15.dao;

import java.util.Optional;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:10
 * @project InnopolisUniversity
 */
public interface CrudRepository<T, ID> {
    void create();

    <S extends T> S update(S var1);

    T findById(ID var1);

    void deleteById(ID var1);

    void delete(T var1);

    void deleteAll();
}
