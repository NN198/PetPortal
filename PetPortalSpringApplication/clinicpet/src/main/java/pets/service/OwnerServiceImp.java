package pets.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pets.models.Owner;

import pets.repositry.OwnerRepositry;


@Service
public class OwnerServiceImp implements OwnerInterface 
{
//	
//	@Autowired
//	private OwnerRepositry or;
//
//	@Override
//	public OwnerR viewOwner(int ownerid) {
//		// TODO Auto-generated method stub
//		OwnerR o = new OwnerR(0,"failed",null);
//		Optional<Owner> c = or.findById(ownerid);
//		if(c.isPresent())
//		{
//			Owner x = c.get();
//			o.setStatus(1);
//			o.setReason("success");
//			o.setContent(x);
//		}
//		else
//			System.out.println("did not found");
//		
//		
//		return o;
//	}
//
//	@Override
//	public OwnerR addOwner(Owner n) {
//		// TODO Auto-generated method stub
//		OwnerR o = new OwnerR(0,"failed",n);
//		try {
//			or.save(n);
//			o.setStatus(1);
//			o.setReason("success");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return o;
//	}
//
//	@Override
//	public OwnerR updateOwner(Owner n1) {
//		// TODO Auto-generated method stub
//		OwnerR o = new OwnerR(0,"failed",n1);
//		if(or.existsById(n1.getOwnerid()))
//		{
//			or.save(n1);
//			o.setStatus(1);
//			o.setReason("success");
//		}
//		
//		return o;
//	}

}
