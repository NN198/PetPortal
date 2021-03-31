package pets.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pets.exception.ResourceNotFoundException;
import pets.models.Vets;

import pets.repositry.VetsRepository;

/*
 * Vet Controller section of the veterinarian
 * 
 * @author Harshit Jain
 * @author Nidhi Dewangan
 *
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VetsController {

	@Autowired
	private VetsRepository VetsRepository;

	// get all employees
	@GetMapping("/Vets")
	public List<Vets> getAllVets() {
		return VetsRepository.findAll();
	}
	

	// create vets rest api 
	@PostMapping("/Vets")
	public Vets createVets(@RequestBody Vets vets) {
		return VetsRepository.save(vets);
	}

	// get employee by id rest api

	@GetMapping("/Vets/{id}")
	public ResponseEntity<Vets> getVetsById(@PathVariable int id) {
		Vets vets = VetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vet not exist with id :" + id));
		return ResponseEntity.ok(vets);
	}

	// update employee rest api

	@PutMapping("/Vets/{id}")
	public ResponseEntity<Vets> updateVets(@PathVariable int id, @RequestBody Vets vets) {
		Vets vets11 = VetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vetenarian not exist with id :" + id));

		vets11.setFirstName(vets.getFirstName());
		vets11.setLastName(vets.getLastName());
		vets11.setSpecialties(vets.getSpecialties());
		vets11.setExperience(vets.getExperience());
		vets11.setPrice(vets.getPrice());

		Vets updatedEmployee = VetsRepository.save(vets11);
		return ResponseEntity.ok(updatedEmployee);
	}

	// delete employee rest api
	@DeleteMapping("/Vets/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVets(@PathVariable int id) {
		Vets vets = VetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vetenarian not exist with id :" + id));

		VetsRepository.delete(vets);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
