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
    private Map<UUID, T> pets;

    public PetCollection() {
        pets = new HashMap<>();
    }

    /**
     * Добавить животное в коллекция
     * @param pet
     * @return true - добавлен
     *         false - животное уже присутствует
     */
    public boolean addPet(T pet) {
        if (pets.containsKey(pet.getId()))
            return false;
        pets.put(pet.getId(), pet);
        return true;
    }

    /**
     * Поиск по кличке
     * @param name
     * @return список животных по данной кличке, иначе null
     */
    public List<T> findByName(String name) {
        List<T> list =
                pets.values().stream()
                .filter(t -> t.getName().equals(name))
                .collect(Collectors.toList());

        return list.size() == 0 ? null : list;
    }

    /**
     * Изменение параметров животного
     * @param id нужного животного
     * @param pet новые поля
     */
    public void changePet(UUID id, T pet) {
        if (pets.keySet().stream().noneMatch(k -> k.equals(id)))
            pets.put(id, pet);
        pets.entrySet()
                .stream()
                .filter(k -> k.getKey().equals(id))
                .findFirst()
                .ifPresent(e -> e.getValue()
                .setName(pet.getName())
                .setOwner(pet.getOwner())
                .setWeight(pet.getWeight()));
    }

    /**
     * Сортировка коллекции по полям: владелец, кличка, вес
     * @return отсортированная коллекция
     */
    public List<T> sort() {
        return  pets.values().stream()
                .sorted(
                Comparator.comparing(Pet::getOwner)
                        .thenComparing(Pet::getName)
                        .thenComparing(Pet::getWeight)
        ).collect(Collectors.toList());
    }

}
