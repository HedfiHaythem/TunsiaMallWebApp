package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends Utilisateur implements Serializable {
	
	private List<Commande> commande;

	@OneToMany(mappedBy="client")
	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}


}
