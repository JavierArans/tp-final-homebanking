package com.ar.tpfinalhomebanking.controllers;
import com.ar.tpfinalhomebanking.entities.dtos.TransferDto;
import com.ar.tpfinalhomebanking.services.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    private final TransferService service;

    private TransferController(TransferService service) {
        this.service = service;
    }
    // Vamos a obtener una lista de transferencias
    @GetMapping //Para acceder a este recurso deben colocar "/transfers"
    public ResponseEntity<List<TransferDto>> getTransfers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransfers());
    }
    // Vamos a Obtener la info de una sola cuenta por su id
    // /{id}va entre llaves por que es una variable
    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferDto> getTransfersById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransfersById(id));
    }

    // Crear/Registrar una nueva transferencia
    @PostMapping
    public ResponseEntity<TransferDto> createTransfer(@RequestBody TransferDto transfer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransfer(transfer));
    }
    //Moificar datos de la transferencia
    @PutMapping(value ="/{id}")
    public ResponseEntity<TransferDto> updateTransfer(@PathVariable Long id, @RequestBody TransferDto transfer){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id, transfer));
    }


    // Eliminar una transfrencia

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
    }

}
