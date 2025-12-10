package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.service.AppartementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// IMPORTS SWAGGER 
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/appartements") // CHANGEMENT 1 : J'ai enlevé "/api" comme demandé
@Tag(name = "Appartements", description = "Gestion des appartements") // CHANGEMENT 2 : Titre de la section dans Swagger
public class AppartementController {
	
   @Autowired
    private AppartementService appartementService;

	
    @PostMapping("/")
    @Operation(summary = "Créer un nouvel appartement (Entité complète)")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }

    
    @GetMapping("/")
    @Operation(summary = "Lister tous les appartements (Entités)")
    public List<Appartement> getAllAppartements() { 
        return appartementService.getAllAppartements(); 
    }
    
    @GetMapping("/ville/{ville}")
    @Operation(summary = "Rechercher des appartements par ville")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    
    @GetMapping("/batiment/{batimentId}")
    @Operation(summary = "Lister les appartements d'un bâtiment spécifique")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
     }
    
    
    @GetMapping("/surface")
    @Operation(summary = "Filtrer les appartements par surface minimum")
    public List<Appartement> getAppartementsParSurface(@RequestParam Double minSurface) {
        return appartementService.getAppartementsSuperieursA(minSurface);
    }

    
    @GetMapping("/re/{appartementId}")
    @Operation(summary = "Récupérer un appartement par son ID (Format DTO)")
    public ResponseEntity<AppartementDTO> getAppartementDTO(@PathVariable long appartementId) {
            return appartementService.getAppartementDTO(appartementId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }

    @GetMapping("/dto")
    @Operation(summary = "Lister tous les appartements (Format DTO)")
    public List<AppartementDTO> getAllAppartement() {
        return appartementService.getAppartementDTO(); 
    }

    
    @PostMapping("/dto")
    @Operation(summary = "Créer un appartement via DTO")
    public ResponseEntity<AppartementDTO> createAppartement(@RequestBody AppartementDTO dto) {
    	AppartementDTO savedDTO = appartementService.saveAppartementDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); 
    }

}