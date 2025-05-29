package com.CarteBucate.CarteBucate.Repository;

import com.CarteBucate.CarteBucate.Entity.CarteDeBucate;
import com.CarteBucate.CarteBucate.Entity.Reteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarteDeBucateRepository extends JpaRepository<CarteDeBucate, UUID> {
    List<CarteDeBucate> findByNumeAutorContainingIgnoreCase(String query);
}
