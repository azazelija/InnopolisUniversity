package lesson5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 18395435
 * @created_at 03/05/2020 - 16:00
 * @project InnopolisUniversity
 */
public class PetCollection<T extends Pet> {
    private List<T> pets;

    public PetCollection() {
        pets = new ArrayList<>();
    }

    public boolean addPet(T pet) {
        if (pets.contains(pet))
            return false;
        return pets.add(pet);
    }

    public List<T> findByName(String name) {
        return  pets.stream()
                .filter((p) -> p.getName().equals(name))
                .collect(Collectors.toList());
    }

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

    public List<T> sort() {
        return  pets.stream()
                .sorted(
                Comparator.comparing(Pet::getOwner)
                        .thenComparing(Pet::getName)
                        .thenComparing(Pet::getWeight)
        ).collect(Collectors.toList());
    }

}
