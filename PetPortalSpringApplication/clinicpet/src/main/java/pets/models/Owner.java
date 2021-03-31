package pets.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 *  Java Bean object representing Owner of the pet
 *  @author Arpit Dubey
 *  @author Ankita Hundet
 *  
 */

@Entity 
public class Owner extends Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerid;
    private String address;
    private String city;
    private int phone_no;
    
  
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "owner")
    @JsonIgnore
    private List<Pet> pet;

	@JsonManagedReference
	public List<Pet> getPet() {
		return pet;
	}

	public int getOwnerid() {
		return ownerid;
	}


	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}



	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}


	public Owner(String username,String password, String firstName, String lastName, String address, String city, int phone_no) 
	{
		super(username, password,firstName, lastName);
		this.address = address;
		this.city = city;
		this.phone_no = phone_no;
	}


	public Owner() {
		super();
	}


	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", address=" + address + ", city=" + city + ", phone_no=" + phone_no
				+ "]";
	}
    
    
    
 
 
}
