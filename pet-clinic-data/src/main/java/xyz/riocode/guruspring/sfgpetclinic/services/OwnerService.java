package xyz.riocode.guruspring.sfgpetclinic.services;

import xyz.riocode.guruspring.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
