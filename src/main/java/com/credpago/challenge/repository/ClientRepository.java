package com.credpago.challenge.repository;

import com.credpago.challenge.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    @Query("select c from Client c where c.cpf = :cpf")
    Optional<Client> findClientByCpf(@Param("cpf") String cpf);

}
