package lesson3;

import java.util.*;

/**
 * @author 18395435
 * @created_at 29/04/2020 - 14:46
 * @project InnopolisUniversity
 */
public class ObjectBox<T> {

    private Collection<T> collection;

    public ObjectBox(Collection<T> collection) {
        this.collection = collection;
    }

    public ObjectBox() {
        collection = new ArrayList<>();
    }

    public boolean addObject(T o) {
        return collection.add(o);
    }

    public boolean deleteObject(T o) {
        return collection.remove(o);
    }
}
