package com.ar.tpfinalhomebanking.services;
import com.ar.tpfinalhomebanking.entities.Account;
import com.ar.tpfinalhomebanking.entities.dtos.AccountDto;
import com.ar.tpfinalhomebanking.entities.enums.AccountType;
import com.ar.tpfinalhomebanking.mappers.AccountMapper;
import com.ar.tpfinalhomebanking.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository repository;

    private AccountService (AccountRepository repository){

        this.repository = repository;
    }

    public List<AccountDto> getAccounts() {
        return repository.findAll().stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());
    }

    public AccountDto getAccountById(Long id) {
        Account acc = repository.findById(id).get();
        return AccountMapper.accountToDto(acc);

    }


    public AccountDto createAccount(AccountDto dto) {
        //TODO: refactor para crear diferentes tipos de cuenta
        dto.setType(AccountType.CAJA_AHORRO_PESOS);
        dto.setAmount(BigDecimal.ZERO);
        Account newAccount = AccountMapper.dtoToAccount(dto);
        return AccountMapper.accountToDto(repository.save(newAccount));
    }

    public AccountDto updateAccount(Long id, AccountDto dto) {
        if (repository.existsById(id)){
            Account acc = repository.findById(id).get();
            if (dto.getAlias() != null){
                acc.setAlias(dto.getAlias());
            }
            if (dto.getType() != null){
                acc.setType(dto.getType());
            }
            if (dto.getCbu() != null){
                acc.setCbu(dto.getCbu());
            }
            if (dto.getAmount() != null){
                acc.setAmount(dto.getAmount());
            }
            Account AccModified = repository.save(acc);
            return AccountMapper.accountToDto(AccModified);
        }else{

        }
        return null;
    }

    public String deleteAccount(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Cuenta Eliminada";
        } else{
            return "No se pudo eliminar la cuenta";
        }
    }
}
