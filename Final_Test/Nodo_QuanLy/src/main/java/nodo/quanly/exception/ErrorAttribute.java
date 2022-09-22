package nodo.quanly.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorAttribute extends RuntimeException{

    private String errorCode;
    private String errorMessage;
    private Date errorDate;

}
