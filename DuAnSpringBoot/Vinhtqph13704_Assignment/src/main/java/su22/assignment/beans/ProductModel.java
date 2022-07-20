package su22.assignment.beans;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22.assignment.entities.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private int id;
	@NotBlank(message = "Name is not null")
	private String name;
	
	private String image;
	
	@NotNull(message = "Price is not null")
	private float price;
	
	private Date createdDate;
	
	@NotNull(message = "Available is not null")
	private int available;
	
	@NotNull(message = "Category is not null")
	private int categoryId;
	
	private MultipartFile imageName;
}
