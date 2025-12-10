package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.AppartementService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/appartements")
public class AppartementController {
	
   @Autowired
    private AppartementService appartementService;

	
    @PostMapping("/")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }

    
    @GetMapping("/")
    
    public List<Appartement> getAllAppartements() { 
        
        return appartementService.getAllAppartements(); 
    }
    
    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    
    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
     }
    
    
    @GetMapping("/surface")
    public List<Appartement> getAppartementsParSurface(@RequestParam Double minSurface) {
        return appartementService.getAppartementsSuperieursA(minSurface);
    }

    
    /*@GetMapping("/{appartementId}")
    public Optional <AppartementDTO> getAppartementDTO(@PathVariable long appartementId) {
        return appartementService.getAppartementDTO(appartementId);
    }*/
    
    @GetMapping("/re/{appartementId}")
    public ResponseEntity<AppartementDTO> getAppartementDTO(@PathVariable long appartementId) {
            return appartementService.getAppartementDTO(appartementId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }

    @GetMapping("/dto")
    public List<AppartementDTO> getAllAppartement() {
        return appartementService.getAppartementDTO(); 
    }

    
   

    


}