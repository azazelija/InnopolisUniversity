package lesson8;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 00:29
 * @project InnopolisUniversity
 */
public class SerializerObject {

    Logger log = Logger.getLogger(SerializerObject.class.getName());

    private Object object;

    void serialize(Object object, String file) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            this.object = object;

            writer.write("{\n\"class\": \"" + object.getClass().toString() + "\",\n");

            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                writer.write("\"" + fields[i].getName() + "\": {\n\t" +
                        "\"type\": " + "\"" + fields[i].getType() + "\",\n\t" +
                        "\"value\": " + "\"" + fields[i].get(object) + "\"\n\t}");
                if (i == fields.length - 1) {
                    writer.write("\t\n");
                } else
                    writer.write(",\t\n");
            }
            writer.write("}");
        } catch (IOException | IllegalAccessException e) {
            log.log(Level.WARNING, "Ошибка при сериализации объекта", e);
        }

    }

    Object deSerialize(String file) {
        try {
            return object;
        } catch (Exception e) {
            log.log(Level.WARNING, "Ошибка при десериализации объекта", e);
            return null;
        }
    }
}
