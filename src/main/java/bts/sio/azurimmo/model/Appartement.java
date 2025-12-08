package bts.sio.azurimmo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "appartement")
@NoArgsConstructor // ⭐ AJOUTE CECI ⭐
@AllArgsConstructor // Optionnel, mais recommandé
public class Appartement {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name="numero")
	 private int numero;

	 @Column(name="surface")
	 private Double surface;
	 
	 @Column(name="nbpiece")
	 private int nbpiece;
	 
	 @Column(name ="description")
	 private String description;
	 
	 @ManyToOne
	 @JoinColumn(name = "batiment_id")
	 private Batiment batiment;

}