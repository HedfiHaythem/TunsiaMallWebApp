package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Produit implements Serializable {
	
	private Integer id;
	private String libelle;
	private String description;
	private Date   dateMisEnLigne;
	private float prixHt;
	private Integer quantite;
	private float tva;
	private String img;
	private List<Media> media;
	private SousCategorie souscategories;
	private Boutique boutique;
	private ShopOwner shopOwner;
	
	public Produit() {
	
		boutique=new Boutique();
		souscategories=new SousCategorie();

	}
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
	public float getPrixHt() {
		return prixHt;
	}
	public void setPrixHt(float prixHt) {
		this.prixHt = prixHt;
	}
	
	
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	
	@OneToMany(mappedBy="produit")
	public List<Media> getMedia() {
		return media;
	}
	public void setMedia(List<Media> media) {
		this.media = media;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public SousCategorie getSouscategories() {
		return souscategories;
	}
	public void setSouscategories(SousCategorie souscategories) {
		this.souscategories = souscategories;
	}
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn
	public Boutique getBoutique() {
		return boutique;
	}
	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public ShopOwner getShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}
	public Date getDateMisEnLigne() {
		return dateMisEnLigne;
	}
	public void setDateMisEnLigne(Date dateMisEnLigne) {
		this.dateMisEnLigne = dateMisEnLigne;
	}

}
