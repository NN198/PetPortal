package pets.models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 *  Java Bean domain object representing Veterinarian appointment by owner
 *  @author Harshit Jain
 */

@Entity
@Table(name = "Appointment")
public class Appointment {  
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	 @Column(name = "appointment_date")
	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	  	@JsonFormat(pattern = "yyyy/MM/dd")
	    private Date appointmentdate;
	
	
	// @NotEmpty
	    @Column(name = "description")
	    private String description;
	    
	    @Column(name="doctor_name")
	    private String doctorname;
	    
	    @Column(name="start_time")
	    private Time starttime;
	    
	    @Column(name="end_time")
	    private Time endtime;
	 
	 @ManyToOne
	    @JoinColumn(name = "pet_id")
	    @JsonIgnore
	    private Pet pet;


	
	
	public Appointment() {
		super();
	}




	public Appointment(int id, Date appointmentdate, String description, String doctorname, Time starttime, Time endtime,
			Pet pet) {
		super();
		this.id = id;
		this.appointmentdate = appointmentdate;
		this.description = description;
		this.doctorname = doctorname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.pet = pet;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}





	public Date getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getDoctorname() {
		return doctorname;
	}




	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}




	public Time getStarttime() {
		return starttime;
	}




	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}




	public Time getEndtime() {
		return endtime;
	}




	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}




	public Pet getPet() {
		return pet;
	}




	public void setPet(Pet pet) {
		this.pet = pet;
	}




	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentdate=" + appointmentdate + ", description=" + description + ", doctorname="
				+ doctorname + ", starttime=" + starttime + ", endtime=" + endtime + ", pet=" + pet + "]";
	}

}
