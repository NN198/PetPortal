package pets.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import pets.models.Owner;
import pets.models.Pet;
import pets.repositry.PetRepositry;
import pets.service.OwnerInterface;

/*
 *  Pet Controller section of the pet
 *
 *  @author Noella Noronha
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PetRestController {
	
	@Autowired
	private PetRepositry pet;
	
	// view pets containing the registered id
	@PostMapping("/pets/{petid}")
	public ResponseEntity<Pet> viewPetById(@PathVariable int petid)
	{
		Pet pets = pet.findById(petid).orElseThrow(() -> new ResourceNotFoundException("owner not found"+petid));
		return ResponseEntity.ok(pets);
	}
	
	
	// view all the pets present in the database
	@GetMapping("/pets")
	public List<Pet> viewPets()
	{	
		System.out.println("will show multiple pets");
		//List<Pet> pets = pet.findPetbyOwnerId(ownerid);
		return pet.findAll();
	}
	
	// view pets containing the registered owner id of that particular owner
	@GetMapping("/pets/{ownerid}")
	public List<Pet> viewPetByOwnerId(@PathVariable int ownerid)
	{	
		System.out.println("will show multiple pets");
		List<Pet> pets = pet.findPetbyOwnerId(ownerid);
		return pets;
	}
	
	
	// add pets using the specific owner id to the database 
	@PutMapping("/pets/add-pets/{ownerid}")
	public Pet addPet(@PathVariable int ownerid, @RequestBody Pet petdetail)
	{
		//Pet p = new Pet("cuddles",2,5,"dog");
		Owner o = new Owner();
		o.setOwnerid(ownerid);
		petdetail.setOwner(o);
		return pet.save(petdetail);
	}
	
	
	// edit pet details using pet id
	@PutMapping("/pets/{petid}")
	public ResponseEntity<Pet> updatePet(@PathVariable int petid, @RequestBody Pet petdetails)
	{
		Pet pets = pet.findById(petid).orElseThrow(() -> new ResourceNotFoundException("owner not found"+petid));
		
		pets.setName(petdetails.getName());
		pets.setAge(petdetails.getAge());
		pets.setCategory(petdetails.getCategory());
		pets.setWeight(petdetails.getWeight());
	    
	    
	    Pet petupt = pet.save(pets);
	    
	    return ResponseEntity.ok(petupt);
	    
	}
	
	// delete a pet based on their id 
	@DeleteMapping("/pets/{pid}")
	public ResponseEntity<Map<String,Boolean>> deletepetdetails(@PathVariable int pid)
	{
		System.out.println("Inside delete");
		Pet p1 = pet.findById(pid).orElseThrow(
				() -> new ResourceNotFoundException("Pet not found"));
		pet.delete(p1);
		Map<String,Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	

}
