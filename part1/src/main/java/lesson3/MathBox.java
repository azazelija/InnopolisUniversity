package lesson3;

import java.util.*;

/**
 * @author 18395435
 * @created_at 29/04/2020 - 13:19
 * @project InnopolisUniversity
 */
public class MathBox<T extends Number> extends ObjectBox<T>{

    private Set<T> collection;

    public MathBox(List<T> arr) {
        collection = new HashSet<>();
        collection.addAll(arr);
    }

    /**
     * метод summator, возвращающий сумму всех элементов коллекции
     * @return сумма чисел
     */
    public Number summator() {
        double sum = 0.0;

        for(Number i : collection) {
            if (i instanceof Integer) {
                sum += (Integer) i;
            }
            if (i instanceof Double) {
                sum += (Double) i;
            }
            if (i instanceof Long) {
                sum += (Long) i;
            }
            if (i instanceof Float) {
                sum += (Float) i;
            }
        }
        return sum;
    }

    /**
     * метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
     * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления
     * @param del
     * @return новая коллекция
     */
    public Set<Number> splitter(int del) {
        Set<Number> set = new HashSet<>();
        for(Number i : collection) {
            if (i instanceof Integer) {
                set.add((Integer) i / del);
            }
            if (i instanceof Double) {
                set.add((Double) i / del);
            }
            if (i instanceof Long) {
                set.add((Long) i / del);
            }
            if (i instanceof Float) {
                set.add((Float) i / del);
            }
        }

        return set;
    }

    /**
     * метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его
     * @return boolean
     */
    public boolean deleteIntegerValue() {
        return collection.removeIf(Integer.class::isInstance);
    }

    public Set<T> getCollection() {
        return collection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(collection, mathBox.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "collection=" + collection +
                '}';
    }
}
