package lesson2.task2;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Voronova_Khristina
 * @created_at 27/04/2020 - 20:45
 * @project InnopolisUniversity
 */
public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        example(n);
    }

    /**
     * Метод генерируется случайное число k
     * Если оно отрицательно, выбрасывает исключение NPE
     * Для каждого числа вычисляется его квадратный корень q
     * Если целая часть q равна k, печатает k
     * @param n количество итераций
     */
    public static void example(int n) {
        while (n-- >= 0) {
            Double k = new Random().ints().asDoubleStream().findFirst().getAsDouble();

            if (k < 0) throw new NullPointerException();

            Integer qCeil = new Double(Math.sqrt(k)).intValue();
            if (k.intValue() == (qCeil * qCeil)) {
                System.out.println(k);
            }
        }
    }
}
