package com.CarteBucate.CarteBucate.Service;

import com.CarteBucate.CarteBucate.Entity.CarteDeBucate;
import com.CarteBucate.CarteBucate.Entity.Reteta;
import com.CarteBucate.CarteBucate.Repository.CarteDeBucateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarteDeBucateService {
    @Autowired
    CarteDeBucateRepository carteDeBucateRepository;

    public List<CarteDeBucate> getAllCarteDeBucate(){
        return carteDeBucateRepository.findAll();
    }

    public CarteDeBucate getCarteDeBucateById(UUID id){
        return carteDeBucateRepository.getReferenceById(id);
    }
    public List<CarteDeBucate> searchCarteDeBucate(String query) {
        return carteDeBucateRepository.findByNumeAutorContainingIgnoreCase(query); // Example search method
    }

    public void saveCarteDeBucate(CarteDeBucate carteDeBucate){
        carteDeBucateRepository.save(carteDeBucate);
    }
}
