package xyz.riocode.guruspring.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import xyz.riocode.guruspring.sfgpetclinic.model.Speciality;
import xyz.riocode.guruspring.sfgpetclinic.model.Vet;
import xyz.riocode.guruspring.sfgpetclinic.services.SpecialityService;
import xyz.riocode.guruspring.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialities().size() > 0){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId() == null){
                        Speciality savedSpecialty = specialityService.save(speciality);
                        speciality.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
