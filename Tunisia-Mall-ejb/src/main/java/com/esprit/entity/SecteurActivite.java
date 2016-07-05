package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class SecteurActivite implements Serializable{
	
	private Integer id;
	private String Libelle;
	private String description;

	private List<Boutique> boutique;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="secteuractivite")
	public List<Boutique> getBoutique() {
		return boutique;
	}
	public void setBoutique(List<Boutique> boutique) {
		this.boutique = boutique;
	}
	
	
}
