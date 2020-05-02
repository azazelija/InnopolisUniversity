package lesson3;

import java.util.*;

/**
 * @author 18395435
 * @created_at 29/04/2020 - 14:46
 * @project InnopolisUniversity
 */
public class ObjectBox {

    private Collection<Object> collection;

    public boolean addObject(Object o) {
        return collection.add(o);
    }

    public boolean deleteObject(Object o) {
        return collection.remove(o);
    }
}
