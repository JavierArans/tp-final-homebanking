package com.ar.tpfinalhomebanking.controllers;
import com.ar.tpfinalhomebanking.entities.dtos.AccountDto;
import com.ar.tpfinalhomebanking.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;
    private AccountController (AccountService service){
        this.service = service;
    }

    // Vamos a obtener una lista de cuentas

    @GetMapping //Para acceder a este recurso deben colocar "/account"
    public ResponseEntity<List<AccountDto>> getAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccounts());

    }

    // Vamos a Obtener la info de una sola cuenta por su id
    // /{id}va entre llaves por que es una variable
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccountById(id));
    }

    // Crear/Registrar una cuenta
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
    }
    //Moificar datos de la cuenta
    @PutMapping(value ="/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto account){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAccount(id, account));
    }


    // Eliminar una cuenta

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAccount(id));
    }
}
