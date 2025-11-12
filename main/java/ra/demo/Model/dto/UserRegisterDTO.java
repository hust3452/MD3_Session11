package ra.demo.Model.dto;

import javax.persistence.Entity;

import ra.demo.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterDTO {
    @NotBlank
    @UniqueUsername(message="User Name existed")
    private String userName;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;
    private MultipartFile avatar;
}
