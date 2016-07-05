package com.esprit.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShopOwner extends Utilisateur {
	
	private boolean Demande ;
	private String Approuver;
	private Date DateDemande=new Date() ;
	private Date DateApprouver;
	private SecteurActivite secteurActiviter;
	private Boutique boutique;
	public boolean isDemande() {
		return Demande;
	}

	public void setDemande(boolean demande) {
		Demande = demande;
	}

	public String getApprouver() {
		return Approuver;
	}

	public void setApprouver(String approuver) {
		Approuver = approuver;
	}

	public Date getDateDemande() {
		return DateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		DateDemande = dateDemande;
	}

	public Date getDateApprouver() {
		return DateApprouver;
	}

	public void setDateApprouver(Date dateApprouver) {
		DateApprouver = dateApprouver;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public SecteurActivite getSecteurActiviter() {
		return secteurActiviter;
	}

	public void setSecteurActiviter(SecteurActivite secteurActiviter) {
		this.secteurActiviter = secteurActiviter;
	}
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	public Boutique getBoutique() {
		return boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

}
