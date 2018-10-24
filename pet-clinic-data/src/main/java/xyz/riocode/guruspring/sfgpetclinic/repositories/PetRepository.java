package xyz.riocode.guruspring.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.riocode.guruspring.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
