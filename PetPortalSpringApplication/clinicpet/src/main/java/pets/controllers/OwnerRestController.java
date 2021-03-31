package pets.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pets.exception.ResourceNotFoundException;
import pets.models.Owner;
import pets.repositry.OwnerRepositry;
import pets.service.OwnerInterface;

/*
 *  Owner Controller section of the pet owner
 *  
 *  @author Arpit Dubey 
 *  @author Ankita Hundet
 *  @author Noella Noronha
 *  
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OwnerRestController {

	@Autowired
	private OwnerRepositry owner;
	
	// view all the owners present in the database
	@PostMapping("/petOwner")
	public List<Owner> showallowners()
	{
		return owner.findAll();
	}

	//@GetMapping("/petOwner/{ownerid}")
	public ResponseEntity<Owner> viewOwner(@PathVariable int ownerid)
	{
		Owner own = owner.findById(ownerid).orElseThrow(() -> new ResourceNotFoundException("owner not found"+ownerid));
		return ResponseEntity.ok(own);
	}
	
    /**
     * Custom handler for creating account for the owner.
     *
     * @requestbody object class of owner to insert details
     * 
     */
	
	@PostMapping("/petOwner/insert")
	public Owner addOwner(@RequestBody Owner owns)
	{
		return owner.save(owns);
	}
	
	
	@PutMapping("/update/{ownerid}")
	public ResponseEntity<Owner> updateOwner(@PathVariable int ownerid, @RequestBody Owner owns)
	{
		Owner  own= owner.findById(ownerid).orElseThrow(() -> new ResourceNotFoundException("owner not found"+ownerid));
		
		own.setFirstName(owns.getFirstName());
		own.setLastName(owns.getLastName());
		own.setAddress(owns.getAddress());
		own.setCity(owns.getCity());
		own.setPhone_no(owns.getPhone_no());
		
		Owner ownupt = owner.save(own);
		
		return ResponseEntity.ok(ownupt);
	}
	
    /**
     * Custom handler for displaying an owner.
     *
     * @param username and password of the owner in the database
     * @return object of the owner that contain personal details
     */
	@PutMapping("/login/{username}/{password}")
	public Owner loginUser(@PathVariable String username, @PathVariable String password)
	{
		System.out.println("user login");
		Owner o = owner.ownerLogin(username, password);
		return o;
	}
	
}
