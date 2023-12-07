package com.ar.tpfinalhomebanking.mappers;

import com.ar.tpfinalhomebanking.entities.Transfer;
import com.ar.tpfinalhomebanking.entities.dtos.TransferDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public TransferDto transferToDto(Transfer transfer){
        TransferDto dto = new TransferDto();
        dto.setId(transfer.getId());
        dto.setAmount(transfer.getAmount());
        dto.setAccountOrigin(transfer.getAccountOrigin());
        dto.setAccountdestiny(transfer.getAccountdestiny());
        return dto;
    }

    public  Transfer dtoToTransfer(TransferDto dto){
        Transfer transfer = new Transfer();
        transfer.setId(dto.getId());
        transfer.setAmount(dto.getAmount());
        transfer.setAccountOrigin(dto.getAccountOrigin());
        transfer.setAccountdestiny(dto.getAccountdestiny());
        return transfer;
    }
}
