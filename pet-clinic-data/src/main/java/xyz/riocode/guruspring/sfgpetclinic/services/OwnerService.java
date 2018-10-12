package xyz.riocode.guruspring.sfgpetclinic.services;

import xyz.riocode.guruspring.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
