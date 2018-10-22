package xyz.riocode.guruspring.sfgpetclinic.services.map;

import xyz.riocode.guruspring.sfgpetclinic.model.Speciality;
import xyz.riocode.guruspring.sfgpetclinic.services.SpecialtiesServices;

import java.util.Set;

public class SpecialtiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtiesServices {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
