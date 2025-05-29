package com.CarteBucate.CarteBucate.Service;

import com.CarteBucate.CarteBucate.Entity.Reteta;
import com.CarteBucate.CarteBucate.Repository.RetetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RetetaService {
    @Autowired
    RetetaRepository retetaRepository;

    public List<Reteta> getAllReteta(){
        return retetaRepository.findAll();
    }
    public Reteta getRetetaById(UUID uuid){
        return  retetaRepository.getReferenceById(uuid);
    }
    public void saveReteta(Reteta reteta){
        retetaRepository.save(reteta);
    }

    public void deleteReteta(UUID id){
        retetaRepository.deleteById(id);
    }
    public List<Reteta> searchReteta(String query) {
        return retetaRepository.findByNumeContainingIgnoreCase(query); // Example search method
    }
}
