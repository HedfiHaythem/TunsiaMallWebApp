package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SuperAdmin extends Utilisateur implements Serializable{

	
	
	
	private List<Boutique> boutique;
	private List<Evenement> evenement;
	
	@OneToMany(mappedBy="administrateur")
	public List<Boutique> getBoutique() {
		return boutique;
	}

	public void setBoutique(List<Boutique> boutique) {
		this.boutique = boutique;
	}
	
	@OneToMany(mappedBy="administrateur")
	public List<Evenement> getEvenement() {
		return evenement;
	}

	public void setEvenement(List<Evenement> evenement) {
		this.evenement = evenement;
	}
}
