package xyz.riocode.guruspring.sfgpetclinic.services;

import xyz.riocode.guruspring.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
