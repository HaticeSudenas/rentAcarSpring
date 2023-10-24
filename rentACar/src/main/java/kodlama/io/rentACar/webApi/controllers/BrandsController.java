package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetBayIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	BrandService brandService;

	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	@GetMapping("/{id}")
	public GetBayIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@PutMapping
    public void update(UpdateBrandRequest updateBrandRequest) {
    	this.brandService.update(updateBrandRequest);
    }

	@DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	this.brandService.delete(id);
    }
}
