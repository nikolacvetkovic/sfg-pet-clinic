package xyz.riocode.guruspring.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import xyz.riocode.guruspring.sfgpetclinic.model.PetType;
import xyz.riocode.guruspring.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public PetType findById(Long id) {
        return null;
    }
}
