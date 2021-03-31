package pets.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pets.models.Pet;


/**
 * Repository class for <code>Pet</code> domain objects All method names are compliant with Spring Data naming
 *
 * @author Noella Noronha
 * @author Arpit Dubey
 * @author Harshit Jain
 * @author Nidhi Dewangan
 * @author Ankita Hundet
 */
public interface PetRepositry extends JpaRepository<Pet, Integer> {

	@Query("from Pet where owner_id =:ac")
	public List<Pet> findPetbyOwnerId(@Param("ac")  int ownerid);

}
