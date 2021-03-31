package pets.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 *  Owner Controller section of the pet owner
 *  
 *  @author Arpit Dubey 
 *  
 *  
 */

@MappedSuperclass
public class Person {
	
	@Column(name = "username")
	protected String username;
	@Column(name = "password")
	protected String password;
	 @Column(name = "first_Name")
	protected String firstName;
	 @Column(name = "last_Name")
	protected String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
		
	}
	
	public Person(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
