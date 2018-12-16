package xyz.riocode.guruspring.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import xyz.riocode.guruspring.sfgpetclinic.model.Pet;
import xyz.riocode.guruspring.sfgpetclinic.model.Visit;
import xyz.riocode.guruspring.sfgpetclinic.services.PetService;
import xyz.riocode.guruspring.sfgpetclinic.services.VisitService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;


    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void serAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model){
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/*/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result, Pet pet){
        if(result.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/" + pet.getOwner().getId();
        }
    }
}
