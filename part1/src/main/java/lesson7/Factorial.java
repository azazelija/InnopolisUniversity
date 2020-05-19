package lesson7;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 20:50
 * @project InnopolisUniversity
 */
public class Factorial {
    /**
     * Pool threads
     */
    private ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Контейнер, хранящий в себе вычисления фрактала для каждого числа
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
     *
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
     *
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

    /**
     * Подсчет при помощи создания новых потоков
     *
     * @param num
     * @param numOfThreads
     * @return факториал числа
     * @throws InterruptedException
     */
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

    /**
     * Подсчет паралельными стримами
     *
     * @param num
     * @return фрактал
     */
    public BigInteger countfactorialWithStream(int num) {
        return IntStream.rangeClosed(1, num)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }

    /**
     * Подсчет факториала несколькими потоками executorService
     * @param num
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public BigInteger countFactorialWithExecutorService(int num) throws ExecutionException, InterruptedException {
        final Factorial factorial = Factorial.getFactorial();
        Future<BigInteger> future4 = executor.submit(() -> factorial.countFactorialWithSave(num));
        Future<BigInteger> future5 = executor.submit(() -> factorial.countFactorialWithSave(num));
        Future<BigInteger> future6 = executor.submit(() -> factorial.countFactorialWithSave(num));
        Future<BigInteger> future7 = executor.submit(() -> factorial.countFactorialWithSave(num));

        return map.get(num);
    }
}
