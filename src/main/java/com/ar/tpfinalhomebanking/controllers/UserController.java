package com.ar.tpfinalhomebanking.controllers;

import com.ar.tpfinalhomebanking.entities.User;
import com.ar.tpfinalhomebanking.entities.dtos.UserDto;
import com.ar.tpfinalhomebanking.exceptions.ApiUnprocessableEntity;
import com.ar.tpfinalhomebanking.services.UserService;
import com.ar.tpfinalhomebanking.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;




//Establecemos que mapee las request por defecto tenemos (http://localhost:8080)
// en la siguiente linea le indicamos que todas las request deben contener /api
@RestController
@RequestMapping("/api/users")
public class UserController {
    // Por cada Accion/Metodo HTTP que necesitemos implementar/Permitir
    // Vamos a tener un metodo en nuestro controlador
    // Metodos HTTP Permitidos:
    // POST, GET All, GET BY ID, PUT, PATCH, DELETE

    // Estructura de datos para REST: ResponseEntity<>

    // Necesito obtener una instancia del servicio de usuarios

    @Autowired
    private UserService service;
    @Autowired
    private UserValidator userValidator;

    // Vamos a obtener una lista de usuarios registrados

    @GetMapping //Para acceder a este recurso deben colocar "/users"
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());

    }


    // Vamos a Obtener la info de un solo usuario
    // /{id}va entre llaves por que es una variable
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    // Crear/Registrar un usuario
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) throws ApiUnprocessableEntity {
            this.userValidator.validator(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));

    }

    // Modificar TOTALMENTE un usuario (Metodo PUT)

    //En este caso usamos la logica del Path como PUT
    @PutMapping(value ="/{id}")
    public ResponseEntity<UserDto> updateFullUser(@PathVariable Long id, @RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateFullUser(id, user));
    }
    // Modificar PARCIALMENTE un usuario (Metodo PATCH)

    // public String updateParcialUser(){
    //   return"";
    //}

    // Eliminar un usuario

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }

}
