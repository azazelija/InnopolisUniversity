package lesson3.task1;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 18395435
 * @created_at 29/04/2020 - 13:19
 * @project InnopolisUniversity
 */
public class MathBox<T extends Number> {
    List<T> arr;

    public MathBox(List<Number> arr) {
        this.arr = arr;
    }

    public T summator() {

        return arr.stream()
                .map((x, y) ->())
                .get();
    }

    public List<T> splitter(int del) {
        return arr.stream()
                .map((x) -> (x/del))
                .collect(Collectors.toList());
    }

    public boolean deleteIntegerValue(int value) {
        List<T> arr2 = arr.stream()
                .filter(Integer.class::isInstance)
                .collect(Collectors.toList());
        return arr.removeAll(arr2);
    }
}
