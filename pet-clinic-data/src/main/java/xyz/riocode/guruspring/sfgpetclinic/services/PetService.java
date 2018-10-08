package xyz.riocode.guruspring.sfgpetclinic.services;

import xyz.riocode.guruspring.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
