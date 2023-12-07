package com.ar.tpfinalhomebanking.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {

    private Long id;

    private BigDecimal amount;

    private String accountOrigin;

    private String accountdestiny;

}
