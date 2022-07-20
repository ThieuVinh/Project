package su22.assignment.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22.assignment.entities.Order;
import su22.assignment.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {

	@NotNull(message = "Quatity is not null")
	@Min(value = 1, message = "Số lượng ko được nhỏ hơn 0")
	private int quatity;
}
