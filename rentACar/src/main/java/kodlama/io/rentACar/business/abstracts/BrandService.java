package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetBayIdBrandResponse;

public interface BrandService {
     List<GetAllBrandsResponse> getAll();
     GetBayIdBrandResponse getById(int id);
     void add(CreateBrandRequest createBrandRequest);
     void update(UpdateBrandRequest updateBrandRequest);
     void delete(int id);
}
