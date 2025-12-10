package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/batiments")
@NoArgsConstructor         
@AllArgsConstructor
public class BatimentController {
	
   @Autowired
    private BatimentService batimentService;

	
    @PostMapping("/")
    public Batiment createAppartement(@RequestBody Batiment batiment) {
        return batimentService.saveBatiment(batiment);
    }
    
   /* @GetMapping("/{batimentId}")
    public Optional <BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId);
    }*/
    
    @GetMapping("/re/{batimentId}")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
    @GetMapping("/") 
    public List<Batiment> getBatiments() {
        return batimentService.getBatiments();
    }
    
    
    @GetMapping("/dto")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }

}