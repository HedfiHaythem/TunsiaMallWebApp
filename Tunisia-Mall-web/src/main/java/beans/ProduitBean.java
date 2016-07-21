package beans;

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
@ManagedBean(name = "ProduitBean")
public class ProduitBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommanServiceLocal<SousCategorie>  serviceSousCategorie;
	
	
	@EJB
	private UserServiceLocal<Produit>  serviceProduit;
	
	@EJB
	private UserServiceLocal<Utilisateur>  serviceUser;
	
	
	
	private List<Produit> listProduits ;
	private List<Produit> listSelectedProduits=new ArrayList<Produit>() ;
	private List<Produit> listFilterProduits ;
	private Produit produit;
	private List<String> listSTanlayses ;
	private List<String> listSelectedStProduits ;
	
	private List<SousCategorie> listSousCategories ;
	private ShopOwner shopOwner;

	private String txt1;

	/**
	 * ------------------------------------------------------------------------
	 * --------------------------------------------------------
	 */
	
Iutility ut =new Utility();

	
	public Utilisateur utilisateur = new Utilisateur();


	public void fileUpload22(FileUploadEvent event) throws Exception {
		Iutility traitementImgText =new Utility(); 
		
		
		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		
		File file=traitementImgText.writeFile(event, "/PublicImage/");
		
	
	
		
	
		// getNosFormulaire().setUrlPhotot("thumb"+file.getName());
		produit.setImg(file.getName());
		serviceProduit.update(produit);
		 initialization();
		FacesMessage msg = new FacesMessage("chargement avec succès ", event
				.getFile().getFileName() + " is uploaded.");

		FacesContext.getCurrentInstance().addMessage(null, msg);


	}


	
	@PostConstruct
	public void initialization() {
		
		
		
System.out.println(ut.getUserfromMapSession().getId());
		
		if(ut.getUserfromMapSession() instanceof ShopOwner){
			System.out.println("shopOwner");
			shopOwner=(ShopOwner) ut.getUserfromMapSession();
			setListProduits(serviceProduit.findReqList(new Produit(),"shopOwner.id="+shopOwner.getId()));
			setListSousCategories(serviceSousCategorie.findReqList(new SousCategorie(),"shopOwner.id="+shopOwner.getId()));
			
		}
		

		if (ut.getUserfromMapSession() instanceof SuperAdmin)
			setListProduits(serviceProduit.findAll(new Produit()));
		
		if(ut.getUserfromMapSession() instanceof Client)
			setListProduits(serviceProduit.findAll(new Produit()));
		
		if(ut.getUserfromMapSession()==null){
			setListProduits(serviceProduit.findAll(new Produit()));
			
		}
		
		
		
		
		produit=new Produit();
			}
	 
	public void adding(Produit ta) {
				ta.setShopOwner(shopOwner);
				serviceProduit.create(ta);
		initialization();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Enregistré(e) avec succés", "");
		FacesContext.getCurrentInstance().addMessage

		(null, msg);
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void updating(Produit ta) {

		serviceProduit.update(ta);
		initialization();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"mis(e) à jour avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	/*----------------------------------------------------------------------------------------------------------*/
	public void removing(Produit ta) {
		try {
			serviceProduit.delete(new Produit(),"id",ta.getId()+"");
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


	public List<Produit> getListSelectedProduits() {
		return listSelectedProduits;
	}


	public void setListSelectedProduits(List<Produit> listSelectedProduits) {
		this.listSelectedProduits = listSelectedProduits;
	}


	public List<Produit> getListFilterProduits() {
		return listFilterProduits;
	}

	public void setListFilterProduits(List<Produit> listFilterProduits) {
		this.listFilterProduits = listFilterProduits;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<String> getListSTanlayses() {
		return listSTanlayses;
	}

	public void setListSTanlayses(List<String> listSTanlayses) {
		this.listSTanlayses = listSTanlayses;
	}

	public List<String> getListSelectedStProduits() {
		return listSelectedStProduits;
	}

	public void setListSelectedStProduits(List<String> listSelectedStProduits) {
		this.listSelectedStProduits = listSelectedStProduits;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public List<SousCategorie> getListSousCategories() {
		return listSousCategories;
	}

	public void setListSousCategories(List<SousCategorie> listSousCategorie) {
		this.listSousCategories = listSousCategorie;
	}
	


	public CommanServiceLocal<SousCategorie> getServiceSousCategorie() {
		return serviceSousCategorie;
	}



	public UserServiceLocal<Utilisateur> getServiceUser() {
		return serviceUser;
	}



	public void setServiceUser(UserServiceLocal<Utilisateur> serviceUser) {
		this.serviceUser = serviceUser;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public void setServiceSousCategorie(CommanServiceLocal<SousCategorie> serviceSousCategorie) {
		this.serviceSousCategorie = serviceSousCategorie;
	}



	public ShopOwner getShopOwner() {
		return shopOwner;
	}



	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}



}