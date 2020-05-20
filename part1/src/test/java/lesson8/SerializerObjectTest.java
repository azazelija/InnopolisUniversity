package lesson8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 01:53
 * @project InnopolisUniversity
 */
class SerializerObjectTest {

    Object object;

    SerializerObject serializerObject;

    String file;

    @BeforeEach
    void setUp() {
        object = new SomeObject();
        serializerObject = new SerializerObject();
        file = "src/test/java/lesson8/serializableObject";
    }

    @Test
    void serialize() {
        serializerObject.serialize(object, file);
    }

    @Test
    void deSerialize() {
        Object object = serializerObject.deSerialize(file);
        assertEquals(object, object);
    }
}