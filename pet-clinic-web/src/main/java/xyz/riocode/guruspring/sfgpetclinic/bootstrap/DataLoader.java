package xyz.riocode.guruspring.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;
import xyz.riocode.guruspring.sfgpetclinic.model.Vet;
import xyz.riocode.guruspring.sfgpetclinic.services.OwnerService;
import xyz.riocode.guruspring.sfgpetclinic.services.VetService;
import xyz.riocode.guruspring.sfgpetclinic.services.map.OwnerServiceMap;
import xyz.riocode.guruspring.sfgpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader() {
        this.vetService = new VetMapService();
        this.ownerService = new OwnerServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Michael");
        o1.setLastName("Weston");

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Fiona");
        o2.setLastName("Gienanne");

        ownerService.save(o2);

        System.out.println("Owners are added...");

        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Sam");
        v1.setLastName("Axe");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Jessie");
        v2.setLastName("Porter");

        vetService.save(v2);

        System.out.println("Vets are loaded...");

    }
}
