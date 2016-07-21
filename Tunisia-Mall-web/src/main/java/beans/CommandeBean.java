package beans;

import java.io.Serializable;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.esprit.comman.CommanService;
import com.esprit.entity.Client;
import com.esprit.entity.Commande;
import com.esprit.entity.Produit;
import com.esprit.entity.Utilisateur;
import com.esprit.service.UserServiceLocal;

import utility.Iutility;
import utility.Utility;



@SessionScoped
@ManagedBean(name = "CommandeBean")
public class CommandeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	@EJB
	private UserServiceLocal<Produit>  serviceProduit;
	
	@EJB
	private UserServiceLocal<Utilisateur>  serviceUser;
	
	@EJB
	private UserServiceLocal<Commande>  serviceCommande;
	
	
	
	private ArrayList<Commande> commandes=new ArrayList<Commande>() ;
	private ArrayList<Commande> listCommandes ;
	private ArrayList<Commande> listSelectedCommandes=new ArrayList<Commande>() ;
	private ArrayList<Produit> listProduits;
	private Commande commande;
	

	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	
Iutility ut =new Utility();

	
	public Utilisateur utilisateur = new Utilisateur();



	private Client client=(Client) ut.getUserfromMapSession();




	
	@PostConstruct
	public void initialization() {

			
		listCommandes=(serviceCommande.findAll(new Commande()));

			commande=new Commande();
			}
	 
	public void adding(Commande ta) {
				ta.setClient(client);
				serviceCommande.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Commande ta) {

		serviceCommande.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Commande ta) {
		try {
			serviceCommande.delete(new Commande(),"id",ta.getId()+"");
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Supprimé(e) avec succés", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			initialization();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La Marque est encore utilisable", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	
	public UserServiceLocal<Utilisateur> getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(UserServiceLocal<Utilisateur> serviceUser) {
		this.serviceUser = serviceUser;
	}

	public ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	public ArrayList<Commande> getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(ArrayList<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}

	public ArrayList<Commande> getListSelectedCommandes() {
		return listSelectedCommandes;
	}

	public void setListSelectedCommandes(ArrayList<Commande> listSelectedCommandes) {
		this.listSelectedCommandes = listSelectedCommandes;
	}

	public ArrayList<Produit> getListProduits() {
		return listProduits;
	}

	public void setListProduits(ArrayList<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public Iutility getUt() {
		return ut;
	}

	public void setUt(Iutility ut) {
		this.ut = ut;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public UserServiceLocal<Produit> getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(UserServiceLocal<Produit> serviceProduit) {
		this.serviceProduit = serviceProduit;
	}

	public UserServiceLocal<Commande> getServiceCommande() {
		return serviceCommande;
	}

	public void setServiceCommande(UserServiceLocal<Commande> serviceCommande) {
		this.serviceCommande = serviceCommande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

}