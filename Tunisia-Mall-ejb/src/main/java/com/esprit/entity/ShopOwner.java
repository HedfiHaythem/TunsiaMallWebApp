package com.esprit.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShopOwner extends Utilisateur {
	
	private boolean demande ;
	private String approuver;
	private Date DateDemande=new Date() ;
	private Date DateApprouver;
	private SecteurActivite secteurActiviter;
	private Boutique boutique;
	
	public ShopOwner() {
		secteurActiviter=new SecteurActivite();
		boutique=new Boutique();
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

	public String getApprouver() {
		return approuver;
	}

	public void setApprouver(String approuver) {
		this.approuver = approuver;
	}




	public boolean isDemande() {
		return demande;
	}




	public void setDemande(boolean demande) {
		this.demande = demande;
	}

}
