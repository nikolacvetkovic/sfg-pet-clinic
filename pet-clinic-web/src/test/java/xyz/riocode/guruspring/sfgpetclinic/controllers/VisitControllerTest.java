package xyz.riocode.guruspring.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.riocode.guruspring.sfgpetclinic.model.Owner;
import xyz.riocode.guruspring.sfgpetclinic.model.Pet;
import xyz.riocode.guruspring.sfgpetclinic.services.PetService;
import xyz.riocode.guruspring.sfgpetclinic.services.VisitService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    VisitService visitService;
    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(visitController)
                .build();
    }

    @Test
    void initNewVisitForm() throws Exception {

        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());

        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));

    }

    @Test
    void processNewVisitForm() throws Exception {
        Owner owner = Owner.builder().id(3L).build();

        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).owner(owner).build());

        mockMvc.perform(post("/owners/1/pets/1/visits/new")
                        .param("id", "")
                        .param("date", "2018-06-26")
                        .param("description", "some description"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/3"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"));

        verify(visitService).save(any());

    }
}