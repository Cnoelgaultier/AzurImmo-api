package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.repository.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; 

@Service
public class AppartementService {
	
	@Autowired
	private AppartementRepository appartementRepository;

	public Appartement saveAppartement(Appartement appartement) {
		return appartementRepository.save(appartement);
	}


	public List<Appartement> getAllAppartements() {
		return appartementRepository.findAll(); 
	}

	
	public List<Appartement> findByVille(String ville) {
		return appartementRepository.findByBatiment_Ville(ville);
	}

	public List<Appartement> getAppartementsParBatiment(Long batimentId) {
		return appartementRepository.findByBatiment_Id(batimentId);
	}


	public List<Appartement> getAppartementsSuperieursA(Double minSurface) {
		return appartementRepository.findBySurfaceGreaterThan(minSurface);
	}
	

	public Optional<Appartement> getAppartement(Long appartementId) {
		return appartementRepository.findById(appartementId); 
	}

	
}