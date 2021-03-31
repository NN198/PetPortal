package pets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import pets.models.Pet;

import pets.repositry.PetRepositry;


@Service
public class PetServiceImp implements PetInterface
{
	@Autowired
	private PetRepositry pr;

//	
//	@Override
//	public PetR addPet(Pet pet) {
//		// TODO Auto-generated method stub
//		PetR o = new PetR(0,"failed",pet);
//		try {
//			pr.save(pet);
//			o.setStatus(1);
//			o.setReason("success");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return o;
//		
//	}
//
//	
////	@Override
////	public PetR deletePet(String name) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	@Override
//	public PetR viewPetById(int ownerid) {
//		// TODO Auto-generated method stub
//		PetR p = new PetR(0,"failed", null);
//		Optional<Pet> c = pr.findById(ownerid);
//		if(c.isPresent())
//		{
//			Pet x = c.get();
//			p.setStatus(1);
//			p.setReason("failed");
//			p.setContent(x);
//		}
//		else
//			System.out.println("did not found");
//		
//		
//		return p;
//	}
//
//	@Override
//	public PetR updatePet(Pet a) {
//		// TODO Auto-generated method stub
//		PetR o = new PetR(0,"failed",a);
//		if(pr.existsById(a.getPetid()))
//		{
//			pr.save(a);
//			o.setStatus(1);
//			o.setReason("success");
//		}
//		
//		return o;
//		
//	}
//
//
//	@Override
//	public List<Pet> DisplayMultiPet(int petid) {
//		// TODO Auto-generated method stub
//		return pr.f1(petid);
//	}

}
