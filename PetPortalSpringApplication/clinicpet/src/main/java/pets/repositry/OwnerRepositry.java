package pets.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pets.models.Owner;


/**
 * Repository class for <code>Owner</code> domain objects All method names are compliant with Spring Data naming
 * 
 * @author Noella Noronha
 * @author Arpit Dubey
 * @author Harshit Jain
 * @author Nidhi Dewangan
 * @author Ankita Hundet
 */
public interface OwnerRepositry extends JpaRepository<Owner, Integer> {

	@Query("from Owner where ownerid=:u")
	public Owner ownerLogin(@Param("u") int ownerid);

	@Query("from Owner where username=:u and password =:p")
	public Owner ownerLogin(@Param("u") String username,@Param("p") String password);

	
}
