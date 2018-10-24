package xyz.riocode.guruspring.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
