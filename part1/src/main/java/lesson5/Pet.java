package lesson5;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 18395435
 * @created_at 03/05/2020 - 16:01
 * @project InnopolisUniversity
 */

/**
 * Базовая сущность питомца
 */
public class Pet {
    /**
     * Генерируемое значение id
     */
    private UUID id;

    /**
     * Кличка
     */
    private String name;

    /**
     * Владелец, класс Person
     */
    private Person owner;

    /**
     * Вес
     */
    private int weight;

    public Pet(String name, Person owner, int weight) {
        id = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public Person getOwner() {
        return owner;
    }

    public Pet setOwner(Person owner) {
        this.owner = owner;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Pet setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return weight == pet.weight &&
                Objects.equals(id, pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, weight);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
