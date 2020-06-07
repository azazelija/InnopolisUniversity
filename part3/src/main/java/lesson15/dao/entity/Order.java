package lesson15.dao.entity;

import java.util.Objects;

/**
 * @author 18395435
 * @created_at 07/06/2020 - 19:09
 * @project InnopolisUniversity
 */
public class Order {

    Long id;

    String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }
}
