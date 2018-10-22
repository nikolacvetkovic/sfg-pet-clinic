package xyz.riocode.guruspring.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;
import xyz.riocode.guruspring.sfgpetclinic.model.PetType;
import xyz.riocode.guruspring.sfgpetclinic.model.Vet;
import xyz.riocode.guruspring.sfgpetclinic.services.OwnerService;
import xyz.riocode.guruspring.sfgpetclinic.services.PetTypeService;
import xyz.riocode.guruspring.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService) {

        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Gienanne");

        ownerService.save(o2);

        System.out.println("Owners are added...");

        Vet v1 = new Vet();
        v1.setFirstName("Sam");
        v1.setLastName("Axe");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jessie");
        v2.setLastName("Porter");

        vetService.save(v2);

        System.out.println("Vets are loaded...");

    }
}
