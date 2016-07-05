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
public class SousCategorie implements Serializable {
	
	private  Integer id;
	private String libelle;
	private String description;
	private Categorie categorie;
	private ShopOwner shopOwner;
	
	
	
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public ShopOwner getShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}
	
	
	
}
