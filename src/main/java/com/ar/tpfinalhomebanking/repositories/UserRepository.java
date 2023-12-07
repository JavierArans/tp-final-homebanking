package com.ar.tpfinalhomebanking.repositories;

import com.ar.tpfinalhomebanking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // metodo para buscar por UserName
    //public Boolean findByUserName(String username);
   // public Boolean findByEmail (String email);
}
