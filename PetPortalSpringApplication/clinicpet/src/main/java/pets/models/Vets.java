
package pets.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

/*
 *  Java Bean object representing Veterinarian business login
 *  @author Harshit Jain 
 *  @author Nidhi Dewangan
 * 
 */
@Entity	
@Table(name = "Vets")
public class Vets extends Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "specialties")
	private String specialties;
	
	@Column(name = "experience")
	private int experience;
	

	@Column(name = "price")
	private float price;
	
	public Vets() {
		super();
	}

	public Vets(String firstName, String lastName, int id, String specialties, int experience, float price) {
		super(firstName, lastName);
		this.id = id;
		this.specialties = specialties;
		this.experience = experience;
		this.price = price;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getSpecialties() {
		return specialties;
	}

	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    @Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getid())
         
            .append("lastName", this.getLastName())
            .append("firstName", this.getFirstName())
            .append("specialties", this.specialties)
            .append("experience", this.experience)
            .append("price", this.price)
            .toString();
    }
	

	



	
	
}
