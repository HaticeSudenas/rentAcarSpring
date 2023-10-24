package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepostory;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	private ModelRepostory modelRepostory;
    private ModelMapperService modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
		 List<Model> models=modelRepostory.findAll();
		 
		 List<GetAllModelsResponse> modelResponse=models.stream()
				 .map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				 .collect(Collectors.toList());
		 
		return modelResponse;
	}
	
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model=this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepostory.save(model);
	}

}
