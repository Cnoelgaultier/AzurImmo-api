package bts.sio.azurimmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.BatimentRepository;
import lombok.Data;

@Data
@Service
public class BatimentService {
	
	 @Autowired
	 private BatimentRepository batimentRepository;

	 public Batiment saveBatiment(Batiment batiment) {
	
		 Batiment savedBatiment = batimentRepository.save(batiment); 
	     return savedBatiment;
	 }
	 
	 public List<Batiment> getBatiments() {
         return batimentRepository.findAll();
     }
	 
	 public Optional<Batiment> getBatiment(Long id) {

	        return batimentRepository.findById(id); 
	    }
}