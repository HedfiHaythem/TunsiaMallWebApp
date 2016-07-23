package beans.service;

import java.io.File;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.esprit.entity.Commande;
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
	
	@EJB
	private UserServiceLocal<Commande>  serviceCommande;
	
	
	private List<Produit> listProduits ;
	private List<Produit> listProduitselected =new ArrayList<Produit>();
	private List<Commande> mesCommandes;
	private List<Commande> commandeFrs;
	private Commande commande;
	
	public List<Commande> getCommandeFrs() {
		return commandeFrs;
	}



	public void setCommandeFrs(List<Commande> commandeFrs) {
		this.commandeFrs = commandeFrs;
	}



	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */


	
	@PostConstruct
	public void initialization() {
		
		

			setListProduits(serviceProduit.findAll(new Produit()));
	
								}
	
	
	
	public void CommandeProduit(String id){
			System.out.println("id "+id);
			listProduitselected.add((Produit) serviceProduit.findById(new Produit(), "id", id));
			listProduitselected.size();
	}
	
	public void CommandeProduit(Integer id){
		System.out.println("id "+id);
		listProduitselected.add((Produit) serviceProduit.findById(new Produit(), "id", id.toString()));
		System.out.println("list"+listProduitselected.size());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Produit ajouter au panier", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
}

	
	public void removeProduitDejaCommander(Integer id){
		
		for (int i = 0; i < listProduitselected.size(); i++) {
			
			if(listProduitselected.get(i).getId()==id){
				listProduitselected.remove(i);
				break;
			}
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Produit supprimer de panier", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
		public void validercommande(){
			 Iutility ut =new Utility();
			 Client client = null;
			if(ut.getUserfromMapSession() instanceof Client){
				client = (Client) ut.getUserfromMapSession();
				}
			System.out.println(client.getPrenom());
			Commande commande=new Commande();
			
			commande.setProduits(listProduitselected );
			commande.setClient(client);
			commande.setEtat("en cours");
			for (int i = 0; i < listProduitselected.size(); i++) {
				commande.setShopOwner(listProduitselected.get(i).getShopOwner());
				serviceCommande.create(commande);
				
			}
				
			
			
			listProduitselected=new ArrayList<>();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Commande a etait bien envoye", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		
		public void mesCommandesClient(){
			 Iutility ut =new Utility();
			 Client client = null;
			if(ut.getUserfromMapSession() instanceof Client){
				client = (Client) ut.getUserfromMapSession();
				}
			 mesCommandes=serviceCommande.findReqList(new Commande(), "client.id="+ client.getId().toString());
			
		}
		
		public void mesCommandesFrs(){
			 Iutility ut =new Utility();
			 ShopOwner shopOwner = null;
			if(ut.getUserfromMapSession() instanceof ShopOwner){
				shopOwner = (ShopOwner) ut.getUserfromMapSession();
				}
			commandeFrs=serviceCommande.findReqList(new Commande(), "shopOwner.id="+ shopOwner.getId().toString());
			
		}
		
		
		public Integer SizeCommandesFrs(){
			 Iutility ut =new Utility();
			 ShopOwner shopOwner = null;
			if(ut.getUserfromMapSession() instanceof ShopOwner){
				shopOwner = (ShopOwner) ut.getUserfromMapSession();
				}
			commandeFrs=serviceCommande.findReqList(new Commande(), "shopOwner.id="+ shopOwner.getId().toString());
			
			return commandeFrs.size();
		}
		
		public void validerCommandesFrs(){
			 Iutility ut =new Utility();
			 ShopOwner shopOwner = null;
			if(ut.getUserfromMapSession() instanceof ShopOwner){
				shopOwner = (ShopOwner) ut.getUserfromMapSession();
				}
			commande.setEtat("ok");
			serviceCommande.update(commande);
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Commande Valider Avec Succes", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
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



	public List<Produit> getListProduitselected() {
		return listProduitselected;
	}



	public void setListProduitselected(List<Produit> listProduitselected) {
		this.listProduitselected = listProduitselected;
	}



	public UserServiceLocal<Commande> getServiceCommande() {
		return serviceCommande;
	}



	public void setServiceCommande(UserServiceLocal<Commande> serviceCommande) {
		this.serviceCommande = serviceCommande;
	}



	public List<Commande> getMesCommandes() {
		return mesCommandes;
	}



	public void setMesCommandes(List<Commande> mesCommandes) {
		this.mesCommandes = mesCommandes;
	}



	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	 

}