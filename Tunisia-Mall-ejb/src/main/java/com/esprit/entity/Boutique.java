package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Boutique implements Serializable{
	
	private Integer id;
	private Integer num;
	private String tel;
	private String etat;
	private ProprietaireBoutique pb;
	private List <Produit> produit;
	private SecteurActivite secteuractivite;
	private SuperAdmin administrateur;
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	@OneToOne(mappedBy="boutique")
	public ProprietaireBoutique getPb() {
		return pb;
	}
	public void setPb(ProprietaireBoutique pb) {
		this.pb = pb;
	}
	

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	@ManyToOne
	public SecteurActivite getSecteuractivite() {
		return secteuractivite;
	}
	public void setSecteuractivite(SecteurActivite secteuractivite) {
		this.secteuractivite = secteuractivite;
	}
	
	@ManyToOne
	public SuperAdmin getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(SuperAdmin administrateur) {
		this.administrateur = administrateur;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

}
