package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetBayIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepostory;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepostory brandRepostory;
	private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands=brandRepostory.findAll();
		/*
		 * List<GetAllBrandsResponse> brandResponse=new
		 * ArrayList<GetAllBrandsResponse>(); for (Brand brand :brands) {
		 * GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
		 * responseItem.setId(brand.getId()); responseItem.setName(brand.getName());
		 * brandResponse.add(responseItem); }
		 */
		List<GetAllBrandsResponse> brandResponse=brands.stream()
				.map(brand->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		return brandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		//Brand brand=new Brand();
		//brand.setName(createBrandRequest.getName());
		this.brandBusinessRules.CheckIfBrandNameExits(createBrandRequest.getName());
		
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
		
		this.brandRepostory.save(brand);
		
	}

	@Override
	public GetBayIdBrandResponse getById(int id) {
		Brand brand=this.brandRepostory.findById(id).orElseThrow();
		GetBayIdBrandResponse response=this.modelMapperService.forResponse().map(brand, GetBayIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepostory.save(brand);
		
	}

	@Override
	public void delete(int id) {
		this.brandRepostory.deleteById(id);
		
	}

}
