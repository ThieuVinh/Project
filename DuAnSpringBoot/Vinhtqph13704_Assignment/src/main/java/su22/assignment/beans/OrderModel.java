package su22.assignment.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
	@NotBlank(message = "Address is not null")
	private String address;
	
	@Min(value = 1, message = "Số lượng ko được nhỏ hơn 0")
	@NotNull(message =  "Quatity is not null")
	private int quatity;
}
