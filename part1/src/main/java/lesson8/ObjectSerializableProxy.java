package lesson8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 00:50
 * @project InnopolisUniversity
 */
public class ObjectSerializableProxy implements Serializable{

    private Object object;

    public ObjectSerializableProxy(Object object) {
        this.object = object;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            out.writeObject(field);
        }

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        List<Object> objectList = new ArrayList<>();
        while (in.available() > 0) {
            objectList.add(in.readObject());
        }
    }
}
