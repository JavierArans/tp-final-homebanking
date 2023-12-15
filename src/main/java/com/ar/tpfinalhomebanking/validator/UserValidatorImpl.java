package com.ar.tpfinalhomebanking.validator;


import com.ar.tpfinalhomebanking.entities.dtos.UserDto;
import com.ar.tpfinalhomebanking.exceptions.ApiUnprocessableEntity;
import com.ar.tpfinalhomebanking.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.Year;
import java.util.regex.Pattern;

@Component
public class UserValidatorImpl implements UserValidator{
    @Autowired
    private UserRepository repository;



    @Override
    public void validator(UserDto dto) throws ApiUnprocessableEntity {
        if (dto.getUsername().length() < 3) {
            this.message("El nombre de usuario debe tener al menos 3 caracteres");
        }
        if (dto.getUsername().length() > 15){
            this.message("El nombre de usuario debe tener como maximo 15 caracteres");
        }
        if (dto.getDni().length() > 8){
            this.message("El DNI solo puede contener un máximo de 8 caracteres");
        }
        if (!dto.getDni().matches("\\d+")) {
            this.message("El DNI solo puede contener números");
        }
        if (dto.getDni().length() <= 7){
            this.message("El DNI solo puede contener un mínimo de 7 caracteres");
        }
        if (!dto.getEmail().contains("@")) {
            this.message("El correo electrónico debe contener '@'");
        }
        if (!validarPassword(dto.getPassword())) {
            this.message("La contraseña debe contener al menos un número, una letra mayúscula y algún símbolo/caracter especial");
        }
        //int currentYear = Year.now().getValue();
        //int birthYear = dto.getBirthday_date().getYear();

        //if ((currentYear - birthYear) < 18) {
        //    this.message("Debes ser mayor de 18 años para registrarte");
        //}

    }

    private boolean validarPassword(String password) {
        // Validar que la contraseña contenga al menos un número, una letra mayúscula y algún símbolo/caracter especial
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=]).+$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    private void message (String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
