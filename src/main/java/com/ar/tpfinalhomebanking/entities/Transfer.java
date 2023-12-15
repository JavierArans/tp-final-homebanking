package com.ar.tpfinalhomebanking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "homebanking_transfer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private BigDecimal amount;

    @Column(name = "cuenta_origen")
    private Long accountOrigin;

    @Column(name = "cuenta_destino")
    private Long accountdestiny;

    @Column(name = "fecha_creacion")
    private Date created_at;

    @Column(name = "fecha_modificacion")
    private LocalDateTime updated_at;



}
