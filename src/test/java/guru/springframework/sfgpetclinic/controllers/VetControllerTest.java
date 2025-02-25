package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

class VetControllerTest {
	
	VetService vetService;
	SpecialtyService specialtyService;
	VetController vetController;
	

	@BeforeEach
	void setUp() throws Exception {
		
		specialtyService = new SpecialityMapService();
		vetService = new VetMapService(specialtyService);
		vetController = new VetController(vetService);
		
		Vet vet1 = new Vet(1L,"joe", "buck", null);
		Vet vet2 = new Vet(2L,"joe", "buck", null);
		
		vetService.save(vet1);
		vetService.save(vet2);
	}

	@Test
	void testListVets() {
		Model model = new ModelMapImpl();
		String view = vetController.listVets(model);
		
		assertThat("vets/index").isEqualTo(view);
		Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
		
		assertThat(modelAttribute.size()).isEqualTo(2);
		
		
	}

}
