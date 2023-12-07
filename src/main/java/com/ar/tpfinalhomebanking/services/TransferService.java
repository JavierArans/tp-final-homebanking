package com.ar.tpfinalhomebanking.services;

import com.ar.tpfinalhomebanking.entities.Transfer;
import com.ar.tpfinalhomebanking.entities.dtos.TransferDto;
import com.ar.tpfinalhomebanking.mappers.TransferMapper;
import com.ar.tpfinalhomebanking.repositories.AccountRepository;
import com.ar.tpfinalhomebanking.repositories.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {
    private final TransferRepository repository;

    private TransferService (TransferRepository repository){

        this.repository = repository;
    }
    public List<TransferDto> getTransfers() {
        return repository.findAll().stream()
                .map(TransferMapper::transferToDto)
                .collect(Collectors.toList());
    }


    public TransferDto getTransfersById(Long id) {
        Transfer transf = repository.findById(id).get();
        return TransferMapper.transferToDto(transf);
    }


    public TransferDto createTransfer(TransferDto dto) {
        Transfer newTransfer = TransferMapper.dtoToTransfer(dto);
        return TransferMapper.transferToDto(repository.save(newTransfer));
    }


    public TransferDto updateTransfer(Long id, TransferDto dto) {
        if (repository.existsById(id)){
            Transfer transf = repository.findById(id).get();
            if (dto.getId() != null){
                transf.setId(dto.getId());
            }
            if (dto.getAmount() != null){
                transf.setAmount(dto.getAmount());
            }
            if (dto.getAccountOrigin() != null){
                transf.setAccountOrigin(dto.getAccountOrigin());
            }
            if (dto.getAccountdestiny() != null){
                transf.setAccountdestiny(dto.getAccountdestiny());
            }
            Transfer TransfModified = repository.save(transf);
            return  TransferMapper.transferToDto(TransfModified);
        }else {

        }
        return null;
    }

    public String deleteTransfer(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Transferencia Eliminada";
        }else {
            return "No se puede eliminar la tranaferencia del id " + id ;
        }
    }
}
