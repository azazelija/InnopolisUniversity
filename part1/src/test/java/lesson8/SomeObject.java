package lesson8;

import lesson7.Factorial;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 11:14
 * @project InnopolisUniversity
 */
public class SomeObject implements Serializable {

    public boolean field1 = true;
    public String field2 = "Okey?";
    private Factorial factorial = Factorial.getFactorial();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return field1 == that.field1 &&
                Objects.equals(field2, that.field2) &&
                Objects.equals(factorial, that.factorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, factorial);
    }
}
