package lesson5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 04/05/2020 - 11:03
 * @project InnopolisUniversity
 */
class PetCollectionTest {
    Pet pet;
    Person owner;
    PetCollection<Pet> collection;
    Pet changedPet;

    @BeforeEach
    void setUp() {
        collection = new PetCollection<>();

        owner = new Person("Kris", 15, Person.Sex.FEMALE);
        pet = new Pet("Pushok", owner, 12);
        changedPet = new Pet("Pushok2", owner, 15);
    }

    @Test
    void addPet() {
        assertTrue(collection.addPet(pet));
        assertFalse(collection.addPet(pet));
    }

    @Test
    void findByName() {
        collection.addPet(pet);
        assertNotNull(collection.findByName("Pushok"));
    }

    @Test
    void changePet() {
        collection.addPet(pet);

        collection.changePet(pet.getId(), changedPet);
        assertNotNull(collection.findByName("Pushok2"));
    }

    @Test
    void sort() {
        collection.addPet(pet);
        collection.addPet(changedPet);
        assertNotNull(collection.sort());
    }
}