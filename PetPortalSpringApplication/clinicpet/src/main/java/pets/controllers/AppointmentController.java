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
import org.springframework.web.bind.annotation.RestController;

import pets.exception.ResourceNotFoundException;
import pets.models.Appointment;
import pets.models.Owner;
import pets.models.Pet;
import pets.repositry.AppointmentRepository;


/**
 * Appointment Controller section for managing pet's appointments with the vet
 * 
 * @author Nidhi Dewangan
 * @author Harshit Jain
 * 
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	 // get all appointments in the database
	@GetMapping("/Appointments")
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}
	
	
	
	// get  appointments from vet id 
	//@GetMapping("/Appointments/{id}")
	public ResponseEntity<Appointment> getAppointmentsById(@PathVariable int id) {
		Appointment appointments = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("appointment "
						+ "not exist with id :" + id));
		return ResponseEntity.ok(appointments);
	}
	
	// get appointments from petid
	@GetMapping("/Appointments/{petid}") 
	public List<Appointment> getAppointmentByPetId(@PathVariable int petid)
	{	
		System.out.println("will show multiple appointments by single pet");
		List<Appointment> appointment = appointmentRepository.findAppointmentbyPetId(petid);
		return appointment;
	}
	
	// appointments from appointment id 
	@PostMapping("/Appointments")
	public Appointment createAppointments(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	// appointments from pet id 
	@PutMapping("/Appointments/add-Appointments/{petid}")
	public Appointment createAppointmentsfrompetid(@PathVariable int petid,
			@RequestBody Appointment appointment)
	{
		
		Pet o = new Pet();
		o.setPetid(petid);
		appointment.setPet(o);
		return appointmentRepository.save(appointment);
	} 
	
	@PutMapping("/Appointments/{id}")
	public ResponseEntity<Appointment> updateAppointments(@PathVariable int id, @RequestBody Appointment appointment) {
		Appointment appointments11 = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id :" + id));

		
		appointments11.setAppointmentdate(appointment.getAppointmentdate());
		appointments11.setDescription(appointment.getDescription());
		appointments11.setDoctorname(appointment.getDoctorname());
		appointments11.setStarttime(appointment.getStarttime());
		appointments11.setEndtime(appointment.getEndtime());
		
	

		Appointment updatedAppointment = appointmentRepository.save(appointments11);
		return ResponseEntity.ok(updatedAppointment);
	}
			
	
	
	
	
		@DeleteMapping("/Appointments/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAppointments(@PathVariable int id) {
			System.out.println("Now Inside delete");
			Appointment appointment = appointmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id :" + id));

			appointmentRepository.delete(appointment);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}	
		
		
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


