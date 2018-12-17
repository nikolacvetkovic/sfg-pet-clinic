package xyz.riocode.guruspring.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.riocode.guruspring.sfgpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PetServiceMapTest {

    PetServiceMap petServiceMap;

    final Long ID = 1L;
    final String NAME = "Deni";

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(ID).name(NAME).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();

        assertEquals(1, pets.size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(ID);

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteByIdNullValue() {
        petServiceMap.deleteById(null);

        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(ID));

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void save() {
        petServiceMap.save(Pet.builder().id(2L).build());

        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(ID);

        assertEquals(ID, pet.getId());
        assertEquals(NAME, pet.getName());
    }
}