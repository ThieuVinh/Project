package su22.assignment.beans;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {
	@NotBlank(message = "Username is not null")
	private String username;
	
	@NotBlank(message = "Password is not null")
	private String password;
}
