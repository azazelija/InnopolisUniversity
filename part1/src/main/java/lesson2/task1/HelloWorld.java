package lesson2.task1;

/**
 * @author Voronova_Khristina
 * @created_at 25/04/2020 - 21:20
 * @project InnopolisUniversity
 */

public class HelloWorld {
    public static void main(String[] args) {
        try {
            nullString().charAt(0);
            stringArrayDoubleSize()[2].getBytes();
            throw new MyException();
        }
        catch (NullPointerException e) {
            System.out.println("processing NullPointerException");
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("processing ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
        catch (MyException e) {
            System.out.println("processing MyException");
            e.printStackTrace();
        }
    }

    private static class MyException extends RuntimeException {}

    /**
     * Метод возвращает null
     * @return null
     */
    private static String nullString () {
        return null;
    }

    /**
     * Метод возвращает массив строк длиной 2
     * @return массив строк
     */
    private static String[] stringArrayDoubleSize() {
        return new String[2];
    }
}
