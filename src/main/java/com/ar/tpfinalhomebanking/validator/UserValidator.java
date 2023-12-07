package com.ar.tpfinalhomebanking.validator;

import com.ar.tpfinalhomebanking.entities.dtos.UserDto;
import com.ar.tpfinalhomebanking.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

// Interface para validacion de los datos recibidos
// para la creacion de usuarios
@Service
public interface UserValidator {
    void validator(UserDto dto) throws ApiUnprocessableEntity;

}
