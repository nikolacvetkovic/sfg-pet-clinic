package xyz.riocode.guruspring.sfgpetclinic.services;

import xyz.riocode.guruspring.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findById(Long id);
}
