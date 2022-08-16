package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserInsertValid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@UserInsertValid
@NoArgsConstructor
@Getter
@Setter
public class UserInsertDTO extends UserDTO{

    private String password;
}
