package beans.service;

import java.io.File;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.esprit.comman.CommanServiceLocal;
import com.esprit.entity.Categorie;
import com.esprit.entity.Client;
import com.esprit.entity.Produit;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;
import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;

import utility.Iutility;
import utility.Utility;



@SessionScoped
@ManagedBean(name = "produitIndexBean")
public class ProduitIndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	@EJB
	private UserServiceLocal<Produit>  serviceProduit;
	
	
	
	
	private List<Produit> listProduits ;
	
	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */


	
	@PostConstruct
	public void initialization() {
		
		

			setListProduits(serviceProduit.findAll(new Produit()));
	
								}

	public UserServiceLocal<Produit> getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(UserServiceLocal<Produit> serviceProduit) {
		this.serviceProduit = serviceProduit;
	}

	public List<Produit> getListProduits() {
		return listProduits;
	}

	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}
	 

}