package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepostory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepostory brandRepostory;
    public void CheckIfBrandNameExits(String name) {
 	   if(this.brandRepostory.existsByName(name)) {
 		   throw new BusinessException("Brand Already Exits");
 	   }
 	   
    }
} 
