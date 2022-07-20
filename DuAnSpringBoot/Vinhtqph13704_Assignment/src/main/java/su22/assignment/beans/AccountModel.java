package su22.assignment.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private int id;
	@NotBlank(message = "Username is not null")
	private String username;
	
	@NotBlank(message = "Password is not null")
	private String password;
	
	@NotBlank(message = "Fullname is not null")
	private String fullname;
	
	@NotBlank(message = "Email is not null")
	@Email(message = "Email invalidate")
	private String email;
	
	private String photo;
	
	private MultipartFile photoName;
	
	@NotNull
	private int activated;
	
	@NotNull
	private int admin;
}
