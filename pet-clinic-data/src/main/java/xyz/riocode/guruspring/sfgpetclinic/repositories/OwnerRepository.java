package xyz.riocode.guruspring.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
