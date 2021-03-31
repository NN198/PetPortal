package pets.models;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 *  Simple Java Bean representing Pet
 *  @author Noella Noronha
 *  
 */

@Entity
public class Pet 
{
   @Id
   @GeneratedValue
   private int petid;
   
   private String name;
   private int age;
   private float weight;
   private String category;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "owner_id", nullable = false)  
   private Owner owner;

   @JsonBackReference
   public Owner getOwner() {
   	return owner;
   }
   
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
   private Set<Appointment> appointment;
   
	public int getPetid() {
		return petid;
	}
	
	public void setPetid(int petid) {
		this.petid = petid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Pet(String name, int age, float weight, String category) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.category = category;
	}
	
	public Pet() {
		super();
	}
	
	@Override
	public String toString() {
		return "Pet [petid=" + petid + ", name=" + name + ", age=" + age + ", weight=" + weight + ", category=" + category
				+ "]";
	}
	
	public Set<Appointment> getAppointment() {
		return appointment;
	}
	
	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}   
	   
	   

   

   
   
}
