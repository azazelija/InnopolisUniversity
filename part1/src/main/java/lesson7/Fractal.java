package lesson7;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 20:50
 * @project InnopolisUniversity
 */
public class Fractal {
    //poll-thread
    public ThreadPoolExecutor executor;
    //container
    Map<Integer, BigInteger> map = new ConcurrentHashMap<>();

    public Fractal() {
    }

//    public BigInteger countFractal(int num) {
//
//    }

    public synchronized void show() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " +i);
        }
    }

    public static void main(String[] args) {
        Fractal main = new Fractal();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                main.show();
            }
        };

        Thread t1 = new Thread(runnable, "Thread1");
        Thread t2 = new Thread(runnable, "Thread2");

        t1.start();
        t2.start();

    }


}
