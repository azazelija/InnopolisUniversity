package lesson7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 20:59
 * @project InnopolisUniversity
 */
class FactorialTest{

    Factorial factorial;

    @BeforeEach
    void setUp() {
        this.factorial = Factorial.getFactorial();
    }

    @Test
    void countFactorialWithSave() {

        Instant start = Instant.now();
        factorial.countFactorialWithSave(50000);
        System.out.printf("%-10s Time first iter saveMap\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countFactorialWithSave(50000);
        System.out.printf("%-10s Time second iter saveMap\n", Duration.between(start, Instant.now()));

        assertEquals(BigInteger.valueOf(24), factorial.countFactorialWithSave(4));
    }

    @Test
    void countFactorialWithCycle() {

        Instant start = Instant.now();
        factorial.countFactorialWithCycle(50000);
        System.out.printf("%-10s Time first iter cycle\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countFactorialWithCycle(50000);
        System.out.printf("%-10s Time second iter cycle\n", Duration.between(start, Instant.now()));

        assertEquals(BigInteger.valueOf(24), factorial.countFactorialWithCycle(4));
    }

    @Test
    void countFactorialWithThreads() throws InterruptedException {

        Instant start = Instant.now();
        factorial.countFactorialWithThreads(50000, 2);
        System.out.printf("%-10s Time first iter 2 threads\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countFactorialWithThreads(50000, 2);
        System.out.printf("%-10s Time second iter 2 threads\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countFactorialWithThreads(50000, 20);
        System.out.printf("%-10s Time first iter 20 threads\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countFactorialWithThreads(50000, 20);
        System.out.printf("%-10s Time second iter 20 threads\n", Duration.between(start, Instant.now()));

        assertEquals(BigInteger.valueOf(24), factorial.countFactorialWithThreads(4, 2));
        assertEquals(factorial.countFactorialWithThreads(3000, 2), factorial.countFactorialWithSave(3000));
    }

    @Test
    void countfactorialWithStream() {
        Instant start = Instant.now();
        factorial.countfactorialWithStream(50000);
        System.out.printf("%-10s Time second iter stream\n", Duration.between(start, Instant.now()));

        start = Instant.now();
        factorial.countfactorialWithStream(50000);
        System.out.printf("%-10s Time second iter stream\n", Duration.between(start, Instant.now()));

        assertEquals(BigInteger.valueOf(24), factorial.countfactorialWithStream(4));
    }

    @Test
    void countFactorialWithExecutorService() throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        factorial.countFactorialWithExecutorService(50000);
        System.out.printf("%-10s Time first iter executer\n", Duration.between(start, Instant.now()));

        assertEquals(BigInteger.valueOf(24), factorial.countFactorialWithExecutorService(4));
    }
}