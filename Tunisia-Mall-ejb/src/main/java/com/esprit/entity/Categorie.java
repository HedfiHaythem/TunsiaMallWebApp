package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Categorie implements Serializable {
	
	private Integer id;
	private String libelle;
	private String description;
	private SecteurActivite secteurActivite;
	


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public SecteurActivite getSecteurActivite() {
		return secteurActivite;
	}
	public void setSecteurActivite(SecteurActivite secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	
	

}
