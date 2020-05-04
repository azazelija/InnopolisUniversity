package lesson5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 18395435
 * @created_at 03/05/2020 - 16:00
 * @project InnopolisUniversity
 */

/**
 * Картотека животных
 * @param <T> любые животные, наследуемые от класса Pet
 */
public class PetCollection<T extends Pet> {
    private List<T> pets;

    public PetCollection() {
        pets = new ArrayList<>();
    }

    /**
     * Добавить животное в коллекция
     * @param pet
     * @return true - добавлен
     *         false - животное уже присутствует
     */
    public boolean addPet(T pet) {
        if (pets.contains(pet))
            return false;
        return pets.add(pet);
    }

    /**
     * Поиск по кличке
     * @param name
     * @return список животных по данной кличке, иначе null
     */
    public List<T> findByName(String name) {
        List<T> list =
                pets.stream()
                .filter((p) -> p.getName().equals(name))
                .collect(Collectors.toList());

        return list.size() == 0 ? null : list;
    }

    /**
     * Изменение параметров животного
     * @param id нужного животного
     * @param pet новые поля
     */
    public void changePet(UUID id, T pet) {
        if (pets.stream().noneMatch(p -> p.getId().equals(id)))
            pets.add(pet);
        pets.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresent(t -> t
                .setName(pet.getName())
                .setOwner(pet.getOwner())
                .setWeight(pet.getWeight()));
    }

    /**
     * Сортировка коллекции по полям: владелец, кличка, вес
     * @return отсортированная коллекция
     */
    public List<T> sort() {
        return  pets.stream()
                .sorted(
                Comparator.comparing(Pet::getOwner)
                        .thenComparing(Pet::getName)
                        .thenComparing(Pet::getWeight)
        ).collect(Collectors.toList());
    }

}
