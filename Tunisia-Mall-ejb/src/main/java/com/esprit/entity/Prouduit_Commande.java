package com.esprit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Prouduit_Commande")
@IdClass(Prouduit_CommandeId.class)
public class Prouduit_Commande {
	
 
  
  @Column(name="quantite")
  private String quantite;
  
  private Integer id;
  
  @Id
private long produitId;
  @Id
  private long commandeId;
  
  
  @ManyToOne
  @PrimaryKeyJoinColumn(name="produitId", referencedColumnName="ID")
  private Produit produit;
  

  @ManyToOne
  @PrimaryKeyJoinColumn(name="commandeId", referencedColumnName="ID")
  private Commande commande;

public String getQuantite() {
	return quantite;
}

public void setQuantite(String quantite) {
	this.quantite = quantite;
}

public long getProduitId() {
	return produitId;
}

public void setProduitId(long produitId) {
	this.produitId = produitId;
}

public long getCommandeId() {
	return commandeId;
}

public void setCommandeId(long commandeId) {
	this.commandeId = commandeId;
}

/*
public Produit getProduit() {
	return produit;
}

public void setProduit(Produit produit) {
	this.produit = produit;
}

public Commande getCommande() {
	return commande;
}

public void setCommande(Commande commande) {
	this.commande = commande;
}
  
  
  */


  
}
