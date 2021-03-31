package pets.repositry;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pets.models.Vets;


/**
 * Repository class for <code>Vets</code> domain objects All method names are compliant with Spring Data naming
 *
 * @author Noella Noronha
 * @author Arpit Dubey
 * @author Harshit Jain
 * @author Nidhi Dewangan
 * @author Ankita Hundet
 */

@Repository
public interface VetsRepository extends JpaRepository<Vets, Integer> {

	
}


