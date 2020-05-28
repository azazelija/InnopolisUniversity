package lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author 18395435
 * @created_at 28/05/2020 - 22:51
 * @project InnopolisUniversity
 */
public class JVMExercise {

    private static final int LOOP_COUNT = 100_000_000;
    private static final ArrayList list = new ArrayList(100);

    public static void main(String[] args) {
        //-XX:+UseSerialGC -Xmx100m
        heap();
    }

    private static void heap() {
        Random random = new Random();
        for (int i = 0; i < LOOP_COUNT; i++) {
            String str = "" + random.nextInt();
            str.intern();
            list.add(str);
            if (i % 100 == 0) {
                list.remove(0);
            }
        }
        System.out.println(list.size());
    }
}
