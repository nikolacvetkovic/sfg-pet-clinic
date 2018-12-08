package xyz.riocode.guruspring.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;
import xyz.riocode.guruspring.sfgpetclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder){
//        dataBinder.setDisallowedFields("id");
//    }

//    @GetMapping({"", "/", "/index", "/index.html"})
//    public String listOwners(Model model){
//        model.addAttribute("owners", ownerService.findAll());
//
//        return "owners/index";
//    }

    @GetMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", new Owner());

        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable int ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(Long.valueOf(ownerId)));

        return modelAndView;
    }

    @GetMapping("")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty()){
            result.rejectValue("lastName", "notFound", "notFound");
            return "owners/findOwners";
        } else if(results.size() == 1){
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
}
