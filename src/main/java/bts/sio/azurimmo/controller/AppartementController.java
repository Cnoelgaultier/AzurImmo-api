package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;

import org.springframework.web.bind.annotation.RequestParam;
import bts.sio.azurimmo.service.AppartementService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/{appartementId}") 
    public Optional<Appartement> getAppartementById(@PathVariable Long appartementId) {
        return appartementService.getAppartement(appartementId);
    }

 // Dans AppartementController.java


}