package lesson12;

import lesson12.MetaSpace.TestPermGenMetaSpaceOOM;
import org.junit.jupiter.api.Test;

/**
 * @author 18395435
 * @created_at 28/05/2020 - 23:16
 * @project InnopolisUniversity
 */
class TestPermGenMetaSpaceOOMTest {

    //-XX:MaxMetaspaceSize=32m

    @Test
    void createPermGenOOM() {
        TestPermGenMetaSpaceOOM.createPermGenOOM();

    }
}