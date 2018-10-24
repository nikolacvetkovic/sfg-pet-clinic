package xyz.riocode.guruspring.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.riocode.guruspring.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
