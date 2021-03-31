
package pets.repositry;

import java.util.Collection;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pets.models.Appointment;


/**
 * Repository class for <code>Appointment</code> domain objects All method names are compliant with Spring Data naming
 *
 * @author Noella Noronha
 * @author Arpit Dubey
 * @author Harshit Jain
 * @author Nidhi Dewangan
 * @author Ankita Hundet
 */


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


	@Query("from Appointment where pet_id =:ac")
	public List<Appointment> findAppointmentbyPetId(@Param("ac") int petid); 
	

	
	
//	Collection<Appointment> viewPetById(int petId);

   
  // void save(Appointment appointment) throws DataAccessException;


   // List<Appointment> findByPetId(Integer petId);

}

