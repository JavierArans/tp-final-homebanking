package com.ar.tpfinalhomebanking.mappers;

import com.ar.tpfinalhomebanking.entities.Transfer;

import com.ar.tpfinalhomebanking.entities.dtos.TransferDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public TransferDTO transferToDto (Transfer transfer){
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setAmount(transfer.getAmount());
        dto.setOrigin(transfer.getAccountOrigin());
        dto.setTarget(transfer.getAccountdestiny());
        return dto;
    }

    public  Transfer dtoToTransfer(TransferDTO dto){
        Transfer transfer = new Transfer();
        transfer.setId(dto.getId());
        transfer.setAmount(dto.getAmount());
        transfer.setAccountOrigin(dto.getOrigin());
        transfer.setAccountdestiny(dto.getTarget());
        return transfer;
    }
}
