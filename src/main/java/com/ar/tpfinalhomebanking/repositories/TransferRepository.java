package com.ar.tpfinalhomebanking.repositories;

import com.ar.tpfinalhomebanking.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
