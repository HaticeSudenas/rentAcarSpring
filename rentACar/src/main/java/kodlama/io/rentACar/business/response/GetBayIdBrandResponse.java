package kodlama.io.rentACar.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBayIdBrandResponse {
	private int id;
	private String name;

}
