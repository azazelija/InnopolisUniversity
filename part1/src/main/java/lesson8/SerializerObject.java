package lesson8;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 00:29
 * @project InnopolisUniversity
 */
public class SerializerObject {

    Logger log  = Logger.getLogger(SerializerObject.class.getName());

    void serialize(Object object, String file) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {

            //todo создать прокси класс (декоратор?) с преодпреденными методами writeObject readObject
            Serializable objSerial = new ObjectSerializableProxy(object);

            objectOutputStream.writeObject(objSerial);
        }
        catch (IOException e) {
            log.log(Level.WARNING, "Ошибка при сериализации объекта", e);
        }

    }

    Object deSerialize(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

            return objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            log.log(Level.WARNING, "Ошибка при десериализации объекта", e);
            return null;
        }
    }
}
