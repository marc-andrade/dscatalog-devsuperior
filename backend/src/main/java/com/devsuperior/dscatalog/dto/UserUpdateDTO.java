package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserUpdateValid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@UserUpdateValid
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateDTO extends UserDTO{

}
