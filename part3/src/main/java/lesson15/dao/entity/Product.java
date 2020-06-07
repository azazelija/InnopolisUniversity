package lesson15.dao.entity;

import java.util.Objects;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:09
 * @project InnopolisUniversity
 */
public class Product {

    Long id;

    String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(label, product.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}
