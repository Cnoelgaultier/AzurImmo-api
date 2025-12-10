package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// IMPORTS SWAGGER
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/batiments")
@Tag(name = "Batiments", description = "Gestion des immeubles et bâtiments")
public class BatimentController {
	
   @Autowired
    private BatimentService batimentService;

	
    @PostMapping("/")
    @Operation(summary = "Créer un nouveau bâtiment (Entité complète)")
    public Batiment createBatiment(@RequestBody Batiment batiment) { 
        return batimentService.saveBatiment(batiment);
    }
    
    @GetMapping("/re/{batimentId}")
    @Operation(summary = "Récupérer un bâtiment par son ID (Format DTO)")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
    @GetMapping("/") 
    @Operation(summary = "Lister tous les bâtiments (Entités)")
    public List<Batiment> getBatiments() {
        return batimentService.getBatiments();
    }
    
    
    @GetMapping("/dto")
    @Operation(summary = "Lister tous les bâtiments (Format DTO)")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
    
    
    @PostMapping("/dto")
    @Operation(summary = "Créer un bâtiment via DTO")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); // 201 Created
    }

}