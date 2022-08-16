package com.devsuperior.dscatalog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserInsertDTO extends UserDTO{

    private String password;
}
