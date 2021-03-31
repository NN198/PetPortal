package pets.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pets.models.Appointment;
import pets.repositry.AppointmentRepository;

@Service
public class AppointmentServiceImp implements AppointmentService {
	
	
//	
//	private AppointmentRepository appointmentRepository;
//	
//	
//	 @Autowired
//	public AppointmentServiceImp(AppointmentRepository appointmentRepository) {
//		
//		this.appointmentRepository = appointmentRepository;
//	}
//	 
//	 
//
//	    @Override
//	    @Transactional
//	    public void saveAppointment(Appointment appointment) throws DataAccessException {
//	    	appointmentRepository.save(appointment);
//	    }
//	    
//	    @Override
//		public Collection<Appointment> findAppointmentsByPetId(int petId) {
//			return appointmentRepository.viewPetById(petId);
//		}

}
