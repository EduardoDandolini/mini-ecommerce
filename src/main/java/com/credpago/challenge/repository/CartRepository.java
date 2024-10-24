package com.credpago.challenge.repository;

import com.credpago.challenge.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    @Query("select c from Cart c where c.clientId = :id")
    Optional<Cart> findCartByClientId(@Param("id") String id);

}
