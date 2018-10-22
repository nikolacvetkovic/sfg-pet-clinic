package xyz.riocode.guruspring.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.riocode.guruspring.sfgpetclinic.model.*;
import xyz.riocode.guruspring.sfgpetclinic.services.OwnerService;
import xyz.riocode.guruspring.sfgpetclinic.services.PetTypeService;
import xyz.riocode.guruspring.sfgpetclinic.services.SpecialityService;
import xyz.riocode.guruspring.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        o1.setAddress("123 Brickerel");
        o1.setCity("Miami");
        o1.setTelephone("121212121");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        mikesPet.setOwner(o1);
        o1.getPets().add(mikesPet);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Gienanne");
        o2.setAddress("123 Brickerel");
        o2.setCity("Miami");
        o2.setTelephone("3232323232");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(o2);
        o2.getPets().add(fionasCat);

        ownerService.save(o2);

        System.out.println("Owners are added...");

        Vet v1 = new Vet();
        v1.setFirstName("Sam");
        v1.setLastName("Axe");
        v1.getSpecialities().add(radiology);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jessie");
        v2.setLastName("Porter");
        v2.getSpecialities().add(surgery);

        vetService.save(v2);

        System.out.println("Vets are loaded...");
    }
}
