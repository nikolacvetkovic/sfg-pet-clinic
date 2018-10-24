package xyz.riocode.guruspring.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.riocode.guruspring.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
