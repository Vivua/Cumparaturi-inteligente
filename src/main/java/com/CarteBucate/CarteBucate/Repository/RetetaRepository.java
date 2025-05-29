package com.CarteBucate.CarteBucate.Repository;

import com.CarteBucate.CarteBucate.Entity.Reteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RetetaRepository extends JpaRepository<Reteta, UUID> {


        // Custom query to find recipes by name (case insensitive)
        List<Reteta> findByNumeContainingIgnoreCase(String query);



}
