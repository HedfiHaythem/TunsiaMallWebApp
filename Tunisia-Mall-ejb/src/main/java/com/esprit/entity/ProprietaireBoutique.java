package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProprietaireBoutique extends Utilisateur implements Serializable {

	private Boutique boutique;

	
	@OneToOne
	public Boutique getBoutique() {
		return boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}
}
