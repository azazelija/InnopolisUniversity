package lesson7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 20:50
 * @project InnopolisUniversity
 */
public class Factorial{
    //poll-thread
    public ThreadPoolExecutor executor;

    /**
     *  Контейнер, хранящий в себе вычисления фрактала для каждого числа
     */
    private static Map<Integer, BigInteger> map;

    private static Factorial factorial;

    private Factorial() {
    }

    public static Factorial getFactorial() {
        if (factorial == null) {
            map = new ConcurrentHashMap<>();
            return new Factorial();
        }
        return factorial;
    }

    /**
     * Подсчет факторила при помощи цикла с сохранением промежуточных значений
     * @param num
     * @return
     */
    public BigInteger countFactorialWithSave(int num) {
        BigInteger res = BigInteger.ONE;

        //если значение уже подсчитано
        if (map.containsKey(num))
            return map.get(num);

        for (int i = 1; i <= num; i++) {
            if (map.containsKey(num)) {
                res = map.get(i);
                continue;
            }
            res = res.multiply(BigInteger.valueOf(i));
            map.put(i, res);
        }
        return res;
    }

    /**
     * Подсчет простым циклом
     * @param num
     * @return
     */
    public BigInteger countFactorialWithCycle(int num) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public BigInteger countFactorialWithThreads(int num, int numOfThreads) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        final Factorial factorial = Factorial.getFactorial();

        for (int i = 0; i < numOfThreads; i++) {
            threadList.add(new Thread(() -> factorial.countFactorialWithSave(num)));
        }

        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }

        return map.get(num);
    }

    public BigInteger countfactorialWithStream(int num) {
        return IntStream.rangeClosed(1, num)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }
}
